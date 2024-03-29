package data;


/**
 * The class MessageClackData holds all data regarding messages being
 * sent by users.
 */
public class MessageClackData extends ClackData {

    private String message;

    /**
     * Main constructor for the class.
     *
     * Calls the super constructor for variables username and type.
     * @param userName
     * @param message
     * @param type
     */
    public MessageClackData(String userName, String message, int type) {
        super(userName, type);
        this.message = message;
    }

    /**
     * Main constructor for the class, with encryption key.
     *
     * Calls the super constructor for variables username and type.
     * @param userName
     * @param message <-- gets encrypted using the key variable
     * @param key
     * @param type
     */
    public MessageClackData(String userName, String message, String key, int type) {
        super(userName, type);
        this.message = super.encrypt(message, key);
    }

    /**
     * Default constructor.
     * All values set to null.
     */
    public MessageClackData () {
        super();
        this.message = "";
    }

    /**
     * Returns the data of the class.
     *
     * In this case the data is the message value.
     * @return message
     */
    public String getData () {
        return message;
    }

    /**
     * Decrypts then returns the data of the class.
     *
     * @param key
     * @return message
     */
    public String getData (String key) {
        return super.decrypt(message, key);
    }

    /**
     * Overloading the toString() function.
     *
     * The function returns a string displaying all variables of the MessageClackData
     * object.
     * @return details about object
     */
    public String toString() {
        return "The Username is: " + super.getUserName() + "\n" +
                "The Type is: " + super.getType() + "\nThe Message is: " +
                this.message + "\n\n";
    }

    /**
     * Overloaded hashCode() function.
     *
     * It returns a unique hash code for each unique object.
     * @return hash code
     */
    public int hashCode(){
       return super.getUserName().hashCode() + super.getType() + this.message.hashCode();
    }

    /**
     * Overloaded equals() function.
     *
     * Will return a boolean value corresponding to whether the two objects
     * are equivalent or not.
     * @param other
     * @return True or False
     */
    public boolean equals(Object other) {
        MessageClackData otherData = (MessageClackData) other;
        return super.getUserName() == otherData.getUserName() && super.getType()
                == otherData.getType() && this.message == otherData.message;
    }
}
