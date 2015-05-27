Class umaClasse = MinhaClasse.class; 
Field atributo = umaClasse.getField("umAtributo");
MinhaClasse instancia = new MinhaClasse();
Integer valor = (Integer)(field.get(instancia));
field.set(instancia, valor + 1); 