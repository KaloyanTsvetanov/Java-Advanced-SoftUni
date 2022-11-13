import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milk = new ArrayDeque<>();
        ArrayDeque<Double> cacao = new ArrayDeque<>();

        Map<String,Integer> chocolateMap = new TreeMap<>();

        String[] tokens = scanner.nextLine().split("\\s+");

        for (String token : tokens) {
            milk.offer(Double.parseDouble(token));
        }

        tokens = scanner.nextLine().split("\\s+");

        for (String token : tokens) {
            cacao.push(Double.parseDouble(token));
        }

        while (!milk.isEmpty() && !cacao.isEmpty()){
            double firstMilk = milk.peek();
            double lastCacao = cacao.peek();

            double percentage = (lastCacao / (firstMilk+lastCacao))*100;

            if(percentage == 30.0){
                chocolateMap.putIfAbsent("Milk Chocolate",0);
                int a = chocolateMap.get("Milk Chocolate");
                a+=1;
                chocolateMap.put("Milk Chocolate",a);
                milk.poll();
                cacao.pop();
            }else if(percentage == 50.0){
                chocolateMap.putIfAbsent("Dark Chocolate",0);
                int a = chocolateMap.get("Dark Chocolate");
                a+=1;
                chocolateMap.put("Dark Chocolate",a);
                milk.poll();
                cacao.pop();
            } else if(percentage == 100.0){
                chocolateMap.putIfAbsent("Baking Chocolate",0);
                int a = chocolateMap.get("Baking Chocolate");
                a+=1;
                chocolateMap.put("Baking Chocolate",a);
                milk.poll();
                cacao.pop();
            }else {
                cacao.pop();
                double a = milk.poll();
                a+=10;
                milk.offer(a);
            }

        }

        if(chocolateMap.size() == 3){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : chocolateMap.entrySet()) {
            System.out.printf(" # %s --> %d%n",entry.getKey(),entry.getValue());
        }

    }
}

