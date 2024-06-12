public interface PrivateInterface {
    void canFly(); // public void canFly();

    default void minimumFlyingHeight() {
        System.out.println("default method");
        publicStaticMethod();
        privateMethod();
        privateStaticMethod();
    }

    static void publicStaticMethod() {
        System.out.println("public static method");
        privateStaticMethod();
    }

    private void privateMethod() {
        System.out.println("private Method");
    }

    private static void privateStaticMethod() {
        System.out.println("private Static Method");
//        publicStaticMethod(); // is accessible, but here it is infinite loop situation
    }
}
