import java.util.Objects;

public class Car {

    private String brand;
    private String model;
    private Integer horsePower;

    public Car(String brand,String model, Integer horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }
    public Car(String brand){
        this(brand,"unknown",-1);
    }
    public Car(String brand, String model){
        this.brand = brand;
        this.model = model;
        this.horsePower = -1;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.",
                getBrand(),
                getModel(),
                getHorsePower());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(horsePower, car.horsePower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, horsePower);
    }
}
