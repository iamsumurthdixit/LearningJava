public class DBConnectionDouble {
    private static volatile DBConnectionDouble conObj;

    private DBConnectionDouble() {}

    public static DBConnectionDouble getInstance() {
        if (conObj == null) { // check 1
            synchronized (DBConnectionDouble.class) { // putting lock on entire `class object`
                if (conObj == null) { // check 2
                    conObj = new DBConnectionDouble();
                }
            }
        }
        return conObj;
    }
}

// Double-checked locking:

// here it solves the "slowness" problem of putting lock-unlock by every thread by putting lock only when conObj is null.
// BUT, here comes the problem of creation of multiple (2 or more) conObj, if we do not use volatile on the conObj;

// IMPORTANT:
// scenario: suppose a 2 core system with each core having its own L1 cache and both the cache are attached to main memory.
// to retrieve objects faster, every object is created in cache by its respective thread. AND cache syncing takes time.
// so object is neither present in main memory and neither the caches know about the existence of conObj as they are not synced yet.

// in such a case, when 2 threads come at the same time at if (conObj==null), they both will create a new conObj in their respective caches. so multiple objects are created

// to overcome this situation, object is made `volatile`, means all Read/Write of this object will be in main memory only.
// so once a thread has created conObj in main memory, no other thread will create it again as it this thread will be able to its existence from main memory

// but this introduces another problem, since the object is created in main memory, it is slow to access.

// NOTE: // DbConnectionDouble.class represents a special kind of object known as `class object`
//      Class<DBConnectionDouble> classObj = DBConnectionDouble.class; // getting the class object using .class on a class name
//      DBConnectionDouble doubleDb = DBConnectionDouble.getInstance();

//      Class<? extends DBConnectionDouble> newDbObj = doubleDb.getClass(); // getting the class object from instance using .getClass() method which is present in Object class, which is the superclass of all the classes in java

//      System.out.println(newDbObj == classObj);

// a  "class object" is an object of the "Class" that contains the metadata of the class,


// NOTE: here, check2 is required for the case suppose when thread 1 is at check 1 and sees the object is null and at the same time some thread 2 is at the statement of creating the new DbConnectionDouble(), and this can happen, because the check1 is outside the lock, so when thread 2 releases the lock and thread 1 puts the lock on the `class object` to make the entire class object thread-safe, it has to check again at check 2 to verify if some other thread might have created the object before .
