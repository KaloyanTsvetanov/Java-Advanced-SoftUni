import java.io.IOException;

public class Engine {
    String model;
    Integer power;
    String displacement;
    String efficiency;

    public Engine(String model, Integer power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String model, Integer power, String compare) throws IOException {
        this(model, power);
        try {
            Integer.parseInt(compare);
            this.displacement = compare;
        } catch (NumberFormatException e) {
            this.efficiency = compare;
        }

    }

    public Engine(String model, Integer power, String displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
