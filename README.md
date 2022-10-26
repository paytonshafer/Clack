# Clack
Payton Shafer and Ryan Quirk

In your test classes, what happens if you provide a negative value for a port number, or a null value for a user? How do you think you can fix these issues?
A negative value as the port number just makes it so the value of the port is negative. When there is a null value for the user it messes with the hashcode because there is no hashcode for a null value. We could put in a test to make sure the inputs are the correct form.

data:
ClackData:
/**
* The ClackData class is an abstract class used to shape the FileClackData and MessageClackData.
* */
public abstract class ClackData

/**
* This is the main constructor for ClackData.
* @param userName
* @param type
*/
public ClackData(String userName, int type)

/**
* This is a special constructor that if used creates an anonymous user.
* This constructor is called when a ClackData object is instantiated without
* defining a username.
*
* In this case the username is defaulted to the value 'anon'
* @param type
*/
public ClackData(int type)

/**
* Default constructor.
* Sets all variables to null.
*/
public ClackData ()

/**
* Accessor function for variable type.
* @return type
*/
public int getType()

/**
* Accessor function for variable username.
* @return username
*/
public String getUserName()

/**
* Accessor function for variable date.
* @return date
*/
public Date getDate()

/**
     * This is a function that will encrypt a string using the Vigenère cipher
     * @param inputStringToEncrypt the string to be encrypted
     * @param key the key for the encryption
     * @return the encrypted string
     */
    protected String encrypt(String inputStringToEncrypt, String key)
    
/**
     * This is a function that will decrypt a string using the Vigenère cipher
     * @param inputStringToDecrypt the string to be decrypted
     * @param key the key for the decryption
     * @return the decrypted string
     */
    protected String decrypt(String inputStringToDecrypt, String key)

/**
* Abstract class that returns the data a subclass is carrying.
* @return data
*/
public abstract String getData()

MessageClackData:
/**
 * The class MessageClackData holds all data regarding messages being
 * sent by users.
 */
public class MessageClackData extends ClackData

/**
* Main constructor for the class.
*
* Calls the super constructor for variables username and type.
* @param userName
* @param message
* @param type
*/
public MessageClackData(String userName, String message, int type)

/**
* Default constructor.
* All values set to null.
*/
public MessageClackData

/**
* Returns the data of the class.
*
* In this case the data is the message value.
* @return message
*/
public String getData ()

/**
* Overloading the toString() function.
*
* The function returns a string displaying all variables of the MessageClackData
* object.
* @return details about object
*/
public String toString()

/**
* Overloaded hashCode() function.
*
* It returns a unique hash code for each unique object.
* @return hash code
*/
public int hashCode()

/**
* Overloaded equals() function.
*
* Will return a boolean value corresponding to whether the two objects
* are equivalent or not.
* @param other
* @return True or False
*/
public boolean equals(Object other)

FileClackData:
/**
 * The class FileClackData holds the data for files being transfered by users.
 */
 
/**
* Main constructor for the class.
* @param userName
* @param fileName
* @param type
*/
public FileClackData

/**
* Default constructor for the class.
* Everything is set to null.
*/
public FileClackData

/**
* Mutator function for variable fileName.
* @param fileName
*/
public void setFileName(String fileName)

/**
* Accessor function for variable fileName.
* @return fileName
*/
public String getFileName()

/**
* Accessor function for data held in class.
*
* In this case the data is the contents of the file, therefore
* it calls the accessor function writeFileContents().
* @return data/fileContents
*/
public String getData()

/**
     * Accessor function that returns decrypted fileContents
     *
     * @param key
     * @return
     */
    public String getData(String key)
    
/**
* Function will take the file name and read the contents of
* the file.
*/
public void readFileContents()

/**
     * Function will take the file name and write the encrypted
     * contents of the file into fileContents.
     * @param key
     * @throws IOException
     */
    public void readFileContents(String key) throws IOException

/**
 * Function will take the opened file, and print the contents of the file.
 */
public void writeFileContents()

/**
     * Function opens file and writes the decrypted fileContent into the file.
     * @param key
     */
    public void writeFileContents(String key)
    
/**
* Overloading the toString() function.
*
* The function returns a string displaying all variables of the FileClackData
* object.
* @return details about object
*/
public String toString()

/**
* Overloaded hashCode() function.
*
* It returns a unique hash code for each unique object.
* @return hash code
*/
public int hashCode()

/**
* Overloaded equals() function.
*
* Will return a boolean value corresponding to whether the two objects
* are equivalent or not.
* @param other
* @return True or False
*/
public boolean equals(Object other)

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

ClackServer:
**
 * The ClackServer class represents the server that clients connect to
 * This class holds data for the server
 */
public class ClackServer

    /**
     * This is a constructor for the ClackServer class
     * @param p This is the port number a client connects to
     */
    public ClackServer(int p)

    /**
     * This is the default constructor for the ClackServer class
     */
    public ClackServer()
    
    /**
     * This functions returns the port number
     * @return This returns the port number
     */
    public int getPort()
    
    /**
     * This is a function to override hash code for the ClackServer object
     * @return This returns a hash code such that equal objects have the same hash code
     */
    public int hashCode()
    
    /**
     * This is a function to override the equals function for the ClackServer object
     * @param obj This represents the other object the server is being compared to
     * @return This returns true or false for whether the servers are equal
     */
    public boolean equals(Object obj)
    
    /**
     * This is a function to override the toString function for the ClackServer object
     * @return This returns the server as a string such that it can be printed out
     */
    public String toString()
    
## Testing

We created a test package that includes three classes: TestClackClient, TestClackServer and TestClackData. Their only purpose is to test ClackClient class, ClackServer class and the data classes respectively.


### Testing

This is the output for testClackClient when sending a message, sending a file, and finally using the keyword DONE to terminate the session.

The username of client 1 is douglas

The hostname of the server is thomas

The port humber is 1025

client 1 and client 2 are equal

client 1 and client 3 are not equal

The hash code of client 1 is -1816342652

The hash code of client 2 is -1816342652

The hash code of client 3 is 1138565120

The client's username is douglas.

The current host Name is thomas.

The current port number is 1025.

The current status of the connection being closed is false.

The data sent to the server is:

null

The data received from the server is:

null

Message

The data is sent from douglas.

The data is sent on Wed Oct 26 16:12:20 EDT 2022.

The data is:

Message

SENDFILE

hello.txt

The data is sent from douglas.

The data is sent on Wed Oct 26 16:12:41 EDT 2022.

The data is:

Hello!

DONE

The data is sent from douglas.

The data is sent on Wed Oct 26 16:12:41 EDT 2022.

The data is:

Hello!

Process finished with exit code 0
