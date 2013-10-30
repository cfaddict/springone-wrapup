// Intercept-Cache-Invoke
class Person {
    
    def methodMissing(String name,args) {
        // intercept
        if( name == 'greet' ) {
            // define implementation
            def impl = {println "Hello ${args[0]}!"}
            // cache
            Person.metaClass."$name" = impl
            // invoke 
            impl(args)
        } else {
            println "No implementation for that method found."
        }
    }

}

def p = new Person()
p.greet("Dan Vega")
p.someOtherMethodName()