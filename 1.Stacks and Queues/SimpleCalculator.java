import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        ArrayDeque<String> calculator = new ArrayDeque<>();
        String[] input = scanner.nextLine().split(" ");
        for(String n : input){
            calculator.push(n);
        }
        while (!calculator.isEmpty()){
            int a = Integer.parseInt(calculator.pop());
            String operation = "+";
            if(calculator.size()!=0) {
                operation = calculator.pop();
            }
            if(operation.equals("-")){
                sum-=a;
            }else sum+=a;
        }
        System.out.println(sum);
    }
}
