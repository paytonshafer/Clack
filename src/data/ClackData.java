package data;

import java.io.*;
import java.util.Date;
import java.lang.Math;

/**
* The ClackData class is an abstract class used to shape the FileClackData and MessageClackData.
* */
public abstract class ClackData implements Serializable {
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
    public abstract String getData(String key);

    /**
     * This is a function that will encrypt a string using the Vigenère cipher
     * @param inputStringToEncrypt the string to be encrypted
     * @param key the key for the encryption
     * @return the encrypted string
     */
    protected String encrypt(String inputStringToEncrypt, String key){
        char msg[] = inputStringToEncrypt.toCharArray();
        char keyArray[] = key.toCharArray();
        char keyString[] = new char[inputStringToEncrypt.length()];
        char encryptedString[] = new char[inputStringToEncrypt.length()];

        for(int i = 0, j = 0; i <= inputStringToEncrypt.length()-1; i++, j++){
            if(j == key.length())
                j = 0;

            if(65 <= msg[i] && msg[i] <= 90)//uppercase
                keyString[i] = Character.toUpperCase(keyArray[j]);
            else if(97 <= msg[i] && msg[i] <= 122)//lowercase
                keyString[i] = Character.toLowerCase(keyArray[j]);
            else
                keyString[i] = msg[i];
        }

        for(int i = 0; i <= inputStringToEncrypt.length()-1; i++){
            if(65 <= msg[i] && msg[i] <= 90)//uppercase
                encryptedString[i] = (char) ((((msg[i]-65)+(keyString[i]-65))%26)+65);
            else if(97 <= msg[i] && msg[i] <= 122)//lowercase
                encryptedString[i] = (char) ((((msg[i]-97)+(keyString[i]-97))%26)+97);
            else
                encryptedString[i] = msg[i];
        }

        return String.valueOf(encryptedString);
    }

    /**
     * This is a function that will decrypt a string using the Vigenère cipher
     * @param inputStringToDecrypt the string to be decrypted
     * @param key the key for the decryption
     * @return the decrypted string
     */
    protected String decrypt(String inputStringToDecrypt, String key){
        char msg[] = inputStringToDecrypt.toCharArray();
        char keyArray[] = key.toCharArray();
        char keyString[] = new char[inputStringToDecrypt.length()];
        char decryptedString[] = new char[inputStringToDecrypt.length()];

        for(int i = 0, j = 0; i <= inputStringToDecrypt.length()-1; i++, j++){
            if(j == key.length())
                j = 0;

            if(65 <= msg[i] && msg[i] <= 90)//uppercase
                keyString[i] = Character.toUpperCase(keyArray[j]);
            else if(97 <= msg[i] && msg[i] <= 122)//lowercase
                keyString[i] = Character.toLowerCase(keyArray[j]);
            else
                keyString[i] = msg[i];
        }

        for(int i = 0; i <= inputStringToDecrypt.length()-1; i++){
            if(65 <= msg[i] && msg[i] <= 90)//uppercase
                decryptedString[i] = (char) (((26+((msg[i]-65)-(keyString[i]-65)))%26)+65);
            else if(97 <= msg[i] && msg[i] <= 122)//lowercase
                decryptedString[i] = (char) (((26+((msg[i]-97)-(keyString[i]-97)))%26)+97);
            else
                decryptedString[i] = msg[i];
        }

        return String.valueOf(decryptedString);
    }
}
