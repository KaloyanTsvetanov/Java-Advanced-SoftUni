import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> vowels = new ArrayDeque<>();
        ArrayDeque<Character> consonants = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split(" ");

        List<String> foodList = new ArrayList<>();
        foodList.add("pear");
        foodList.add("flour");
        foodList.add("pork");
        foodList.add("olive");

        for (String token : tokens) {
            vowels.offer(token.charAt(0));
        }

        tokens = scanner.nextLine().split(" ");

        for (String token : tokens) {
            consonants.push(token.charAt(0));
        }

        while (!consonants.isEmpty()) {
            char firstVowel = vowels.poll();
            char lastConsonants = consonants.pop();
            vowels.offer(firstVowel);

            for (int j = 0; j < foodList.size(); j++) {
                String s = foodList.get(j);
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == firstVowel) {
                        char ch = Character.toUpperCase(s.charAt(i));
                        foodList.remove(j);
                        s = s.replace(s.charAt(i), ch);
                        foodList.add(j,s);
                    }
                    if (s.charAt(i) == lastConsonants) {
                        char ch = Character.toUpperCase(s.charAt(i));
                        foodList.remove(j);
                        s = s.replace(s.charAt(i), ch);
                        foodList.add(j,s);
                    }
                }
            }
        }

        for (int j = 0; j < foodList.size() ; j++) {
            String s = foodList.get(j);
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(Character.isLowerCase(ch)){
                    foodList.remove(s);
                    j--;
                    break;
                }
            }
        }
        System.out.println("Words found: "+foodList.size());
        for (String s : foodList) {
            System.out.println(s.toLowerCase());
        }

    }
}

