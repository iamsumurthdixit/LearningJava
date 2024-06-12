public class Calculation2 {
    String name;
    int empId;

    Calculation2() {
        this(10);
    }
    Calculation2(int empId) {
        this("newName", empId);
    }
    Calculation2(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }
}
// constructor chaining using this