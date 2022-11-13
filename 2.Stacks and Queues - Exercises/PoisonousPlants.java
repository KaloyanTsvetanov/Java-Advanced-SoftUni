import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input);
        input = scanner.nextLine();
        List<Integer> list = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int current = 0;
        int next = 0;
        int counter = 0;
        while (true){
            boolean thereMOre = false;
            List<Integer> indexList = new ArrayList<>();
            for (int i = 0; i < list.size()-1; i++) {
                next = list.get(i+1);
                current = list.get(i);
                if(current<next){
                    indexList.add(i+1);
                    thereMOre = true;
                }
            }
            if(thereMOre) {
                int c = 0;
                for (int ind : indexList) {
                    list.remove(ind - c);
                    c++;
                }
            }else {
                System.out.println(counter);
                break;
            }
            counter++;

        }
    }
}
