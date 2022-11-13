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
                if (matrix[i][j].equals("M")) {
                    row = i;
                    coll = j;
                }
            }
        }

        int cheese = 0;

        boolean outOfBounds = false;

        String command = scanner.nextLine();


        while (!outOfBounds && !command.equals("end")) {


            switch (command) {
                case "up":
                    matrix[row][coll] = "-";
                    if (row - 1 < 0) {
                        outOfBounds = true;
                        continue;
                    } else {
                        row -= 1;
                        if (matrix[row][coll].equals("c")) {
                            cheese++;
                            matrix[row][coll] = "M";
                        } else if (matrix[row][coll].equals("B")) {
                            matrix[row][coll] = "-";
                            row -= 1;
                            if (matrix[row][coll].equals("c")) {
                                cheese++;
                                matrix[row][coll] = "M";
                            } else {
                                matrix[row][coll] = "M";
                            }
                        } else {
                            matrix[row][coll] = "M";
                        }
                    }


                    break;
                case "down":

                    matrix[row][coll] = "-";
                    if (row + 1 >= n) {
                        outOfBounds = true;
                        continue;
                    } else {
                        row += 1;
                        if (matrix[row][coll].equals("c")) {
                            cheese++;
                            matrix[row][coll] = "M";
                        } else if (matrix[row][coll].equals("B")) {
                            matrix[row][coll] = "-";
                            row += 1;
                            if (matrix[row][coll].equals("c")) {
                                cheese++;
                                matrix[row][coll] = "M";
                            } else {
                                matrix[row][coll] = "M";
                            }
                        } else {
                            matrix[row][coll] = "M";
                        }
                    }


                    break;
                case "right":

                    matrix[row][coll] = "-";
                    if (coll + 1 >= n) {
                        outOfBounds = true;
                        continue;
                    } else {
                        coll += 1;
                        if (matrix[row][coll].equals("c")) {
                            cheese++;
                            matrix[row][coll] = "M";
                        } else if (matrix[row][coll].equals("B")) {
                            matrix[row][coll] = "-";
                            coll += 1;
                            if (matrix[row][coll].equals("c")) {
                                cheese++;
                                matrix[row][coll] = "M";
                            } else {
                                matrix[row][coll] = "M";
                            }
                        } else {
                            matrix[row][coll] = "M";
                        }
                    }


                    break;
                case "left":
                    matrix[row][coll] = "-";
                    if (coll - 1 < 0) {
                        outOfBounds = true;
                        continue;
                    } else {
                        coll -= 1;
                        if (matrix[row][coll].equals("c")) {
                            cheese++;
                            matrix[row][coll] = "M";
                        } else if (matrix[row][coll].equals("B")) {
                            matrix[row][coll] = "-";
                            coll -= 1;
                            if (matrix[row][coll].equals("c")) {
                                cheese++;
                                matrix[row][coll] = "M";
                            } else {
                                matrix[row][coll] = "M";
                            }
                        } else {
                            matrix[row][coll] = "M";
                        }
                    }

                    break;
            }
            command = scanner.nextLine();

        }
        if (outOfBounds) {
            System.out.println("Where is the mouse?");
        }
        if (cheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}

