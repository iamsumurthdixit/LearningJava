public class OuterClassPrivate {
    static int classVariable = 34;

    private static class InnerClass { // can only access static things of outer class
        public void print() {
            System.out.println(classVariable);
        }
    }

    public void invokeInnerPrint() {
        InnerClass innerClass = new InnerClass();
        innerClass.print();
    }
}

// if the static nested class is private, it follows the private properties, i.e., It can be used ONLY inside outer class

// print() is not static, hence object of InnerClass in required, but, since the InnerClass is private, a method invokeInnerPrint() is created in the outer class that can create the object of InnerClass

// to print the value of classVariable:

// OuterClassPrivate object = new OuterClassPrivate();
// object.invokeInnerPrint();