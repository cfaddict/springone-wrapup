// strings
def msg = "Hello Groovy!"

// arrays (ArrayList)
def people = ["Dan","Lance","Sam","Chris","Nate"]

// maps (HashMap) (Structs from the CF World)
def person = [first:"Dan",last:"Vega",city:"Cleveland"]

// closures
def saySomething = { 
    println "${it}"
}

// output 
println msg
println people
println person
saySomething 'Closures are cool!'