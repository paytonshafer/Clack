package data;

import java.util.Date;

public abstract class ClackData {
    public final int CONSTANT_LISTUSERS = 0;
    public final int CONSTANT_LOGOUT = 1;
    public final int CONSTANT_SENDMESSAGE = 2;
    public final int CONSTANT_SENDFILE = 3;

    private String username;
    private int type;
    private Date date;

    public ClackData(String userName, int type) {
        this.username = userName;
        this.type = type;
        this.date = new Date();
    }

    public ClackData(int type) {
        this("Anon", type);
    }

    public ClackData () {
        this.username = null;
        this.type = -1;
    }

    public int getType() {
        return this.type;
    }

    public String getUserName() {
        return this.username;
    }

    public Date getDate() {
        return this.date;
    }

    public abstract ClackData getData();
}
