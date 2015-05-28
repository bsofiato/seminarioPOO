package br.com.poo2015.reflection.second;

import java.beans.Introspector;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Method;
import java.util.Observable;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;


public class PropertyChangeObservableFactory {
    private static class PropertyChangeObservableMethodHandler implements MethodHandler {
        private final PropertyChangeSupport support;

        public PropertyChangeObservableMethodHandler(Object target) {
            this.support = new PropertyChangeSupport(target);
        }

        @Override
        public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
            if (thisMethod.getName().equals("addPropertyChangeListener")) {
                this.support.addPropertyChangeListener((PropertyChangeListener)(args[0]));
                return null;
            } else if (thisMethod.getName().startsWith("set")) {
                String getterName = getGetterName(thisMethod);
                String propertyName = getPropertyName(thisMethod);
                Method getter = self.getClass().getMethod(getterName);
                Object oldValue = getter.invoke(self);
                proceed.invoke(self, args);
                this.support.firePropertyChange(propertyName, oldValue, args[0]);
                return null;
            } else {
                return proceed.invoke(self, args);
            }
         }

        private String getGetterName(Method setter) {
            return setter.getName().replaceFirst("set", "get");
        }

        private String getPropertyName(Method thisMethod) {
            return Introspector.decapitalize(thisMethod.getName().substring(3)); //To change body of generated methods, choose Tools | Templates.
        }
        
        
        
    }
    public static <Type> Type newObservableInstance(Class <Type> type) throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setSuperclass(type);
        proxyFactory.setInterfaces(new Class[] { PropertyChangeObservable.class });
        ProxyObject object = (ProxyObject) proxyFactory.create(new Class[0], new Object [0]);
        object.setHandler(new PropertyChangeObservableMethodHandler(object));
        return (Type)(object);
    }
}
