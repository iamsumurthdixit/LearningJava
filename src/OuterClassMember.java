public class OuterClassMember {
    int instanceVar = 10;
    static int classVar = 30;

    class InnerClass {
        public void print() {
            System.out.println(instanceVar + classVar);
        }
    }
}

// to invoke the print() of InnerClass, first create the object of the outer class:
// OuterClassMember outerObj = new OuterClassMember();

// now create the instance of the inner class: ( VERY IMPORTANT SYNTAX )
// OuterClassMember.InnerClass innerObj = outerObj.new InnerClass();

// now invoke the print():
// innerObj.print();