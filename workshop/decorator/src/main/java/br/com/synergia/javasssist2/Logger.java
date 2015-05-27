package br.com.synergia.javasssist2;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Logger implements InvocationListener {
  
  @Override
  public void enterContext(Method method, Object[] args) {
    System.out.println("Invocando metodo " + method.getName() + " com os argumentos " + Arrays.toString(args));
  }

  @Override
  public void exitContext(Method method, Object[] args, Object returnValue) {
    System.out.println("Invocacao do metodo " + method.getName() + " com os argumentos " + Arrays.toString(args) + " retornou \"" + returnValue + "\"");
  }
}
