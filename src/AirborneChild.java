public interface AirborneChild extends Airborne {
    default String getFixedValue() {
        return Airborne.super.getFixedValue() + " adding this from airborne child";
    }
}
// getFixedValue() overrides the default implementation in parent interface
