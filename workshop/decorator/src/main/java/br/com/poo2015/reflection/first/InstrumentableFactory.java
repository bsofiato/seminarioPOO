package br.com.poo2015.reflection.first;

import java.lang.reflect.Method;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class InstrumentableFactory {
  public static <Type> Type newInstance(Class <? extends Type> klass) throws Exception {
    ProxyFactory proxy = new ProxyFactory();
    proxy.setInterfaces(new Class [] { Instrumentable.class });
    proxy.setSuperclass(klass);
    
    return (Type) (proxy.create(new Class[0], new Object[0], new MethodHandler() {
      private InvocationListener listener;
      @Override
      public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
         if (thisMethod.getName().equals("setInvocationListener")) { 
          this.listener = (InvocationListener)(args[0]);
          return null;
        } else if (listener == null) {
          return proceed.invoke(self, args);
        } else {
          listener.enterContext(thisMethod, args);
          Object returnValue = proceed.invoke(self, args);
          listener.exitContext(thisMethod, args, returnValue);
          return returnValue;
        }
      }
    }));
  }
}
