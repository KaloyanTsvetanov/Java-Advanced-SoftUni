import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        String[][] matrix = new String[n][];
        List<String> correctPath = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("\\s+");
            matrix[i] = arr;
        }

        int row = 0;
        int coll = 0;
        int treasureRow = 0;
        int treasureColl = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("Y")) {
                    row = i;
                    coll = j;
                    matrix[i][j] = "-";
                }
                if (matrix[i][j].equals("X")) {
                    treasureRow = i;
                    treasureColl = j;
                }
            }
        }


        String command = scanner.nextLine();

        while (!command.equals("Finish")) {


            switch (command) {

                case "up":

                    if (row - 1 >= 0 && !matrix[row - 1][coll].equals("T")) {
                        row -= 1;
                        correctPath.add(command);
                    }

                    break;
                case "down":

                    if (row + 1 < n && !matrix[row + 1][coll].equals("T")) {
                        row += 1;
                        correctPath.add(command);
                    }


                    break;
                case "right":

                    if (coll + 1 < matrix[row].length && !matrix[row][coll + 1].equals("T")) {
                        coll += 1;
                        correctPath.add(command);
                    }

                    break;
                case "left":

                    if (coll - 1 >= 0 && !matrix[row][coll - 1].equals("T")) {
                        coll -= 1;
                        correctPath.add(command);
                    }

                    break;
            }

            command = scanner.nextLine();

        }
        if (row == treasureRow && coll == treasureColl) {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", correctPath));
        } else {
            System.out.println("The map is fake!");
        }


    }
}

