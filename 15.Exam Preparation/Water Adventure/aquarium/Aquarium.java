package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        boolean space = false;
        boolean sameFish = false;
        if (fishInPool.size() < capacity) {
            space = true;
        }
        if (space) {
            sameFish = fishInPool.stream().anyMatch(a -> a.getName().equals(fish.getName()));
        }
        if (space && !sameFish) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        return fishInPool.removeIf(a -> a.getName().equals(name));

    }

    public Fish findFish(String name){
        return fishInPool.stream().filter(a->a.getName().equals(name)).findAny().orElse(null);
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Aquarium: ").append(name).append(" ^ Size: ").append(size).append("\n");
        for (Fish fish : fishInPool) {
            sb.append(fish).append("\n");
        }
        return sb.toString();
    }

}
