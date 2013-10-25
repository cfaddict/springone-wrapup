import com.firstcomp.Book

def b = new Book(title:"Programming Groovy 2",author:"Venkat")
println b

//==========================================================================================

import com.firstcomp.Book

def b = new Book(title:"Programming Groovy 2",author:"Venkat").save()
def b1 = new Book(title:"Programming Grails",author:"Venkat").save()
def b2 = new Book(title:"The Definitive Guide to Grails 2",author:"Venkat").save()

println Book.list()


//==========================================================================================
