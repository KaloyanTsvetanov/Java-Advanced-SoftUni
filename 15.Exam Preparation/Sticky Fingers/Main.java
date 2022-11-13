import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] tokens = scanner.nextLine().split(",");

        String[][] matrix = new String[n][];
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split(" ");
            matrix[i] = arr;
        }

        String outside = "You cannot leave the town, there is police outside!";

        int row = 0;
        int coll = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("D")) {
                    row = i;
                    coll = j;
                }
            }
        }

        int stolenPrice = 0;
        int k = 0;

        boolean caughtByPolice = false;


        while (!caughtByPolice && k < tokens.length) {

            int moneyInTheHouse = 0;

            String command = tokens[k];
            k++;

            matrix[row][coll] = "+";

            switch (command) {

                case "up":

                    if (row - 1 >= 0) {
                        row -= 1;

                        if (matrix[row][coll].equals("$")) {
                            matrix[row][coll] = "D";
                            moneyInTheHouse = row * coll;
                            stolenPrice += moneyInTheHouse;
                            System.out.println("You successfully stole " + moneyInTheHouse + "$.");
                        } else if (matrix[row][coll].equals("P")) {
                            matrix[row][coll] = "#";
                            caughtByPolice = true;
                            continue;
                        } else {
                            matrix[row][coll] = "D";
                        }

                    } else {
                        matrix[row][coll] = "D";
                        System.out.println(outside);
                    }


                    break;
                case "down":

                    if (row + 1 < n) {
                        row += 1;

                        if (matrix[row][coll].equals("$")) {
                            matrix[row][coll] = "D";
                            moneyInTheHouse = row * coll;
                            stolenPrice += moneyInTheHouse;
                            System.out.println("You successfully stole " + moneyInTheHouse + "$.");
                        } else if (matrix[row][coll].equals("P")) {
                            matrix[row][coll] = "#";
                            caughtByPolice = true;
                            continue;
                        } else {
                            matrix[row][coll] = "D";
                        }

                    } else {
                        matrix[row][coll] = "D";
                        System.out.println(outside);
                    }


                    break;
                case "right":

                    if (coll + 1 < n) {
                        coll += 1;

                        if (matrix[row][coll].equals("$")) {
                            matrix[row][coll] = "D";
                            moneyInTheHouse = row * coll;
                            stolenPrice += moneyInTheHouse;
                            System.out.println("You successfully stole " + moneyInTheHouse + "$.");
                        } else if (matrix[row][coll].equals("P")) {
                            matrix[row][coll] = "#";
                            caughtByPolice = true;
                            continue;
                        } else {
                            matrix[row][coll] = "D";
                        }

                    } else {
                        matrix[row][coll] = "D";
                        System.out.println(outside);
                    }


                    break;
                case "left":

                    if (coll - 1 >= 0) {
                        coll -= 1;

                        if (matrix[row][coll].equals("$")) {
                            matrix[row][coll] = "D";
                            moneyInTheHouse = row * coll;
                            stolenPrice += moneyInTheHouse;
                            System.out.println("You successfully stole " + moneyInTheHouse + "$.");
                        } else if (matrix[row][coll].equals("P")) {
                            matrix[row][coll] = "#";
                            caughtByPolice = true;
                            continue;
                        } else {
                            matrix[row][coll] = "D";
                        }

                    } else {
                        matrix[row][coll] = "D";
                        System.out.println(outside);
                    }


                    break;
            }

        }
        if (caughtByPolice) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenPrice);
        }else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",stolenPrice);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}

