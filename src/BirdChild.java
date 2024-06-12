public interface BirdChild extends Bird {
    String getFixedValue();
}
// overrides default method in parent interface and makes getFixedValue() abstract. now the class implementing BirdChild will provide its own definition of this method. (see BirdChildClass)

