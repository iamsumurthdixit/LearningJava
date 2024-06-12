public abstract class LuxuryCar extends Car{
    int horsePower;

    LuxuryCar(int mileage, int horsePower) {
        super(mileage);
        this.horsePower = horsePower;
    }

    public abstract void pressDualBrakeSystem();

    @Override
    public void pressBrake() {
        // implementation
    }
}
