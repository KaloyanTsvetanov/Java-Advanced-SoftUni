package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant){
        if(data.size()<capacity){
            data.add(elephant);
        }
    }
    public boolean remove(String name){
        return data.removeIf(a->a.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom){
        return data.stream().filter(a->a.getRetiredFrom().equals(retiredFrom)).findAny().orElse(null);
    }

    public Elephant getOldestElephant(){
        return data.stream().max(Comparator.comparingInt(Elephant::getAge)).get();
    }
    public int getAllElephants(){
        return data.size();
    }

    public String getReport(){
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append("\n");
        for (Elephant datum : data) {
            sb.append(datum.getName()).append(" came from: ").append(datum.getRetiredFrom()).append("\n");
        }
        return sb.toString();
    }

}
