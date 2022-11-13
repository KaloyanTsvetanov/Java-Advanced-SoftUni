import java.util.*;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> deck = new ArrayDeque<>();
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch=='('){
                deck.push(i);
            }else if(ch==')'){
                System.out.println(input.substring(deck.pop(),i+1));
            }
        }
    }
}
