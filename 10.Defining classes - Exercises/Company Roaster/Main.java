import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employeeList = new ArrayList<>();
        Map<String, Department> departmentMap = new HashMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee current = null;
            if (tokens.length == 4) {
                current = new Employee(name, salary, position, department);
            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                current = new Employee(name, salary, position, department, email, age);
            } else {

                if (tokens[4].contains("@")) {
                    String email = tokens[4];
                    current = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(tokens[4]);
                    current = new Employee(name, salary, position, department, age);
                }

            }

            departmentMap.putIfAbsent(department, new Department(department));
            departmentMap.get(department).getDepartment().add(current);

        }

        Department highestPaid = departmentMap.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().averageSalary()))
                .get().getValue();
        System.out.println("Highest Average Salary: " + highestPaid.getNameOfDepartment());

        highestPaid.getDepartment().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

    }
}