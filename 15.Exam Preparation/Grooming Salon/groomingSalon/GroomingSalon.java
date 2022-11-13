package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private int capacity;

    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }

    public void add(Pet pet){
        if (data.size()<capacity){
            data.add(pet);
        }
    }

    public boolean remove(String name){
        if(!data.isEmpty()) {
            for (Pet datum : data) {
                if (datum.getName().equals(name)) {
                    data.remove(datum);
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    public Pet getPet (String name, String owner){
        Pet pet = null;
        if(!data.isEmpty()){
            pet = data.stream().filter(a->a.getName().equals(name)&& a.getOwner().equals(owner)).findAny().get();
        }
        return pet;
    }
    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append("\n");
        for (Pet datum : data) {
            sb.append(datum.getName()).append(" ").append(datum.getOwner()).append("\n");
        }
        return sb.toString();
    }
}
