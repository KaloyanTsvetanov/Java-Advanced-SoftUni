import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String , List<Double>> studentMap = new TreeMap<>();
        int n = Integer.parseInt(input);

        while (n-->0){
            input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            Double grade = Double.parseDouble(input.split("\\s+")[1]);

            studentMap.putIfAbsent(name,new ArrayList<>());
            studentMap.get(name).add(grade);
        }

        studentMap.forEach((name, grade)->{
            System.out.print(name+" -> ");
            double sum = 0;
            for(double gr : grade){
                sum+=gr;
            }
            grade.forEach((value)-> System.out.printf("%.2f ",value));
            System.out.printf("(avg: %.2f)",sum/grade.size());
            System.out.println();
        });
    }
}
