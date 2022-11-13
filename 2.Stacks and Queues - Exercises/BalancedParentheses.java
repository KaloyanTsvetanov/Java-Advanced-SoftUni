import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            switch (current) {
                case '{':
                case '[':
                case '(':
                    stack.push(current);
                    break;

                default:
                    if (!stack.isEmpty()) {
                        char previous = stack.peek();
                        switch (previous) {
                            case '{':
                                if (current == '}') {
                                    stack.pop();
                                }
                                break;
                            case '[':
                                if (current == ']') {
                                    stack.pop();
                                }
                                break;
                            case '(':
                                if (current == ')') {
                                    stack.pop();
                                }
                                break;

                        }
                    } else stack.push(current);
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}
