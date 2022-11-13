import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][];
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("");
            matrix[i] = arr;
        }
        int row = 0;
        int coll = 0;
        int rowHelen = 0;
        int collHelen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("P")) {
                    row = i;
                    coll = j;
                }
                if (matrix[i][j].equals("H")) {
                    rowHelen = i;
                    collHelen = j;
                }
            }
        }

        boolean escape = false;
        boolean noEnergy = false;


        while (!escape && energy > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];

            int spawnRow = Integer.parseInt(tokens[1]);
            int spawnColl = Integer.parseInt(tokens[2]);

            matrix[spawnRow][spawnColl] = "S";
            energy--;

            switch (command) {
                case "up":
                    if (row - 1 >= 0) {
                        matrix[row][coll] = "-";
                        row -= 1;
                        if (matrix[row][coll].equals("S")) {
                            energy -= 2;
                            matrix[row][coll] = "P";
                        } else if (matrix[row][coll].equals("H")) {
                            escape = true;
                            matrix[row][coll] = "-";
                            continue;
                        } else {
                            matrix[row][coll] = "P";
                        }
                    }

                    break;
                case "down":
                    if (row + 1 < n) {
                        matrix[row][coll] = "-";
                        row += 1;
                        if (matrix[row][coll].equals("S")) {
                            energy -= 2;
                            matrix[row][coll] = "P";
                        } else if (matrix[row][coll].equals("H")) {
                            escape = true;
                            matrix[row][coll] = "-";
                            continue;
                        } else {
                            matrix[row][coll] = "P";
                        }
                    }

                    break;
                case "right":

                    if (coll + 1 < matrix[0].length) {
                        matrix[row][coll] = "-";
                        coll += 1;
                        if (matrix[row][coll].equals("S")) {
                            energy -= 2;
                            matrix[row][coll] = "P";
                        } else if (matrix[row][coll].equals("H")) {
                            escape = true;
                            matrix[row][coll] = "-";
                            continue;
                        } else {
                            matrix[row][coll] = "P";
                        }
                    }

                    break;
                case "left":

                    if (coll - 1 >= 0) {
                        matrix[row][coll] = "-";
                        coll -= 1;
                        if (matrix[row][coll].equals("S")) {
                            energy -= 2;
                            matrix[row][coll] = "P";
                        } else if (matrix[row][coll].equals("H")) {
                            escape = true;
                            matrix[row][coll] = "-";
                            continue;
                        } else {
                            matrix[row][coll] = "P";
                        }
                    }

                    break;
            }
            if (energy <= 0){
                matrix[row][coll] = "X";
                noEnergy = true;
            }

        }
        if(noEnergy){
            System.out.println("Paris died at "+row+";"+coll+".");
        }
        if(escape){
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n",energy);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}

