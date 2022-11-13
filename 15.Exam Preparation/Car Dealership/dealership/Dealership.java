package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        if (data.size() != 0) {
            return data.removeIf(a -> a.getManufacturer().equals(manufacturer) && a.getModel().equals(model));
        }
        return false;
    }

    public Car getLatestCar() {
        if (data.size() != 0) {
            return data.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        if (data.size() != 0) {
            return data.stream().filter(a -> a.getManufacturer().equals(manufacturer) && a.getModel().equals(model)).findFirst().orElse(null);
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(this.name).append(":").append("\n");
        for (Car datum : data) {
            sb.append(datum).append("\n");
        }
        return sb.toString();
    }
}
