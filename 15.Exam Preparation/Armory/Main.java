import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][];
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("");
            matrix[i] = arr;
        }

        int row = 0;
        int coll = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("A")) {
                    row = i;
                    coll = j;
                }
            }
        }

        int gold = 0;

        boolean outOfBounds = false;


        while (!outOfBounds && gold < 65) {

            String command = scanner.nextLine();

            matrix[row][coll] = "-";

            switch (command) {

                case "up":
                    if (row - 1 < 0) {
                        outOfBounds = true;
                        continue;
                    } else {
                        row -= 1;
                        if (matrix[row][coll].equals("M")) {
                            matrix[row][coll] = "-";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("M")) {
                                        row = i;
                                        coll = j;
                                        matrix[row][coll] = "A";
                                    }
                                }
                            }
                        } else if (matrix[row][coll].equals("-")) {
                            matrix[row][coll] = "A";
                        } else {
                            int price = Integer.parseInt(matrix[row][coll]);
                            matrix[row][coll] = "A";
                            gold += price;
                        }
                    }

                    break;
                case "down":
                    if (row + 1 >= n) {
                        outOfBounds = true;
                        continue;
                    } else {
                        row += 1;
                        if (matrix[row][coll].equals("M")) {
                            matrix[row][coll] = "-";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("M")) {
                                        row = i;
                                        coll = j;
                                        matrix[row][coll] = "A";
                                    }
                                }
                            }
                        } else if (matrix[row][coll].equals("-")) {
                            matrix[row][coll] = "A";
                        } else {
                            int price = Integer.parseInt(matrix[row][coll]);
                            matrix[row][coll] = "A";
                            gold += price;
                        }
                    }

                    break;
                case "right":

                    if (coll + 1 >= n) {
                        outOfBounds = true;
                        continue;
                    } else {
                        coll += 1;
                        if (matrix[row][coll].equals("M")) {
                            matrix[row][coll] = "-";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("M")) {
                                        row = i;
                                        coll = j;
                                        matrix[row][coll] = "A";
                                    }
                                }
                            }
                        } else if (matrix[row][coll].equals("-")) {
                            matrix[row][coll] = "A";
                        } else {
                            int price = Integer.parseInt(matrix[row][coll]);
                            matrix[row][coll] = "A";
                            gold += price;
                        }
                    }

                    break;
                case "left":

                    if (coll - 1 < 0) {
                        outOfBounds = true;
                        continue;
                    } else {
                        coll -= 1;
                        if (matrix[row][coll].equals("M")) {
                            matrix[row][coll] = "-";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("M")) {
                                        row = i;
                                        coll = j;
                                        matrix[row][coll] = "A";
                                    }
                                }
                            }
                        } else if (matrix[row][coll].equals("-")) {
                            matrix[row][coll] = "A";
                        } else {
                            int price = Integer.parseInt(matrix[row][coll]);
                            matrix[row][coll] = "A";
                            gold += price;
                        }
                    }

                    break;
            }

        }
        if (outOfBounds) {
            System.out.println("I do not need more swords!");
        }else {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n",gold);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

