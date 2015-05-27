package br.com.poo2015.reflection.first;

import java.lang.reflect.Method;

public interface InvocationListener {
  void enterContext(Method method, Object [] args);
  void exitContext(Method method, Object [] args, Object returnValue);
}
