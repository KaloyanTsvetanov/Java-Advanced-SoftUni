import java.util.ArrayList;
import java.util.List;

public class Department {
    String nameOfDepartment;
    private List<Employee> departmentList;


    public Department(String nameOfDepartment){

        this.nameOfDepartment = nameOfDepartment;
        this.departmentList = new ArrayList<>();
    }

    public double averageSalary(){
        return departmentList.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public List<Employee> getDepartment() {
        return departmentList;
    }

    public void setDepartment(List<Employee> department) {
        this.departmentList = department;
    }
}
