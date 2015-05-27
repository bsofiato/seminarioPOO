InvocationHandler handler = new MyInvocationHandler(...);
ClassLoader loader = Foo.class.getClassLoader();
Class proxyClass = Proxy.getProxyClass(loader, 
                                       new Class[] {Foo.class});
Foo f = (Foo) proxyClass
    .getConstructor(new Class[] {InvocationHandler.class})
    .newInstance(new Object[] {handler});