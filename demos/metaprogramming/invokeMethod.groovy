// basic example
class Person implements GroovyInterceptable {
    
    String name
    
    def invokeMethod(String name,args) {
        System.out.println "called invokeMethod $name $args"
    }
        
    def greet() {
        System.out.println "Hello $name"
    }

}

def p = new Person()
p.name = "Dan"
p.greet()

/*--------------------------------------------------------------------------------------------*/

// How about calling the method now
// System.out.println *** println method call
class Person implements GroovyInterceptable {
    
    String name
    
    def invokeMethod(String name,args) {
        System.out.println "called invokeMethod $name $args"
        
        greet()
        //Person.metaClass.getMetaMethod(name).invoke(this,args)
    }
        
    def greet() {
        System.out.println "Hello $name"
    }

}

def p = new Person(name:"Dan Vega")
p.greet()


/*--------------------------------------------------------------------------------------------*/

// add to it
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

// dynamic method added at runtime
Person.metaClass.dm = { println "dynamic method" }
p.dm()


/*--------------------------------------------------------------------------------------------*/


// AOP example
class Person implements GroovyInterceptable {
    
    // AOP programming
    def before(args){ System.out.println "before advice" }
    def after(args) { System.out.println "after advice" }
    
    def invokeMethod(String name,args) {
        // before advice
        Person.metaClass.getMetaMethod('before').invoke(this,args);
        
        // we would replace this with some call to our method
        System.out.println "called invokeMethod $name($args)"
        
        // after advice 
        Person.metaClass.getMetaMethod('after').invoke(this,args);
    }

}

def p = new Person()
p.someMethod("foo")

/*--------------------------------------------------------------------------------------------*/


// What about when we don't have access to the source code
class Person {
    
    String first
    String last
    
    def getFullName() { System.out.println "${first} ${last}" }
    
}

Person.metaClass.invokeMethod = { String name, args -> 
   System.out.println "called invokeMethod $name($args)"
}

def p = new Person(first:"Dan",last:"Vega")
p.getFullName()

