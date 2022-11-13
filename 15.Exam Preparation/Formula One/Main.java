import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("");
            matrix[i] = arr;
        }
        int row = 0;
        int coll = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("P")) {
                    row = i;
                    coll = j;
                }
            }
        }

        boolean finish = false;


        while (!finish && count-- > 0) {
            int currentRow = row;
            int currentColl = coll;

            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    if (row - 1 < 0) {
                        row = n - 1;
                    } else {
                        row -= 1;
                    }
                    if (matrix[row][coll].equals("F")) {
                        matrix[currentRow][currentColl] = ".";
                        matrix[row][coll] = "P";
                        finish = true;
                        continue;
                    } else if (matrix[row][coll].equals("T")) {
                        row = currentRow;
                        coll = currentColl;
                    } else if (matrix[row][coll].equals("B")) {
                        matrix[currentRow][currentColl] = ".";
                        row -= 1;
                        if (row < 0) {
                            row = n - 1;
                        }
                        if(matrix[row][coll].equals("F")){
                            matrix[row][coll] = "P";
                            finish = true;
                            continue;
                        }else {
                            matrix[row][coll] = "P";
                        }
                    }else {
                        matrix[currentRow][currentColl] = ".";
                        matrix[row][coll] = "P";
                    }


                    break;
                case "down":
                    if (row + 1 >= n) {
                        row = 0;
                    } else {
                        row += 1;
                    }
                    if (matrix[row][coll].equals("F")) {
                        matrix[currentRow][currentColl] = ".";
                        matrix[row][coll] = "P";
                        finish = true;
                        continue;
                    } else if (matrix[row][coll].equals("T")) {
                        row = currentRow;
                        coll = currentColl;
                    } else if (matrix[row][coll].equals("B")) {
                        matrix[currentRow][currentColl] = ".";
                        row += 1;
                        if (row >= n) {
                            row =0;
                        }
                        if(matrix[row][coll].equals("F")){
                            matrix[row][coll] = "P";
                            finish = true;
                            continue;
                        }else {
                            matrix[row][coll] = "P";
                        }
                    }else {
                        matrix[currentRow][currentColl] = ".";
                        matrix[row][coll] = "P";
                    }

                    break;
                case "right":

                    if (coll + 1 >= n) {
                        coll = 0;
                    } else {
                        coll += 1;
                    }
                    if (matrix[row][coll].equals("F")) {
                        matrix[currentRow][currentColl] = ".";
                        matrix[row][coll] = "P";
                        finish = true;
                        continue;
                    } else if (matrix[row][coll].equals("T")) {
                        row = currentRow;
                        coll = currentColl;
                    } else if (matrix[row][coll].equals("B")) {
                        matrix[currentRow][currentColl] = ".";
                        coll += 1;
                        if (coll >= n) {
                            coll =0;
                        }
                        if(matrix[row][coll].equals("F")){
                            matrix[row][coll] = "P";
                            finish = true;
                            continue;
                        }else {
                            matrix[row][coll] = "P";
                        }
                    }else {
                        matrix[row][coll] = "P";
                        matrix[currentRow][currentColl] = ".";
                    }

                    break;
                case "left":

                    if (coll - 1 < 0) {
                        coll = n - 1;
                    } else {
                        coll -= 1;
                    }
                    if (matrix[row][coll].equals("F")) {
                        matrix[currentRow][currentColl] = ".";
                        matrix[row][coll] = "P";
                        finish = true;
                        continue;
                    } else if (matrix[row][coll].equals("T")) {
                        row = currentRow;
                        coll = currentColl;
                    } else if (matrix[row][coll].equals("B")) {
                        matrix[currentRow][currentColl] = ".";
                        coll -= 1;
                        if (coll < 0) {
                            coll = n - 1;
                        }
                        if(matrix[row][coll].equals("F")){
                            matrix[row][coll] = "P";
                            finish = true;
                            continue;
                        }else {
                            matrix[row][coll] = "P";
                        }
                    }else {
                        matrix[currentRow][currentColl] = ".";
                        matrix[row][coll] = "P";
                    }

                    break;
            }


        }
        if(finish){
            System.out.println("Well done, the player won first place!");
        }else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

