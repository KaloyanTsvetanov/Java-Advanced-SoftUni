package cafe;

public class Employee {
    String name;
    int age;
    String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return String.format("Employee: %s, %d from %s", name, age, country);
    }

}
