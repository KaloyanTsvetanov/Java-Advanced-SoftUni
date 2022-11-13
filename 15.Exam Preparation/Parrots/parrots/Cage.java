package parrots;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(a -> a.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        data.stream().filter(a -> a.getName().equals(name)).findFirst().ifPresent(a -> a.setAvailable(false));
        return data.stream().filter(a -> a.getName().equals(name)).findFirst().get();
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        data.stream().filter(a -> a.getSpecies().equals(species)).forEach(a -> a.setAvailable(false));

        return data.stream().filter(a -> a.getSpecies().equals(species) && !a.isAvailable()).collect(Collectors.toList());
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(name).append(":").append("\n");
        for (Parrot datum : data) {
            if(datum.isAvailable()) {
                sb.append(datum).append("\n");
            }
        }
        return sb.toString();
    }
}
