// We can't add method to a class by default (at least like this)
class Person {
    String name
}

Person p = new Person()
p.name = "Dan"
p.greet = { println "Hello ${name}" }
p.greet()

/*--------------------------------------------------------------------------------------------*/

http://groovy.codehaus.org/api/groovy/util/Expando.html
Expando ex = new Expando()
println ex 

// show that it has no methods or properties

ex.name = "Dan"
ex.greet = { println "Hello ${name}!" }

ex.greet()
println ex.class.name

/*--------------------------------------------------------------------------------------------*/

// expandoMetaClass
// every class in groovy has a metaclass
// these are instance methods for all Dogs
// you can do this per instance method
class Dog {

}
Dog.metaClass.name = 'Fido'
Dog.metaClass.speak = { println 'Woof!' }
Dog dog = new Dog()
dog.speak() 

/*--------------------------------------------------------------------------------------------*/


// what about a class we didn't define
String msg = 'hello world'

// every closure in groovy has a property called delegate 
// which points to the object that the closure was called on
String.metaClass.shout = { ->
    delegate.toUpperCase()
}

msg.shout()

// java.lang.String is Final - How cool is that?