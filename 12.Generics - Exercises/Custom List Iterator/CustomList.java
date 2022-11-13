import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> values;

    public CustomList() {
        values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public T remove(int index) {

        return  values.remove(index);
    }

    public void swap(int a, int b) {
        Collections.swap(values, a, b);
    }

    public int count() {
        return values.size();
    }

    public long countGreater(T element) {
        return values.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T min() {
        return values.stream().min(Comparable::compareTo).get();
    }

    public T max(){
        return values.stream().max(Comparable::compareTo).get();
    }

    public boolean contains(T element) {
        return values.contains(element);
    }

    public void print(){
         values.forEach(System.out::println);
    }

    public void sort(){
        values.sort(Comparable::compareTo);
    }

}
