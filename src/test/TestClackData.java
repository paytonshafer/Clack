package test;


import data.FileClackData;
import data.MessageClackData;

public class TestClackData {
    public static void main(String args[]) {
        MessageClackData messageData1 = new MessageClackData("JohnDoe", "Hey, I'm John Doe!", 2);
        MessageClackData messageData2 = new MessageClackData("JohnDoe", "Hey, I'm John Doe!", 2);
        FileClackData fileData = new FileClackData("JohnDoe", "IMPORTANTFILE", 4 );

        MessageClackData nullMData = new MessageClackData();
        FileClackData nullFData = new FileClackData();

        nullFData.setFileName("NewFile");

        System.out.println("The Username of John's message data: " + messageData1.getUserName());
        System.out.println("The Type of the file data: " + fileData.getType());
        System.out.println("The Filename of the nullFData: " + fileData.getFileName());
        System.out.println("+\n+\n");
        System.out.println("messageData1 equals messageData2: " + messageData1.equals(messageData2));
        System.out.println("fileData equals nullFdata: " + fileData.equals(nullFData));
        System.out.println("+\n+\n");
        System.out.println("The data from John's message is: " + messageData1.getData());
        System.out.println("The data from fileData is: " + fileData.getData());
        System.out.println("+\n+\n");
        System.out.println("messageData1's hashcode is: " + messageData1.hashCode());
        System.out.println("messageData2's hashcode is: " + messageData1.hashCode());
        System.out.println("fileData's hashcode is: " + fileData.hashCode());
        System.out.println("nullFData's hashcode is: " + nullFData.hashCode());



    }
}
