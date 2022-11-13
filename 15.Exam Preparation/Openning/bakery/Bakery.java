package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (checkCapacity()) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        if(checkCapacity()) {
            return employees.removeIf(e -> e.getName().equals(name));
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElseThrow();

    }

    public Employee getEmployee(String name){
        return employees.stream().filter(e->e.getName().equals(name)).findFirst().orElseThrow();

    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ").append(this.name).append(":").append("\n");
        for (Employee employee : employees) {
            sb.append(employee).append("\n");
        }
        return sb.toString();
    }


    private boolean checkCapacity() {
        return employees.size() < capacity;
    }

    private boolean checkEmpty() {
        return employees.size() != 0;
    }
}
