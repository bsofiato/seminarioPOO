package br.com.poo2015.reflection.first;

import java.lang.reflect.Method;
import java.util.Arrays;

public class PerformanceLogger implements InvocationListener {
  
  private long timestamp;
  
  @Override
  public void enterContext(Method method, Object[] args) {
    timestamp = System.currentTimeMillis();
  }

  @Override
  public void exitContext(Method method, Object[] args, Object returnValue) {
    long elapsed = System.currentTimeMillis() - timestamp;
    System.out.println("Invocacao do  metodo " + method.getName() + " com os argumentos " + Arrays.toString(args) + " levou " + elapsed + " ms");
  }
  
}
