package data;

import java.util.Date;

/**
* The ClackData class is an abstract class used to shape the FileClackData and MessageClackData.
* */
public abstract class ClackData {
    public final int CONSTANT_LISTUSERS = 0;
    public final int CONSTANT_LOGOUT = 1;
    public final int CONSTANT_SENDMESSAGE = 2;
    public final int CONSTANT_SENDFILE = 3;

    private String username;
    private int type;
    private Date date;

    /**
     * This is the main constructor for ClackData.
     * @param userName
     * @param type
     */
    public ClackData(String userName, int type) {
        this.username = userName;
        this.type = type;
        this.date = new Date();
    }

    /**
     * This is a special constructor that if used creates an anonymous user.
     * This constructor is called when a ClackData object is instantiated without
     * defining a username.
     *
     * In this case the username is defaulted to the value 'anon'
     * @param type
     */
    public ClackData(int type) {
        this("Anon", type);
    }

    /**:w
     * 
     * Default constructor.
     * Sets all variables to null.
     */
    public ClackData () {
        this.username = "";
        this.type = -1;
        this.date = new Date();
    }

    /**
     * Accessor function for variable type.
     * @return type
     */
    public int getType() {
        return this.type;
    }

    /**
     * Accessor function for variable username.
     * @return username
     */
    public String getUserName() {
        return this.username;
    }

    /**
     * Accessor function for variable date.
     * @return date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Abstract class that returns the data a subclass is carrying.
     * @return data
     */
    public abstract String getData();
}
