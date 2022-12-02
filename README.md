# Clack
Payton Shafer and Ryan Quirk

In your test classes, what happens if you provide a negative value for a port number, or a null value for a user? How do you think you can fix these issues?
A negative value as the port number just makes it so the value of the port is negative. When there is a null value for the user it messes with the hashcode because there is no hashcode for a null value. We could put in a test to make sure the inputs are the correct form.

Explain why there should be a separate class to receive data from the server and print it, and the client only gets data from the user and sends it to the server. Also, why is the class called a ‘listener’?
This is so the server can just deal with managing clients and has the other classes to deal with the data. This is called a listener since it waits for something to happen before executing anything.

Explain why you need a separate thread for each client, and why you cannot handle all clients in the main server thread. Conceptually, why is the listener class ‘ClientSideServerListener’ different from the class ‘ServerSideClientIO’?
This is so clients can work independtly of eachother and clients can be removed and added easily.

Explain why the broadcast() and remove() methods are synchronized.
They are syncronized since they both work with the same reasources, the list of clients. So they must be syncronized so they dont try to do things at the same time.

Discuss all new methods and new code in existing methods that you wrote to handle LISTUSERS.


###Testing

This is the output for testClackClient when sending a message, sending a file, and finally using the keyword DONE to terminate the session.

To see output best look at file in raw form
Testing ClackCLient and ClackServer with various parameters and on different computers
Output:

Payton's is Server and Client1, Ryan has Client2:


Ryan's is Server and Client1, Payton has Client2:
