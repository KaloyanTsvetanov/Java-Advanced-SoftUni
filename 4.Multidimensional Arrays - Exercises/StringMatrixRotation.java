import java.util.*;

public class StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String rotation = input;

        List<String> words = new ArrayList<>();

        input = scanner.nextLine();

        int maxLength = Integer.MIN_VALUE;


        while (!input.equals("END")) {

            if (input.length() > maxLength) {
                maxLength = input.length();
            }

            words.add(input);

            input = scanner.nextLine();

        }
        char[][] charArray = new char[words.size()][maxLength];

        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            for (int j = 0; j < maxLength; j++) {
                if (j < currentWord.length()) {
                    char ch = currentWord.charAt(j);
                    charArray[i][j] = ch;
                } else {
                    char ch = ' ';
                    charArray[i][j] = ch;
                }
            }
        }

        int angle = Integer.parseInt(rotation.split("[()]")[1]);
        int rotateAngle = angle % 360;

        switch (rotateAngle) {
            case 0:
                for (int i = 0; i < charArray.length; i++) {
                    for (int j = 0; j < charArray[i].length; j++) {
                        System.out.print(charArray[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int i = 0; i < maxLength; i++) {
                    for (int j = charArray.length - 1; j >= 0; j--) {
                        System.out.print(charArray[j][i]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int i = charArray.length - 1; i >= 0; i--) {
                    for (int j = maxLength - 1; j >= 0; j--) {
                        System.out.print(charArray[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int i = maxLength-1; i>=0; i--) {
                    for (int j = 0; j < charArray.length; j++) {
                        System.out.print(charArray[j][i]);
                    }
                    System.out.println();
                }
                break;

        }

    }
}
