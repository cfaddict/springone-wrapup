// We can't add method to a class by default (at least like this)
class Person {
    String name
}

Person p = new Person()
p.name = "Dan"
p.greet = { println "Hello ${name}" }
p.greet()


// http://groovy.codehaus.org/api/groovy/util/Expando.html
Expando ex = new Expando()
ex.name = "Dan"
ex.greet = { println "Hello ${name}!" }

ex.greet()


// Every class in groovy has a property called metaClass 
// The metaClass is an Expando
def names = ["Dan","Nate","Jake","Brian"]
names.class

println String.metaClass.class.name

// expandoMetaClass
// every class in groovy has a method class
class Dog {

}
Dog.metaClass.name = 'Fido'
Dog.metaClass.speak = { println 'Woof!' }
Dog dog = new Dog()
dog.speak() 

// these are instance methods for all Dogs
// show a per instance method
// show a static method

// what about a class we didn't define
String msg = 'hello world'

// every closure in groovy has a property called delegate 
// which points to the object that the closure was called on
String.metaClass.shout = { ->
    delegate.toUpperCase()
}

msg.shout()