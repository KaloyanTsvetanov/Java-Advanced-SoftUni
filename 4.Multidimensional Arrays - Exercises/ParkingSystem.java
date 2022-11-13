import java.util.*;

public class ParkingSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rowsTotal = Integer.parseInt(input.split("\\s+")[0]);
        int colsTotal = Integer.parseInt(input.split("\\s+")[1]);

        boolean[][] matrix = new boolean[rowsTotal][colsTotal];

        input = scanner.nextLine();

        for (int i = 0; i < rowsTotal; i++) {
            matrix[i][0]=true;
        }

        while (!input.equals("stop")) {

            boolean freeSpace = false;



            int entryRow = Integer.parseInt(input.split("\\s+")[0]);
            int row = Integer.parseInt(input.split("\\s+")[1]);
            int col = Integer.parseInt(input.split("\\s+")[2]);
            int travelDistance = 1;
            travelDistance += Math.abs(row - entryRow);

            if (!matrix[row][col]) {
                travelDistance += col;
                matrix[row][col] = true;
                freeSpace = true;
            } else {
                for (int i = 1; i < matrix[row].length; i++) {
                    if (col - i > 0 && !matrix[row][col - i]) {
                        matrix[row][col - i] = true;
                        freeSpace = true;
                        travelDistance += (col - i);
                        break;
                    }
                    if (col + i < matrix[row].length && !matrix[row][col + i]) {
                        matrix[row][col + i] = true;
                        freeSpace = true;
                        travelDistance += (col + i);
                        break;
                    }
                }
            }

            if (freeSpace) {
                System.out.println(travelDistance);
            } else {
                System.out.printf("Row %d full%n", row);
            }
            input = scanner.nextLine();
        }

    }
}
