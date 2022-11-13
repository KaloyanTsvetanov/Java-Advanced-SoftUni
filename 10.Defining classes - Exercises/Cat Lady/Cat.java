public class Cat {

    private String breed;
    private String name;
    private Double information;

    public Cat(String breed, String name, Double information) {
        this.breed = breed;
        this.name = name;
        this.information = information;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInformation() {
        return information;
    }

    public void setInformation(Double information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",getBreed(),getName(),getInformation());
    }
}
