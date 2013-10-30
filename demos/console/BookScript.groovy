import com.firstcomp.Book

def b = new Book(title:"Programming Groovy 2",author:"Venkat")
println b

//==========================================================================================

import com.firstcomp.Book

def b = new Book(title:"Programming Groovy 2",author:"Venkat Subramaniam").save()
def b1 = new Book(title:"Programming Grails",author:"Burt Beckwith").save()
def b2 = new Book(title:"The Definitive Guide to Grails 2",author:"Jeff Scott Brown").save()

println Book.list()


//==========================================================================================

import com.firstcomp.Book

def books = Book.list()

books.each { 
    println it 
}