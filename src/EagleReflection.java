public class EagleReflection {
    public String name;
    private boolean canSwim;

    public void fly(int intParam, boolean booleanParam, String stringParam) {
        System.out.println("fly: " + intParam + " " + booleanParam + " " + stringParam);
    }

    private void eat() {
        System.out.println("eat");
    }
}
