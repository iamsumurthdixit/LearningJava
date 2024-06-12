import java.util.Comparator;

public class CarNameComparator implements Comparator<CarComp> {
    @Override
    public int compare(CarComp o1, CarComp o2) {
        return o1.name.compareTo(o2.name);
    }
}
