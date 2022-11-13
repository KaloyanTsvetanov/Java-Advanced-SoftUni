public class Company {
    private String nameOfCompany;
    private Double salary;

    public Company(String nameOfCompany, Double salary) {
        this.nameOfCompany = nameOfCompany;
        this.salary = salary;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f",getNameOfCompany(),getSalary());
    }
}
