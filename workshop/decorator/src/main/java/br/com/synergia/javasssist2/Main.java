package br.com.synergia.javasssist2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class Main {
  
  public static void main(String [] args) throws Exception {
    //Service object = InstrumentableFactory.newInstance(Service.class);
    List object = InstrumentableFactory.newInstance(ArrayList.class);
    object.add("teste");
    while (true) {
      if (Math.random() < 0.5) {
        ((Instrumentable)(object)).setInvocationListener(new Logger());
      } else {
        ((Instrumentable)(object)).setInvocationListener(new PerformanceLogger());
      }
      //System.out.println(object.hello("BRUNO"));
      System.out.println(object.size());
      Thread.sleep(500L);
    }
  }
}
