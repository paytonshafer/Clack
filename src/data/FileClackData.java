package data;

public class FileClackData extends ClackData {
    private String fileName;
    private String fileContents;

    public FileClackData(String userName, String fileName, int type) {
        super(userName, type);
        this.fileName = fileName;
        this.fileContents = null;
    }

    public FileClackData () {
        super();
        this.fileName = null;
        this.fileContents = null;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getData() {
        return writeFileContents();
    }

    public void readFileContents() {}
    public String writeFileContents() { return "";}

    public String toString() {
        return "The Username is: " + super.getUserName() + "\n" +
                "The Type is: " + super.getType() + "\nThe File Name is: " +
                this.fileName + "\nThe File Contents are: " + this.fileContents + "\n\n";
    }

    public int hashCode(){
        return super.getUserName().hashCode() + super.getType() +
                this.fileName.hashCode() + this.fileContents.hashCode();
    }

    public boolean equals(Object other) {
        FileClackData otherData = (FileClackData)  other;
        return super.getUserName() == otherData.getUserName() && super.getType()
                == otherData.getType() && this.fileName == otherData.fileName &&
                this.fileContents == otherData.fileContents;
    }
}