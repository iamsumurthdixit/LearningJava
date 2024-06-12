public class SingleCalculation {
    String name;
    private SingleCalculation() {

    }
    // this below method can only be used to get the instance of this class
    public static SingleCalculation getInstance() {
        return new SingleCalculation();
    }
}
