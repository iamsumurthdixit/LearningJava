public class FunctionalClass implements FunctionalBird{

    @Override
    public void canFly(String val) {
        System.out.println("Can fly -> " + val);
    }
}
