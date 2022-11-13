public class Car {

    private String model;
    private double fuelAmount;
    private double fuelConsumption;

    private int distance;

    public Car(String model, double fuelAmount, double fuelConsumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumption = fuelConsumption;
        this.distance = 0;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }

    public void travelDistance(int travelDistance) {
        if (this.fuelAmount - travelDistance * fuelConsumption >= 0) {
            this.distance += travelDistance;
            this.fuelAmount -= travelDistance * fuelConsumption;
        } else  {
            System.out.println("Insufficient fuel for the drive");

        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
