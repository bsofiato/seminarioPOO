Class klass = Class.forName(name).newInstance();
Closeable closeableInstance = (Closeable)(k.newInstance());
closeableInstance.close(); //Chamada de metodo convencional
