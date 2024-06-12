public abstract class Car {
    int mileage;

    Car(int mileage) {
        this.mileage = mileage;
    }

    public abstract void pressBrake();

    public abstract void pressClutch();

    public int getNumberOfWheels() {
        return 4;
    }
}
