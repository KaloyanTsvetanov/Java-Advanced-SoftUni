import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquid = new ArrayDeque<>();
        ArrayDeque<Integer> ingredient = new ArrayDeque<>();

        Map<String, Integer> foodMap = new LinkedHashMap<>();
        foodMap.put("Biscuit", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pie", 0);
        foodMap.put("Pastry", 0);

        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            liquid.offer(Integer.parseInt(token));
        }
        tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            ingredient.push(Integer.parseInt(token));
        }

        while (!liquid.isEmpty() && !ingredient.isEmpty()) {
            int firstLiquid = liquid.peek();
            int lastIngredient = ingredient.peek();
            int sum = firstLiquid + lastIngredient;

            switch (sum) {
                case 25:
                    int a = foodMap.get("Biscuit");
                    a += 1;
                    foodMap.put("Biscuit", a);
                    liquid.poll();
                    ingredient.pop();
                    break;
                case 50:
                    int b = foodMap.get("Cake");
                    b += 1;
                    foodMap.put("Cake", b);
                    liquid.poll();
                    ingredient.pop();
                    break;
                case 75:
                    int c = foodMap.get("Pastry");
                    c += 1;
                    foodMap.put("Pastry", c);
                    liquid.poll();
                    ingredient.pop();
                    break;
                case 100:
                    int d = foodMap.get("Pie");
                    d += 1;
                    foodMap.put("Pie", d);
                    liquid.poll();
                    ingredient.pop();
                    break;
                default:
                    liquid.poll();
                    int t = ingredient.pop();
                    t += 3;
                    ingredient.push(t);
                    break;
            }

        }
        boolean allFood = true;
        for (Map.Entry<String, Integer> entry : foodMap.entrySet()) {
            if (entry.getValue() == 0){
                allFood = false;
            }
        }
        if(allFood){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if(liquid.isEmpty()){
            System.out.println("Liquids left: none");
        }else {
            List<String> result = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (Integer integer : liquid) {
                result.add(integer.toString());
            }
            String a = String.join(", ",result);
            sb.append("Liquids left: ").append(a);
            System.out.println(sb);
        }

        if(ingredient.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {
            List<String> result = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (Integer integer : ingredient) {
                result.add(integer.toString());
            }
            String a = String.join(", ",result);
            sb.append("Ingredients left: ").append(a);
            System.out.println(sb);
        }

        for (Map.Entry<String, Integer> entry : foodMap.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
}

