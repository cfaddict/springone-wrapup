class Person implements GroovyInterceptable {
    
    String name
    
    def invokeMethod(String name,args) {
        System.out.println "called invokeMethod $name $args"
        
        def validMethod = Person.metaClass.getMetaMethod(name,args)
        
        if( validMethod != null ) {
            validMethod.invoke(this,args)
        } else {
            System.out.println "invalid method"
        }
    }
        
    def greet() {
        System.out.println "Hello $name"
    }

}

def p = new Person()
p.name = "Dan"
p.greet()
p.foo()


