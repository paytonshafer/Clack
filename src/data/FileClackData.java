package data;
import java.io.*;

/**
 * The class FileClackData holds the data for files being transfered by users.
 */
public class FileClackData extends ClackData {
    private String fileName;
    private String fileContents;

    /**
     * Main constructor for the class.
     * @param userName
     * @param fileName
     * @param type
     */
    public FileClackData(String userName, String fileName, int type) {
        super(userName, type);
        this.fileName = fileName;
        this.fileContents = "";
    }

    /**
     * Default constructor for the class.
     * Everything is set to null.
     */
    public FileClackData () {
        super();
        this.fileName = "";
        this.fileContents = "";
    }

    /**
     * Mutator function for variable fileName.
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Accessor function for variable fileName.
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Accessor function for data held in class.
     *
     * In this case the data is the contents of the file, therefore
     * it calls the accessor function writeFileContents().
     * @return data/fileContents
     */
    public String getData() {
        return fileContents;
    }
    public String getData(String key) {
        return super.decrypt(this.fileContents, key);
    }

    /**
     * Function will take the file name and read the contents of
     * the file.
     */
    public void readFileContents() {
        File file = new File(this.fileName);
        String nextLine = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            while ((nextLine = bufferedReader.readLine()) != null) {
                fileContents += nextLine;
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("File does not exist");
        } catch (IOException ioe) {
            System.err.println("IOException occurred");
        }
    }
    public void readFileContents(String key) throws IOException {
        File file = new File(this.fileName);
        String nextLine = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            while ((nextLine = super.encrypt(bufferedReader.readLine(), key)) != null) {
                fileContents += nextLine;
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("File does not exist");
        } catch (IOException ioe) {
            System.err.println("IOException occurred");
        }
    }
    /**
     * Function will take the opened file, and print the contents of the file.
     */
    public void writeFileContents() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(this.fileName));
            out.write(fileContents);
        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found!");
        } catch (IOException ioe) {
            System.err.println("IOException");
        }
    }

    public void writeFileContents(String key) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(this.fileName));
            out.write(this.decrypt(this.fileContents, key));
        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found!");
        } catch (IOException ioe) {
            System.err.println("IOException");
        }
    }

    /**
     * Overriding the toString() function.
     *
     * The function returns a string displaying all variables of the FileClackData
     * object.
     * @return details about object
     */
    public String toString() {
        return "The Username is: " + super.getUserName() + "\n" +
                "The Type is: " + super.getType() + "\nThe File Name is: " +
                this.fileName + "\nThe File Contents are: " + this.fileContents + "\n\n";
    }

    /**
     * Overriding hashCode() function.
     *
     * It returns a unique hash code for each unique object.
     * @return hash code
     */
    public int hashCode(){
        return super.getUserName().hashCode() + super.getType() +
                this.fileName.hashCode() + this.fileContents.hashCode();
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
        FileClackData otherData = (FileClackData)  other;
        return super.getUserName() == otherData.getUserName() && super.getType()
                == otherData.getType() && this.fileName == otherData.fileName &&
                this.fileContents == otherData.fileContents;
    }
}