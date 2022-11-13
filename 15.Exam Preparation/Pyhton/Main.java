import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        String[] token = scanner.nextLine().split(", ");
        int k = 0;

        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split(" ");
            matrix[i] = arr;
        }
        int row = 0;
        int coll = 0;
        int food = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("s")) {
                    row = i;
                    coll = j;
                }
                if (matrix[i][j].equals("f")) {
                    food++;
                }
            }
        }

        int size = 1;
        boolean enemy = false;


        while (!enemy && k < token.length) {

            String command = token[k];
            k++;

            matrix[row][coll] = "*";
            switch (command) {
                case "up":
                    if (row - 1 < 0) {
                        row = n - 1;
                    } else {
                        row -= 1;
                    }
                    if (matrix[row][coll].equals("e")) {
                        enemy = true;
                        continue;
                    } else if (matrix[row][coll].equals("f")) {
                        matrix[row][coll] = "s";
                        size++;
                        food--;
                    } else {
                        matrix[row][coll] = "s";
                    }

                    break;
                case "down":
                    if (row + 1 >= n) {
                        row = 0;
                    } else {
                        row += 1;
                    }
                    if (matrix[row][coll].equals("e")) {
                        enemy = true;
                        continue;
                    } else if (matrix[row][coll].equals("f")) {
                        matrix[row][coll] = "s";
                        size++;
                        food--;
                    } else {
                        matrix[row][coll] = "s";
                    }

                    break;
                case "right":
                    if (coll + 1 >= n) {
                        coll = 0;
                    } else {
                        coll += 1;
                    }
                    if (matrix[row][coll].equals("e")) {
                        enemy = true;
                        continue;
                    } else if (matrix[row][coll].equals("f")) {
                        matrix[row][coll] = "s";
                        size++;
                        food--;
                    } else {
                        matrix[row][coll] = "s";
                    }


                    break;
                case "left":
                    if (coll - 1 < 0) {
                        coll = n - 1;
                    } else {
                        coll -= 1;
                    }
                    if (matrix[row][coll].equals("e")) {
                        enemy = true;
                        continue;
                    } else if (matrix[row][coll].equals("f")) {
                        matrix[row][coll] = "s";
                        size++;
                        food--;
                    } else {
                        matrix[row][coll] = "s";
                    }

                    break;
            }


        }
        if (food == 0) {
            System.out.println("You win! Final python length is " + size);
        } else if (!enemy) {
            System.out.printf("You lose! There is still %d food to be eaten.%n", food);
        } else if (enemy) {
            System.out.println("You lose! Killed by an enemy!");
        }

    }
}

