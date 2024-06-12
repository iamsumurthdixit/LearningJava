public class DBConnectionLazy {
    private static DBConnectionLazy conObj;   // LOCATION 1

    private DBConnectionLazy() {}

    public static DBConnectionLazy getInstance() {
        if(conObj == null) {                   // LOCATION 2
            conObj = new DBConnectionLazy();
        }
        return conObj;
    }
}
// disadvantage of using Lazy:
// when 2 threads come together at each LOCATION 1, 2, both will create a new conObj, so 2 objects will get created,
// to overcome this problem, synchronized is used that puts a lock