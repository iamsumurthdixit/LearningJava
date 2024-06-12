public class DBConnectionBillPugh {
    private DBConnectionBillPugh() {}

    private static class DBConnectionBillPughHelper {
        private static final DBConnectionBillPugh INSTANCE_OBJECT = new DBConnectionBillPugh();
    }
    public static DBConnectionBillPugh getInstance() {
        return DBConnectionBillPughHelper.INSTANCE_OBJECT;
    }
}

// all the nested classes are NOT loaded at the time of compilation, here, this whenever this static nested class will be used, only then object will be initialized and returned.
