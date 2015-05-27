package br.com.synergia.javasssist2;

import java.lang.reflect.Method;

public interface InvocationListener {
  void enterContext(Method method, Object [] args);
  void exitContext(Method method, Object [] args, Object returnValue);
}
