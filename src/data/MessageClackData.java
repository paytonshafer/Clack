package data;

import sun.plugin2.message.Message;

public class MessageClackData extends ClackData {

    private String message;

    public MessageClackData(String userName, String message, int type) {
        super(userName, type);
        this.message = message;
    }

    public MessageClackData () {
        super();
        this.message = "";
    }

    public String getData () {
        return message;
    }

    public String toString() {
        return "The Username is: " + super.getUserName() + "\n" +
                "The Type is: " + super.getType() + "\nThe Message is: " +
                this.message + "\n\n";
    }

    public int hashCode(){
       return super.getUserName().hashCode() + super.getType() + this.message.hashCode();
    }

    public boolean equals(Object other) {
        MessageClackData otherData = (MessageClackData) other;
        return super.getUserName() == otherData.getUserName() && super.getType()
                == otherData.getType() && this.message == otherData.message;
    }
}
