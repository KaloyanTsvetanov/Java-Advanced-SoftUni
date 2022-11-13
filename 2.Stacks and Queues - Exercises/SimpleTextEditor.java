import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            String input = scanner.nextLine();

            String command = input.split(" ")[0];
            switch (command) {
                case "1":
                    String word = input.split(" ")[1];
                    stack.push(stringBuilder.toString());
                    stringBuilder.append(word);

                    break;
                case "2":
                    int count = Integer.parseInt(input.split(" ")[1]);
                    int length = stringBuilder.length();;
                    stack.push(stringBuilder.toString());
                    for (int i = length-1; i >=length-count; i--) {
                        stringBuilder.deleteCharAt(i);
                    }
                    break;
                case "3":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    String a = stringBuilder.toString();
                    if (index > a.length()) {
                        index = a.length();
                    }
                    char b = a.charAt(index - 1);
                    System.out.println(b);
                    break;
                case "4":
                    String word1 = stack.pop();
                    stringBuilder.replace(0, stringBuilder.length(), word1);
                    break;

            }
            n--;
        }

    }
}
