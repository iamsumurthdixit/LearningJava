public class ManagerChild extends PersonParent{
    String name;
    ManagerChild(String name, int empId) {
        super(empId);  // call to parent
        this.name = name;
        System.out.println("ManagerChild constructor " + name);
    }
}
