public class CarComparable implements Comparable<CarComparable> {
    public String name;
    public String type;

    CarComparable(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public int compareTo(CarComparable o) {
        return this.name.compareTo(o.name);
    }
}
