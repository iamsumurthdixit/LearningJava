public class BirdChildClass implements BirdChild {
    @Override
    public void canFly() {
        System.out.println("Bird child can fly");
    }

    @Override
    public String getFixedValue() {
        return "BirdChild";
    }
}
