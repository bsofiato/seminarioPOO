package br.com.poo2015.reflection.first;

import java.util.HashSet;
import java.util.Set;

public class Main {
  
  public static void main(String [] args) throws Exception {
    //Service object = InstrumentableFactory.newInstance(Service.class);
    Set object = InstrumentableFactory.newInstance(HashSet.class);
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
