package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {

    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return this.data.removeIf(a -> a.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        return this.data.stream().max(Comparator.comparing(Egg::getStrength)).stream().findFirst().orElse(null);
    }

    public Egg getEgg(String color) {
        return this.data.stream().filter(a -> a.getColor().equals(color)).findAny().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(material).append(" basket contains:").append("\n");
        for (Egg datum : this.data) {
            sb.append(datum).append("\n");
        }
        return sb.toString();
    }
}
