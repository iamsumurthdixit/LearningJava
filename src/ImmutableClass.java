import java.util.ArrayList;
import java.util.List;

final class ImmutableClass {
    private final String name;
    private final List<Object> petNameList;

    ImmutableClass(String name, List<Object> petNameList) {
        this.name = name;
        this.petNameList = petNameList;
    }
    public String getName() {
        return name;
    }
    public List<Object> getPetNameList() {
        return new ArrayList<>(petNameList);
    }
}
// for collection type of variables, ALWAYS a copy is returned