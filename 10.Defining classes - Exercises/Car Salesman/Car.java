import java.io.IOException;

public class Car {

    String model;
    Engine engine;
    String weight;
    String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s",this.model,this.engine.getModel(),this.engine.getPower(),this.engine.getDisplacement(),this.engine.getEfficiency(),this.weight,this.color);
    }

    public Car(String model, Engine engine, String compare) throws IOException {
        this(model,engine);
        try {
            Integer.parseInt(compare);
            this.weight = compare;
        }catch (NumberFormatException e){
            this.color = compare;
        }
    }

    public Car(String model, Engine engine, String weight, String color) {
        this(model,engine);
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
