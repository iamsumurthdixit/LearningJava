public enum EnumAbstract {
    MONDAY {
        @Override
        public void dummyMethod() {
            System.out.println("monday");
        }
    },
    TUESDAY {
        @Override
        public void dummyMethod() {
            System.out.println("tuesday");
        }
    },
    WEDNESDAY {
        @Override
        public void dummyMethod() {
            System.out.println("wednesday");
        }
    };

    // this abstract method has to be overridden by EACH constant
    public abstract void dummyMethod();
}