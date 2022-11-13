import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        int dollars = 0;

        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("");
            matrix[i] = arr;
        }
        int row = 0;
        int coll = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("S")) {
                    row = i;
                    coll = j;
                }
            }
        }
        boolean outOfBounds = false;

        while (dollars < 50 && !outOfBounds) {
            String input = scanner.nextLine();

            switch (input) {
                case "up":
                    if (row - 1 < 0) {
                        outOfBounds = true;
                        matrix[row][coll] = "-";
                        continue;
                    } else {
                        matrix[row][coll] = "-";
                        row -= 1;
                    }
                    if (matrix[row][coll].equals("O")) {
                        matrix[row][coll] = "-";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                if (matrix[i][j].equals("O")) {
                                    matrix[i][j] = "S";
                                    row = i;
                                    coll = j;
                                }
                            }
                        }
                    } else if (matrix[row][coll].equals("-")) {
                        matrix[row][coll] = "S";
                    } else {
                        int d = Integer.parseInt(matrix[row][coll]);
                        matrix[row][coll] = "S";
                        dollars += d;
                    }

                    break;
                case "down":
                    if (row + 1 >= n) {
                        outOfBounds = true;
                        matrix[row][coll] = "-";
                        continue;
                    } else {
                        matrix[row][coll] = "-";
                        row += 1;
                    }
                    if (matrix[row][coll].equals("O")) {
                        matrix[row][coll] = "-";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                if (matrix[i][j].equals("O")) {
                                    matrix[i][j] = "S";
                                    row = i;
                                    coll = j;
                                }
                            }
                        }
                    } else if (matrix[row][coll].equals("-")) {
                        matrix[row][coll] = "S";
                    } else {
                        int d = Integer.parseInt(matrix[row][coll]);
                        matrix[row][coll] = "S";
                        dollars += d;
                    }
                    break;
                case "left":
                    if (coll - 1 < 0) {
                        outOfBounds = true;
                        matrix[row][coll] = "-";
                        continue;
                    } else {
                        matrix[row][coll] = "-";
                        coll -= 1;
                    }
                    if (matrix[row][coll].equals("O")) {
                        matrix[row][coll] = "-";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                if (matrix[i][j].equals("O")) {
                                    matrix[i][j] = "S";
                                    row = i;
                                    coll = j;
                                }
                            }
                        }
                    } else if (matrix[row][coll].equals("-")) {
                        matrix[row][coll] = "S";
                    } else {
                        int d = Integer.parseInt(matrix[row][coll]);
                        matrix[row][coll] = "S";
                        dollars += d;
                    }
                    break;
                case "right":
                    if (coll + 1 >= n) {
                        matrix[row][coll] = "-";
                        outOfBounds = true;
                        continue;
                    } else {
                        matrix[row][coll] = "-";
                        coll += 1;
                    }
                    if (matrix[row][coll].equals("O")) {
                        matrix[row][coll] = "-";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                if (matrix[i][j].equals("O")) {
                                    matrix[i][j] = "S";
                                    row = i;
                                    coll = j;
                                }
                            }
                        }
                    } else if (matrix[row][coll].equals("-")) {
                        matrix[row][coll] = "S";
                    } else {
                        int d = Integer.parseInt(matrix[row][coll]);
                        matrix[row][coll] = "S";
                        dollars += d;
                    }
                    break;
            }
        }
        if(outOfBounds){
            System.out.println("Bad news, you are out of the bakery.");
        }
        if(dollars>=50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n",dollars);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}

