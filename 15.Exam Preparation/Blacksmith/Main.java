import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> steel = new ArrayDeque<>();
        ArrayDeque<Integer> carbon = new ArrayDeque<>();
        Map<String, Integer> toolsMap = new TreeMap<>();

        String[] tokens = scanner.nextLine().split("\\s+");

        for (String token : tokens) {
            steel.offer(Integer.parseInt(token));
        }

        tokens = scanner.nextLine().split("\\s+");

        for (String token : tokens) {
            carbon.push(Integer.parseInt(token));
        }
        int swords = 0;
        while (!steel.isEmpty() && !carbon.isEmpty()) {

            int firstSteel = steel.peek();
            int lastCarbon = carbon.peek();

            int sum = firstSteel + lastCarbon;

            switch (sum) {
                case 70:
                    toolsMap.putIfAbsent("Gladius",0);
                    int nums = toolsMap.get("Gladius");
                    nums+=1;
                    toolsMap.put("Gladius",nums);
                    steel.poll();
                    carbon.pop();
                    swords++;
                    break;
                case 80:
                    toolsMap.putIfAbsent("Shamshir",0);
                    int nums1 = toolsMap.get("Shamshir");
                    nums1+=1;
                    toolsMap.put("Shamshir",nums1);
                    steel.poll();
                    carbon.pop();
                    swords++;
                    break;
                case 90:
                    toolsMap.putIfAbsent("Katana",0);
                    int nums2 = toolsMap.get("Katana");
                    nums2+=1;
                    toolsMap.put("Katana",nums2);
                    steel.poll();
                    carbon.pop();
                    swords++;
                    break;
                case 110:
                    toolsMap.putIfAbsent("Sabre",0);
                    int nums3 = toolsMap.get("Sabre");
                    nums3+=1;
                    toolsMap.put("Sabre",nums3);
                    steel.poll();
                    carbon.pop();
                    swords++;
                    break;
                default:
                    steel.poll();
                    int a = carbon.pop();
                    a+=5;
                    carbon.push(a);
                    break;
            }

        }

        if(swords==0){
            System.out.println("You did not have enough resources to forge a sword.");
        }else {
            System.out.printf("You have forged %d swords.%n",swords);
        }

        if(steel.isEmpty()){
            System.out.println("Steel left: none");
        }else {
            List<String> result = new ArrayList<>();
            for (Integer integer : steel) {
                result.add(integer.toString());
            }
            System.out.println("Steel left: "+String.join(", ",result));
        }

        if(carbon.isEmpty()){
            System.out.println("Carbon left: none");
        }else {
            List<String> result = new ArrayList<>();
            for (Integer integer : carbon) {
                result.add(integer.toString());
            }
            System.out.println("Carbon left: "+String.join(", ",result));
        }

        if(swords!=0){
            for (Map.Entry<String, Integer> entry : toolsMap.entrySet()) {
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
        }

    }
}

