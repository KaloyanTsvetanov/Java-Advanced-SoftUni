import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> map = new LinkedHashMap<>();
        Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(n->{
                    if(map.containsKey(n)){
                        int oldCount = map.get(n);
                        int newCount = oldCount+1;
                        map.put(n,newCount);
                    }else {
                        map.put(n,1);
                    }
                });

        for (var entry : map.entrySet()) {
            System.out.println(String.format("%.1f -> %d",entry.getKey(),entry.getValue()));
        }

    }
}
