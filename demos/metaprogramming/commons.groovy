// pull in our dependencies from Maven
@Grab(group='org.apache.commons', module='commons-email', version='1.3.1')

import org.apache.commons.mail.SimpleEmail

def email = new SimpleEmail(
    hostName:  "localhost",
    smtpPort:  2525,
    subject:   "Groovy Test",
    msg:       "This is a test"
)

email.setFrom("danvega@gmail.com","Dan Vega")
email.addTo("danvega@gmail.com","Dan Vega")
email.send()

println "Email Sent!"

//http://commons.apache.org/proper/commons-email/userguide.html