package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity - data.size() > 0) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        if (check()) {
            for (Car datum : data) {
                if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                    data.remove(datum);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Car getLatestCar() {
        if (check()) {
            Car result;
            result = data.stream().max(Comparator.comparingInt(Car::getYear)).get();
            return result;
        }
        return null;
    }

    public Car getCar(String manufacturer, String model){
        if(check()){
            for (Car datum : data) {
                if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                    return datum;
                }
            }
            return null;
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ").append(this.type).append(":").append("\n");
        for (Car datum : data) {
            sb.append(datum).append("\n");
        }
        return sb.toString();
    }


    private boolean check() {
        if (data.isEmpty()) {
            return false;
        }
        return true;
    }
}
