class Person {

    String first
    String last
    String email
    Date dob
    
    String toString(){
        "${first} ${last}"
    }

}

def p = new Person(first:"Dan",last:"Vega",email:"danvega@gmail.com",dob:new Date())
println p