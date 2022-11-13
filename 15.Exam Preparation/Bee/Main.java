import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("");
            matrix[i] = arr;
        }
        int beeRow = 0;
        int beeColl = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("B")) {
                    beeRow = i;
                    beeColl = j;
                }
            }
        }

        int pollinateCount = 0;

        boolean outOfBounds = false;

        String input = scanner.nextLine();

        while (!input.equals("End") && !outOfBounds) {
            int currentRow = beeRow;
            int currentColl = beeColl;

            switch (input) {
                case "up":
                    matrix[beeRow][beeColl] = ".";
                    if (beeRow - 1 < 0) {
                        outOfBounds = true;
                        continue;
                    } else {
                        beeRow -= 1;
                        if (matrix[beeRow][beeColl].equals("f")) {
                            pollinateCount++;
                        } else if (matrix[beeRow][beeColl].equals("O")) {
                            matrix[beeRow][beeColl] = ".";
                            beeRow -= 1;
                            if (matrix[beeRow][beeColl].equals("f")) {
                                pollinateCount++;
                            }
                        }
                        matrix[beeRow][beeColl] = "B";
                    }

                    break;
                case "down":

                    matrix[beeRow][beeColl] = ".";
                    if (beeRow + 1 >= n) {
                        outOfBounds = true;
                        continue;
                    } else {
                        beeRow += 1;
                        if (matrix[beeRow][beeColl].equals("f")) {
                            pollinateCount++;
                        } else if (matrix[beeRow][beeColl].equals("O")) {
                            matrix[beeRow][beeColl] = ".";
                            beeRow += 1;
                            if (matrix[beeRow][beeColl].equals("f")) {
                                pollinateCount++;
                            }
                        }
                        matrix[beeRow][beeColl] = "B";
                    }

                    break;
                case "right":

                    matrix[beeRow][beeColl] = ".";
                    if (beeColl + 1 >= n) {
                        outOfBounds = true;
                        continue;
                    } else {
                        beeColl += 1;
                        if (matrix[beeRow][beeColl].equals("f")) {
                            pollinateCount++;
                        } else if (matrix[beeRow][beeColl].equals("O")) {
                            matrix[beeRow][beeColl] = ".";
                            beeColl += 1;
                            if (matrix[beeRow][beeColl].equals("f")) {
                                pollinateCount++;
                            }
                        }
                        matrix[beeRow][beeColl] = "B";
                    }

                    break;
                case "left":

                    matrix[beeRow][beeColl] = ".";
                    if(beeColl-1<0){
                        outOfBounds = true;
                        continue;
                    }else {
                        beeColl-=1;
                        if(matrix[beeRow][beeColl].equals("f")){
                            pollinateCount++;
                        }else if(matrix[beeRow][beeColl].equals("O")){
                            matrix[beeRow][beeColl] = ".";
                            beeColl-=1;
                            if(matrix[beeRow][beeColl].equals("f")){
                                pollinateCount++;
                            }
                        }
                        matrix[beeRow][beeColl] = "B";
                    }

                    break;
            }


            input = scanner.nextLine();
        }
        if(outOfBounds){
            System.out.println("The bee got lost!");
        }
        if(pollinateCount<5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",(5-pollinateCount));
        }else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",pollinateCount);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

