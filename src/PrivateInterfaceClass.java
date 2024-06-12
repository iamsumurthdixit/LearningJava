public class PrivateInterfaceClass implements PrivateInterface{
    @Override
    public void canFly() {
        System.out.println("PrivateInterfaceClass Can Fly");
        System.out.println("------- calling default method -------");
        minimumFlyingHeight();
    }
}
