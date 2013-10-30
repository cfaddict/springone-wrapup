import groovy.transform.ToString

@ToString(includeNames=true)
@ToString(excludes="id")
class Person {
    int id
    String first
    String last
}

def p = new Person(id:1,first:"Dan",last:"Vega")
println p