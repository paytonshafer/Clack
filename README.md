# Clack
### Payton Shafer and Ryan Quirk

Explain why there should be a separate class to receive data from the server and print it, and the client only gets data from the user and sends it to the server. Also, why is the class called a ‘listener’?
This is so the server can just deal with managing clients and has the other classes to deal with the data. This is called a listener since it waits for something to happen before executing anything.

Explain why you need a separate thread for each client, and why you cannot handle all clients in the main server thread. Conceptually, why is the listener class ‘ClientSideServerListener’ different from the class ‘ServerSideClientIO’?
This is so clients can work independtly of eachother and clients can be removed and added easily. The listener class waits for the server side class to send it information. It is there to wait and listen for something to do.

Explain why the broadcast() and remove() methods are synchronized.
They are syncronized since they both work with the same reasources, the list of clients. So they must be syncronized so they dont try to do things at the same time which could lead to incorrect interleaving. Synchronization will prevent the inccorect interleaving.

Discuss all new methods and new code in existing methods that you wrote to handle LISTUSERS.
The first new code implemented, was the handling of a listusers message in the readData function for the client and the receiveData function for the server.
For the readData function, an empty message is sent to the server with the constant type LISTUSERS. As for the receiveData function on the server end,
a messageClackData object is immediately made and sent back to the user within the receiveData function. The message within the object is the user list,
which is retrieved from the new function getList(). The getList function creates the list of users and returns it as a String for the message. 
The last code implemented, is on the first message received from a new client, the server fills in the userName instance variable with the username attached to the messageData. This is how the getList function is able to iterate through the client list and get all users' names. 


### Testing

This is the output for testClackClient when sending a message, sending a file, and finally using the keyword DONE to terminate the session.

To see output best look at file in raw form
Testing ClackCLient and ClackServer with various parameters and on different computers
Output:

Payton's is Server and Client1, Ryan has Client2:


Ryan's Client output:

Socket Established
Hello!
The data was sent by ryan
The data is sent on Sat Dec 03 16:02:53 EST 2022.
The data is:
Hello!
The data was sent by payton
The data is sent on Sat Dec 03 16:03:03 EST 2022.
The data is:
Hello!
LISTUSERS
The data was sent by Server
The data is sent on Sat Dec 03 16:03:09 EST 2022.
The data is:

USER LIST

1. ryan
2. payton

LISTUSERS
The data was sent by Server
The data is sent on Sat Dec 03 16:03:19 EST 2022.
The data is:

USER LIST

1. ryan

DONE
Socket Closed

Process finished with exit code 0

Paytons:
Socket Established
The data was sent by ryan
The data is sent on Sat Dec 03 16:02:53 EST 2022.
The data is:
Hello!
SENDFILE hello.txt
The data was sent by payton
The data is sent on Sat Dec 03 16:03:03 EST 2022.
The data is:
Hello!
DONE
Socket Closed

Process finished with exit code 0

Ryan's is Server and Client1, Payton has Client2:
Paytons:
Socket Established
Hello
The data was sent by payton
The data is sent on Sat Dec 03 16:00:20 EST 2022.
The data is:
Hello
The data was sent by user
The data is sent on Sat Dec 03 16:00:22 EST 2022.
The data is:
Hey
LISTUSERS
The data was sent by Server
The data is sent on Sat Dec 03 16:00:32 EST 2022.
The data is:

USER LIST

1. user
2. payton

LISTUSERS
The data was sent by Server
The data is sent on Sat Dec 03 16:00:47 EST 2022.
The data is:

USER LIST

1. payton

DONE
Socket Closed

Process finished with exit code 0

Ryan's Client output:

Socket Established
The data was sent by payton
The data is sent on Sat Dec 03 16:00:20 EST 2022.
The data is:
Hello
Hey
The data was sent by user
The data is sent on Sat Dec 03 16:00:22 EST 2022.
The data is:
Hey
DONE
Socket Closed

Process finished with exit code 0

