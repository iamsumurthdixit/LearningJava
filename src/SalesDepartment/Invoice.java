package SalesDepartment;

public class Invoice {
//    private void getInvoice() {
    protected void getInvoice() {
        System.out.println("inside invoice method");
    }
    void getInvoice(int a) {
        System.out.println("inside invoice method" + a);
    }
    void getInvoice(int a, int b) {
        System.out.println("inside invoice method" + a + b);
    }
    public void printInvoice() {
        getInvoice();
    }
    void sayHello() {
        System.out.println("hello");
    }
}
