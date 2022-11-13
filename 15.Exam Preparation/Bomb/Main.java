import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        List<String> input = Arrays
                .stream(scanner.nextLine().split(","))
                .collect(Collectors.toList());

        int row = 0;
        int coll = 0;

        int bombs = 0;
        for (int i = 0; i < n; i++) {
            String [] arr = scanner.nextLine().split(" ");
            matrix[i] = arr;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("s")) {
                    row = i;
                    coll = j;
                }
                if (matrix[i][j].equals("B")) {
                    bombs++;
                }
            }
        }
        boolean endOfRout = false;
        while (!endOfRout && input.size() != 0 && bombs!=0) {
            String command = input.get(0);
            input.remove(0);

            switch (command) {
                case "up":
                    if (row - 1 < 0) {
                        continue;
                    } else {
                        matrix[row][coll] = "+";
                        row -= 1;
                    }
                    if(matrix[row][coll].equals("+")){
                        matrix[row][coll] = "s";
                    }else if (matrix[row][coll].equals("e")){
                        endOfRout = true;
                        continue;
                    } else if(matrix[row][coll].equals("B")){
                        System.out.println("You found a bomb!");
                        bombs--;
                        matrix[row][coll] = "s";
                    }
                    break;
                case "down":
                    if (row + 1 >= n) {
                        continue;
                    } else {
                        matrix[row][coll] = "+";
                        row += 1;
                    }
                    if(matrix[row][coll].equals("+")){
                        matrix[row][coll] = "s";
                    }else if (matrix[row][coll].equals("e")){
                        endOfRout = true;
                        continue;
                    } else if(matrix[row][coll].equals("B")){
                        System.out.println("You found a bomb!");
                        bombs--;
                        matrix[row][coll] = "s";
                    }
                    break;
                case "right":
                    if (coll + 1 >= n) {
                        continue;
                    } else {
                        matrix[row][coll] = "+";
                        coll += 1;
                    }
                    if(matrix[row][coll].equals("+")){
                        matrix[row][coll] = "s";
                    }else if (matrix[row][coll].equals("e")){
                        endOfRout = true;
                        continue;
                    } else if(matrix[row][coll].equals("B")){
                        System.out.println("You found a bomb!");
                        bombs--;
                        matrix[row][coll] = "s";
                    }
                    break;
                case "left":
                    if (coll - 1 < 0) {
                        continue;
                    } else {
                        matrix[row][coll] = "+";
                        coll -= 1;
                    }
                    if(matrix[row][coll].equals("+")){
                        matrix[row][coll] = "s";
                    }else if (matrix[row][coll].equals("e")){
                        endOfRout = true;
                        continue;
                    } else if(matrix[row][coll].equals("B")){
                        System.out.println("You found a bomb!");
                        bombs--;
                        matrix[row][coll] = "s";
                    }
                    break;
            }

        }
        if(bombs==0){
            System.out.println("Congratulations! You found all bombs!");
        }else if(endOfRout){
            System.out.printf("END! %d bombs left on the field",bombs);
        }else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombs,row,coll);
        }
    }
}

