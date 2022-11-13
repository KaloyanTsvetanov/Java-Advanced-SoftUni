import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swat(int fIndex, int sIndex){

        T a = values.get(fIndex);
        values.set(fIndex,values.get(sIndex));
        values.set(sIndex,a);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value.toString()));
        }
        return sb.toString();

    }
}
