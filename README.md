# Clack
Payton Shafer and Ryan Quirk

In your test classes, what happens if you provide a negative value for a port number, or a null value for a user? How do you think you can fix these issues?
A negative value as the port number just makes it so the value of the port is negative. When there is a null value for the user it messes with the hashcode because there is no hashcode for a null value. We could put in a test to make sure the inputs are the correct form.

data:
ClackData:

MessageClackData:

FileClackData:


main:
ClackClient:
/**
 * The ClackClient class represents the client user
 * The class holds the data of the client
 */
public class ClackClient

/**
* This is a constructor for the ClackClient class
* @param u This is the username for the client
* @param h This is the hostname the client is connected to
* @param p This is the port number the client is connected to
*/
public ClackClient(String u, String h, int p)

/**
* This is a constructor for the ClackClient class
* @param u This is the username for the client
* @param h This is the hostname the client is connected to
*/
public ClackClient(String u, String h)

/**
* This is a constructor for the ClackClient class
* @param u This is the username for the client
*/
public ClackClient(String u)

/**
* This is the default constructor
*/
public ClackClient()

/**
* This functions returns the clients username
* @return This returns the clients username
*/
public String getUserName()

/**
* This functions returns the clients hostname
* @return This returns the clients hostname
*/
public String getHostName()

/**
* This functions returns the clients port
* @return This returns the clients port
*/
public int getPort()

/**
* This is a function to override hash code for the ClackClient object
* @return This returns a hash code such that equal objects have the same hash code
*/
public int hashCode()

/**
* This is a function to override the equals function for the ClackClient object
* @param obj This represents the other object the client is being compared to
* @return This returns true or false for whether the clients are equal
*/
public boolean equals(Object obj)

/**
* This is a function to override the toString function for the ClackClient object
* @return This returns the client as a string such that it can be printed out
*/
public String toString()

ClackServer
