public class MultipleInterface implements Bird, Airborne{

    @Override
    public void canFly() {
        System.out.println("I can fly");
    }

    @Override
    public String getFixedValue() {
        return "Overridden Bird and Airborne default methods";
    }
}
