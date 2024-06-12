public interface Bird {
    void canFly();

    // NOTE: the `default` keyword does NOT make it package-private, it is implicitly public
    default int getMinimumFlyHeight() { // from java 8
        return 200;
    }

    default String getFixedValue() { // can be overridden by class
        return "I am fixed from Bird";
    }

    // this static method "can NOT be overridden by any class", and it can be accessed using interface name only
    // static method are also implicitly public
    static boolean canBreathe() {
        return true;
    }
}
