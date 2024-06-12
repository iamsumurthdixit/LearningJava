public class OuterClassPublic {

    int instanceVariable = 10;  // can NOT be used in static inner class
    static int classVariable = 20;

    static class InnerClass {
        public void print() {
            System.out.println("Inside inner class print" + classVariable);
        }
    }
}
// to access the print(), object of OuterClassPublic is not required because print() is present in InnerClass which is static.
// but print() method is NOT static, hence, an object of InnerClass is required to access the print() method

// to invoke the print():

// OuterClassPublic.InnerClass innerObj = new OuterClassPublic.InnerClass();
// innerObj.print();
