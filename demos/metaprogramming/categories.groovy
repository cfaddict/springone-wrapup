// methods must be static and take at least 1 parameter (self)
class StringUtils {
    
    def static formatPhone(self) {
        if( self.size() == 10 ) {
            println "(${self[0..2]})-${self[3..5]}-${self[6..9]}"
        }
    }
    
    def static dollarFormat(self) {
        println "\$${self}"
    }

    def static shout(self,addExclamation) {
        def msg = "${self.toUpperCase()}"
        if( addExclamation ) {
            msg += "!"
        }
        println msg
    }
}

// to use our new method call a special method called use()
// takes 2 parameters.. a category and a closure block 
// within which the injected methods will be available
use(StringUtils) {
    "2165551212".formatPhone()
    "19.99".dollarFormat()
    "hello firstcomp".shout(true)
}

// the methods we injected were only available in the closure block
try {
    "6045551234".formatPhone()
} catch(MissingMethodException ex) {
    println ex.message
}