public enum EnumSample {
    MONDAY {
        @Override
        public void dummyMethod() {
            System.out.println("monday dummy method");
        }
    },
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    // below method will be associated with all the constants defined in this enum, custom method is created by overriding this in MONDAY
    public void dummyMethod() {
        System.out.println("default dummy method");
    }
}
