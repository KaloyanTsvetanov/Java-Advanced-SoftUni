package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return (capacity-data.size());
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if(capacity>this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present datum : data) {
            if (datum.getName().equals(name)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        return data.stream().max((a, b) -> (int) (a.getWeight() - b.getWeight())).get();
    }

    public Present getPresent(String name) {
        Present current = null;
        for (Present datum : data) {
            if(datum.getName().equals(name)){
                current = datum;
            }
        }
        return  current;
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(getColor()).append(" bag contains:").append("\n");
        for (Present datum : data) {
            sb.append(datum).append("\n");
        }

        return sb.toString();
    }

}
