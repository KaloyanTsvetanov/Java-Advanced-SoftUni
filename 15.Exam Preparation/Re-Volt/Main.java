import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];
        boolean won = false;

        for (int i = 0; i < sizeOfMatrix; i++) {
            String[] arr = scanner.nextLine().split("");
            matrix[i] = arr;
        }
        int playerRow = 0;
        int playerColl = 0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                if (matrix[i][j].equals("f")) {
                    playerRow = i;
                    playerColl = j;
                }
            }
        }

        while (numberOfCommands-- > 0 && !won) {
            String input = scanner.nextLine();
            int beforeMoveRow = playerRow;
            int beforeMoveColl = playerColl;

            switch (input) {

                case "up":
                    matrix[beforeMoveRow][beforeMoveColl] = "-";
                    if (playerRow - 1 < 0) {
                        playerRow = matrix.length - 1;
                    } else {
                        playerRow = playerRow - 1;
                    }
                    if (matrix[playerRow][playerColl].equals("B")) {
                        if (playerRow - 1 < 0) {
                            playerRow = matrix.length - 1;
                        } else {
                            playerRow = playerRow - 1;
                        }
                        if (matrix[playerRow][playerColl].equals("F")) {
                            won = true;
                        }
                        matrix[playerRow][playerColl] = "f";
                    } else if (matrix[playerRow][playerColl].equals("T")) {
                        matrix[beforeMoveRow][beforeMoveColl] = "f";
                        playerColl = beforeMoveColl;
                        playerRow = beforeMoveRow;
                    } else if (matrix[playerRow][playerColl].equals("-")) {
                        matrix[playerRow][playerColl] = "f";
                    } else if (matrix[playerRow][playerColl].equals("F")) {
                        won = true;
                    }

                    break;
                case "down":

                    matrix[beforeMoveRow][beforeMoveColl] = "-";
                    if (playerRow + 1 >= matrix.length) {
                        playerRow = 0;
                    } else {
                        playerRow = playerRow + 1;
                    }
                    if (matrix[playerRow][playerColl].equals("B")) {
                        if (playerRow + 1 >= matrix.length) {
                            playerRow = 0;
                        } else {
                            playerRow = playerRow + 1;
                        }
                        if (matrix[playerRow][playerColl].equals("F")) {
                            won = true;
                        }
                        matrix[playerRow][playerColl] = "f";
                    } else if (matrix[playerRow][playerColl].equals("T")) {
                        matrix[beforeMoveRow][beforeMoveColl] = "f";
                        playerColl = beforeMoveColl;
                        playerRow = beforeMoveRow;
                    } else if (matrix[playerRow][playerColl].equals("-")) {
                        matrix[playerRow][playerColl] = "f";
                    } else if (matrix[playerRow][playerColl].equals("F")) {
                        won = true;
                    }

                    break;

                case "right":
                    matrix[beforeMoveRow][beforeMoveColl] = "-";
                    if (playerColl + 1 >= matrix.length) {
                        playerColl = 0;
                    } else {
                        playerColl = playerColl + 1;
                    }
                    if (matrix[playerRow][playerColl].equals("B")) {
                        if (playerColl + 1 >= matrix.length) {
                            playerColl = 0;
                        } else {
                            playerColl = playerColl + 1;
                        }
                        if (matrix[playerRow][playerColl].equals("F")) {
                            won = true;
                        }
                        matrix[playerRow][playerColl] = "f";
                    } else if (matrix[playerRow][playerColl].equals("T")) {
                        matrix[beforeMoveRow][beforeMoveColl] = "f";
                        playerColl = beforeMoveColl;
                        playerRow = beforeMoveRow;
                    } else if (matrix[playerRow][playerColl].equals("-")) {
                        matrix[playerRow][playerColl] = "f";
                    } else if (matrix[playerRow][playerColl].equals("F")) {
                        won = true;
                    }
                    break;

                case "left":
                    matrix[beforeMoveRow][beforeMoveColl] = "-";
                    if (playerColl - 1 < 0) {
                        playerColl = matrix.length - 1;
                    } else {
                        playerColl = playerColl - 1;
                    }
                    if (matrix[playerRow][playerColl].equals("B")) {
                        if (playerColl - 1 < 0) {
                            playerColl = matrix.length - 1;
                        } else {
                            playerColl = playerColl - 1;
                        }
                        if (matrix[playerRow][playerColl].equals("F")) {
                            won = true;
                        }
                        matrix[playerRow][playerColl] = "f";
                    } else if (matrix[playerRow][playerColl].equals("T")) {
                        matrix[beforeMoveRow][beforeMoveColl] = "f";
                        playerColl = beforeMoveColl;
                        playerRow = beforeMoveRow;
                    } else if (matrix[playerRow][playerColl].equals("-")) {
                        matrix[playerRow][playerColl] = "f";
                    } else if (matrix[playerRow][playerColl].equals("F")) {
                        won = true;
                    }

                    break;
            }


        }
        if (won) {
            System.out.println("Player won!");
            matrix[playerRow][playerColl] = "f";
        } else {
            System.out.println("Player lost!");
        }
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
