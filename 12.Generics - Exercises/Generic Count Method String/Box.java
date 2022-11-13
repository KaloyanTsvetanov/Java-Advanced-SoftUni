import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swat(int fIndex, int sIndex) {

        T a = values.get(fIndex);
        values.set(fIndex, values.get(sIndex));
        values.set(sIndex, a);

//        Collections.swap(values,fIndex,sIndex);

    }

    public int biggerElements(T singleElement) {
        int counter = 0;
        for (T e : values) {
            if (e.compareTo(singleElement) > 0) {
                counter++;
            }
        }
        return counter;
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
