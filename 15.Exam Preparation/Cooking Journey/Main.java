import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

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

        int money = 0;

        boolean outOfBounds = false;

        while (!outOfBounds && money < 50) {

            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    if (row - 1 < 0) {
                        matrix[row][coll] = "-";
                        outOfBounds = true;
                        continue;
                    } else {
                        matrix[row][coll] = "-";
                        row -= 1;
                        if (matrix[row][coll].equals("P")) {
                            matrix[row][coll] = "-";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("P")) {
                                        row = i;
                                        coll = j;
                                        matrix[row][coll] = "S";
                                    }
                                }
                            }
                        } else if (matrix[row][coll].equals("-")) {
                            matrix[row][coll] = "S";
                        } else {
                            int a = Integer.parseInt(matrix[row][coll]);
                            matrix[row][coll] = "S";
                            money += a;
                        }

                    }

                    break;
                case "down":
                    if (row + 1 >= n){
                        matrix[row][coll] = "-";
                    outOfBounds = true;
                    continue;
                } else{
                    matrix[row][coll] = "-";
                    row += 1;
                    if (matrix[row][coll].equals("P")) {
                        matrix[row][coll] = "-";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                if (matrix[i][j].equals("P")) {
                                    row = i;
                                    coll = j;
                                    matrix[row][coll] = "S";
                                }
                            }
                        }
                    } else if (matrix[row][coll].equals("-")) {
                        matrix[row][coll] = "S";
                    } else {
                        int a = Integer.parseInt(matrix[row][coll]);
                        matrix[row][coll] = "S";
                        money += a;
                    }

                }

                break;
                case "right":
                    if (coll + 1 >= n){
                        matrix[row][coll] = "-";
                        outOfBounds = true;
                        continue;
                    } else{
                        matrix[row][coll] = "-";
                        coll += 1;
                        if (matrix[row][coll].equals("P")) {
                            matrix[row][coll] = "-";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("P")) {
                                        row = i;
                                        coll = j;
                                        matrix[row][coll] = "S";
                                    }
                                }
                            }
                        } else if (matrix[row][coll].equals("-")) {
                            matrix[row][coll] = "S";
                        } else {
                            int a = Integer.parseInt(matrix[row][coll]);
                            matrix[row][coll] = "S";
                            money += a;
                        }

                    }

                    break;
                case "left":
                    if (coll - 1 < 0) {
                        matrix[row][coll] = "-";
                        outOfBounds = true;
                        continue;
                    } else {
                        matrix[row][coll] = "-";
                        coll -= 1;
                        if (matrix[row][coll].equals("P")) {
                            matrix[row][coll] = "-";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("P")) {
                                        row = i;
                                        coll = j;
                                        matrix[row][coll] = "S";
                                    }
                                }
                            }
                        } else if (matrix[row][coll].equals("-")) {
                            matrix[row][coll] = "S";
                        }else {
                            int a = Integer.parseInt(matrix[row][coll]);
                            matrix[row][coll] = "S";
                            money+=a;
                        }

                    }

                    break;
            }


        }
        if(outOfBounds){
            System.out.println("Bad news! You are out of the pastry shop.");
        }else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n",money);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

