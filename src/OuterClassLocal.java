public class OuterClassLocal {
    int instanceVar = 34;
    static int classVar = 98;

    public void display() {
        int methodLocalVar = 76;

        class LocalInnerClass { // MUST have `default` modifier only
            int localInnerVar = 56;

            public void print() {
                System.out.println(localInnerVar + methodLocalVar + classVar + instanceVar);
            }
        }
        // object of LocalInnerClass can ONLY be created within this "block scope"
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.print();
    }
}

// to invoke the print(),:

// OuterClassLocal outerLocalObj = new OuterClassLocal();
// outerLocalObj.display();
