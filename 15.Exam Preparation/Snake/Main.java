import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        String a = scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("");
            matrix[i] = arr;
        }
        int food = 0;

        int snakeRow = 0;
        int snakeColl = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("S")) {
                    snakeRow = i;
                    snakeColl = j;
                }
            }
        }
        boolean outOfBounds = false;



        while (food < 10 && !outOfBounds) {
            int currentRow = snakeRow;
            int currentColl = snakeColl;
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    if (snakeRow - 1 < 0) {
                        matrix[snakeRow][snakeColl] = ".";
                        outOfBounds = true;
                        continue;
                    } else {
                        snakeRow -= 1;
                        matrix[currentRow][currentColl] = ".";
                        if (matrix[snakeRow][snakeColl].equals("B")) {
                            matrix[snakeRow][snakeColl] = ".";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("B")) {
                                        snakeRow = i;
                                        snakeColl = j;
                                    }
                                }
                            }
                            matrix[snakeRow][snakeColl] = "S";
                        } else if (matrix[snakeRow][snakeColl].equals("*")) {
                            matrix[snakeRow][snakeColl] = "S";
                            food++;
                        } else {
                            matrix[snakeRow][snakeColl] = "S";
                        }
                    }

                    break;
                case "down":
                    if (snakeRow + 1 >= n) {
                        matrix[snakeRow][snakeColl] = ".";
                        outOfBounds = true;
                        continue;
                    } else {
                        snakeRow += 1;
                        matrix[currentRow][currentColl] = ".";
                        if (matrix[snakeRow][snakeColl].equals("B")) {
                            matrix[snakeRow][snakeColl] = ".";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("B")) {
                                        snakeRow = i;
                                        snakeColl = j;
                                    }
                                }
                            }
                            matrix[snakeRow][snakeColl] = "S";
                        } else if (matrix[snakeRow][snakeColl].equals("*")) {
                            matrix[snakeRow][snakeColl] = "S";
                            food++;
                        } else {
                            matrix[snakeRow][snakeColl] = "S";
                        }
                    }

                    break;
                case "right":

                    if (snakeColl + 1 >= n) {
                        matrix[snakeRow][snakeColl] = ".";
                        outOfBounds = true;
                        continue;
                    } else {
                        snakeColl += 1;
                        matrix[currentRow][currentColl] = ".";
                        if (matrix[snakeRow][snakeColl].equals("B")) {
                            matrix[snakeRow][snakeColl] = ".";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("B")) {
                                        snakeRow = i;
                                        snakeColl = j;
                                    }
                                }
                            }
                            matrix[snakeRow][snakeColl] = "S";
                        } else if (matrix[snakeRow][snakeColl].equals("*")) {
                            matrix[snakeRow][snakeColl] = "S";
                            food++;
                        } else {
                            matrix[snakeRow][snakeColl] = "S";
                        }
                    }



                    break;
                case "left":

                    if (snakeColl - 1 < 0) {
                        matrix[snakeRow][snakeColl] = ".";
                        outOfBounds = true;
                        continue;
                    } else {
                        snakeColl -= 1;
                        matrix[currentRow][currentColl] = ".";
                        if (matrix[snakeRow][snakeColl].equals("B")) {
                            matrix[snakeRow][snakeColl] = ".";
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    if (matrix[i][j].equals("B")) {
                                        snakeRow = i;
                                        snakeColl = j;
                                    }
                                }
                            }
                            matrix[snakeRow][snakeColl] = "S";
                        }else if(matrix[snakeRow][snakeColl].equals("*")){
                            matrix[snakeRow][snakeColl] = "S";
                            food++;
                        }else {
                            matrix[snakeRow][snakeColl] = "S";
                        }
                    }

                    break;
            }
        }
        if(food>=10){
            System.out.println("You won! You fed the snake.");
            System.out.printf("Food eaten: %d%n",food);

        }else {
            System.out.println("Game over!");
            System.out.printf("Food eaten: %d%n",food);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
