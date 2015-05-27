ClassPool pool = ClassPool.getDefault();
CtClass cc = pool.get("Point");
CtMethod m = cc.getDeclaredMethod("move");
m.insertBefore("{ 
                    System.out.println($1); 
                    System.out.println($2); 
                }");
cc.writeFile();