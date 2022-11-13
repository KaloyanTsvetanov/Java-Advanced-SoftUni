import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 8;

        String[][] matrix = new String[n][];
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("");
            matrix[i] = arr;
        }
        int whiteRow = 0;
        int whiteColl = 0;
        int blackRow = 0;
        int blackColl = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("b")) {
                    blackRow = i;
                    blackColl = j;
                }
                if (matrix[i][j].equals("w")) {
                    whiteRow = i;
                    whiteColl = j;
                }
            }
        }

        boolean winWhite = false;
        boolean whiteSpawn = false;
        boolean winBlack = false;
        boolean blackSpawn = false;


        while (!winBlack && !winWhite && !whiteSpawn && !blackSpawn) {

            if (whiteRow - 1 > 0) {
                matrix[whiteRow][whiteColl] = "-";
                whiteRow -= 1;
                if (whiteColl - 1 >= 0 && matrix[whiteRow][whiteColl - 1].equals("b")) {
                    matrix[whiteRow][whiteColl - 1] = "w";
                    winWhite = true;
                    continue;

                } else if (whiteColl + 1 < 8 && matrix[whiteRow][whiteColl + 1].equals("b")) {

                    matrix[whiteRow][whiteColl + 1] = "w";
                    winWhite = true;
                    continue;

                } else {
                    matrix[whiteRow][whiteColl] = "w";
                }
            } else {
                matrix[whiteRow][whiteColl] = "-";
                whiteRow -= 1;
                matrix[whiteRow][whiteColl] = "w";
                whiteSpawn = true;
                matrix[blackRow][blackColl] = "-";
                continue;
            }

            if (blackRow + 1 < 7) {

                matrix[blackRow][blackColl] = "-";
                blackRow += 1;
                if (blackColl - 1 >= 0 && matrix[blackRow][blackColl - 1].equals("w")) {
                    matrix[blackRow][blackColl - 1] = "b";
                    winBlack = true;

                } else if (blackColl + 1 < 8 && matrix[blackRow][blackColl + 1].equals("w")) {

                    matrix[blackRow][blackColl + 1] = "b";
                    winBlack = true;

                } else {
                    matrix[blackRow][blackColl] = "b";
                }
            } else {
                matrix[blackRow][blackColl] = "-";
                blackRow += 1;
                matrix[blackRow][blackColl] = "b";
                matrix[whiteRow][whiteColl] = "-";
                blackSpawn = true;
            }

        }
        int winnerRow = 0;
        int winnerColl = 0;
        int k = 0;

        for (int i = n - 1; i >= 0; i--) {
            k++;
            for (int j = 0; j < n; j++) {
                if (!matrix[i][j].equals("-")) {
                    winnerRow = k;
                    winnerColl = j;
                }
            }
        }
        String result = "";

        switch (winnerColl) {
            case 0:
                result = "a" + winnerRow;
                break;
            case 1:
                result = "b" + winnerRow;
                break;
            case 2:
                result = "c" + winnerRow;
                break;
            case 3:
                result = "d" + winnerRow;
                break;
            case 4:
                result = "e" + winnerRow;
                break;
            case 5:
                result = "f" + winnerRow;
                break;
            case 6:
                result = "g" + winnerRow;
                break;
            case 7:
                result = "h" + winnerRow;
                break;

        }

        if (winWhite) {
            System.out.println("Game over! White capture on " + result + ".");
        } else if (whiteSpawn) {
            System.out.println("Game over! White pawn is promoted to a queen at " + result + ".");
        } else if (winBlack) {
            System.out.println("Game over! Black capture on " + result + ".");
        } else if (blackSpawn) {
            System.out.println("Game over! Black pawn is promoted to a queen at " + result + ".");
        }


    }
}

