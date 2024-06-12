public class DBConnectionEager {
    boolean connected;

    // this conObject belongs to class now because of static
    private static DBConnectionEager conObject = new DBConnectionEager();

    // cannot create object from outside
    private DBConnectionEager() {
        connected = false;
    }
    // method to used by outside classes to get the instance
    public static DBConnectionEager getInstance() {
        return conObject;
    }
    public boolean isActive() {
        return conObject.connected;
    }
    public void connectDB() {
        conObject.connected = true;
    }
    public void disConnectDB() {
        conObject.connected = false;
    }
}
