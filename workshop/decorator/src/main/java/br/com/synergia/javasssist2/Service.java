package br.com.synergia.javasssist2;

public class Service {
  public String hello(String name) {
    try {
      Thread.sleep((long)(Math.random() * 500));
      return "Hello " + name;
    } catch (Exception ex) {
      throw new RuntimeException();
    }
  }
}
