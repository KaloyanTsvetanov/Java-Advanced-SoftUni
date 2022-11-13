import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,LinkedHashMap<String,Integer>> map = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String [] parts = input.split("\\s+");
            String ipParts = parts[0];
            String userName = parts[2];
            userName =userName.substring(5);
            ipParts = ipParts.substring(3);

            map.putIfAbsent(userName,new LinkedHashMap<>());
            map.get(userName).putIfAbsent(ipParts,0);
            int counter = map.get(userName).get(ipParts);
            int newCounter = counter+1;
            map.get(userName).put(ipParts,newCounter);

            input=scanner.nextLine();
        }

        map.forEach((name,iP)->{
            StringBuilder result = new StringBuilder();
            System.out.println(name+": ");
            iP.forEach((e,k)->{
                String c = k.toString();
                result.append(e+" => "+c+", ");
            });
            String res = result.substring(0,result.length()-2);
            System.out.println(res+".");
        });

    }
}
