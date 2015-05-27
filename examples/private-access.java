Class classe = objeto.getClass(); 
Field atributoPrivado = classe.getDeclaredField("segredo");
atributoPrivado.setAccessible(true);
System.out.println(atributoPrivado.get(objeto));