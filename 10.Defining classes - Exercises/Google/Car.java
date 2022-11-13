public class Car {
    private String model;
    private String horsePower;

    public Car(String model, String horsePower) {
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format(getModel()+" "+getHorsePower());
    }
}
