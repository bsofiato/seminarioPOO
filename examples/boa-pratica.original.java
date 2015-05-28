Class klass = Class.forName(name).newInstance();
Object object = k.newInstance();
Method closeMethod = k.getDeclaredMethod("close"); 
closeMethod.invoke(o); // Chamada de metodo reflexiva