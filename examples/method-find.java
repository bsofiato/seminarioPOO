StackTraceElement[] pilha = Thread.currentThread().getStackTrace(); 
StackTraceElement ultimoMetodo = pilha[1]; 
System.out.println("O metodo " + ultimoMetodo.geMethodName()
	+ " foi chamado pela classe " + ultimoMetodo.getClassName()
	+ " na linha " + ultimoMetodo.getLineNumber()); 
