# Clack
Payton Shafer and Ryan Quirk

In your test classes, what happens if you provide a negative value for a port number, or a null value for a user? How do you think you can fix these issues?
A negative value as the port number just makes it so the value of the port is negative. When there is a null value for the user it messes with the hashcode because there is no hashcode for a null value. We could put in a test to make sure the inputs are the correct form.

###Testing

This is the output for testClackClient when sending a message, sending a file, and finally using the keyword DONE to terminate the session.

To see output best look at file in raw form
Testing ClackCLient and ClackServer with various parameters and on different computers
Output:

From Ryan's PC as Client, Payton's as Server
$ main.ClackClient user@128.153.172.227
Socket
Socket Established
Hello world!
The data is sent on Tue Nov 15 12:45:17 EST 2022.
The data is:
Hello world!
SENDFILE
hello.txt
The data is sent on Tue Nov 15 12:46:11 EST 2022.
The data is:
Hello!
DONE

Process finished with exit code 0

From Payton's PC as Cient, Ryann's as Server
paytonshafer@MacBook-Pro-4 src % java main/ClackClient User@128.153.167.162:1400
Socket Established
Hello
Hello
The data is sent from User.
The data is sent on Tue Nov 15 12:52:36 EST 2022.
The data is:
Hello
SEND_FILE hello.txt
The data is sent from User.
The data is sent on Tue Nov 15 12:52:47 EST 2022.
The data is:
SEND_FILE hello.txt
The data is sent from User.
The data is sent on Tue Nov 15 12:52:53 EST 2022.
The data is:
Hello!
DONE

Payton's PC as client and server
paytonshafer@MacBook-Pro-4 src % java main/ClackClient User@127.0.0.1           
Socket Established
Hello
The data is sent on Tue Nov 15 12:57:19 EST 2022.
The data is:
Hello
DONE
paytonshafer@MacBook-Pro-4 src % 

paytonshafer@MacBook-Pro-4 src % java main/ClackServer
Socket Established
paytonshafer@MacBook-Pro-4 src % 

Payton's PC as client and server
paytonshafer@MacBook-Pro-4 src % java main/ClackClient User          
Socket Established
Hello
The data is sent on Tue Nov 15 13:03:34 EST 2022.
The data is:
Hello
Goodbye
The data is sent on Tue Nov 15 13:03:39 EST 2022.
The data is:
Goodbye
DONE
paytonshafer@MacBook-Pro-4 src % 
