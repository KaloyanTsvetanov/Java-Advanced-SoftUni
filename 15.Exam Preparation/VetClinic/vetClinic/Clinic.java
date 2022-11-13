package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(checkCapacity()){
            data.add(pet);
        }
    }

    public boolean remove(String name){
        if(checkNull()) {
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
    public Pet getPet(String name, String owner){
        if(checkNull()){
            for (Pet datum : data) {
                if(datum.getName().equals(name) && datum.getOwner().equals(owner)){
                    return datum;
                }
            }
            return null;
        }
        return null;
    }
    public Pet getOldestPet(){
        Pet pet = data.stream().max(Comparator.comparingInt(Pet::getAge)).get();
        return pet;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append("\n");
        for (Pet datum : data) {
            sb.append(datum.getName()).append(" ").append(datum.getOwner()).append("\n");
        }
        return sb.toString();
    }


    private boolean checkCapacity() {
        return data.size() < capacity;
    }

    private boolean checkNull() {
        return data.size() != 0;
    }
}
