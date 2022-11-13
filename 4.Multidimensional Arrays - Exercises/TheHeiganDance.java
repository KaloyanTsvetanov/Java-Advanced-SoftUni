import java.util.*;

public class TheHeiganDance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double d = Double.parseDouble(scanner.nextLine());

        int[][] matrix = new int[15][15];

        int playerPoint = 18500;
        int currentPlayerPoints = 18500;
        double heiganPoints = 3000000;
        int playerRow = 7;
        int playerCol = 7;

        boolean playerIsDead = false;
        boolean heiganIsDead = false;
        boolean cloud = false;

        matrix[playerRow][playerCol] = playerPoint;

        while (!playerIsDead && !heiganIsDead) {


            heiganPoints -= d;

            if (cloud) {
                cloud = false;
                currentPlayerPoints -= 3500;
                if (currentPlayerPoints <= 0) {
                    playerIsDead = true;
                    cloud = true;
                }

            }


            if (heiganPoints <= 0) {
                heiganIsDead = true;
                continue;
            }

            String input = scanner.nextLine();
            String spell = input.split("\\s+")[0];

            int row = Integer.parseInt(input.split("\\s+")[1]);
            int col = Integer.parseInt(input.split("\\s+")[2]);
            int upRow = row - 1;
            int downRow = row + 1;
            int leftCol = col - 1;
            int rightCol = col + 1;

            if (upRow < 0) {
                upRow = 0;
                row =0;

            }
            if (downRow > 14) {
                downRow = 14;
                row = 14;

            }
            if (leftCol < 0) {
                leftCol = 0;
                col=0;

            }
            if (rightCol > 14) {
                rightCol = 14;
                col=14;

            }

            if (spell.equals("Cloud")) {

                if (matrix[row][col] == playerPoint) {
                    currentPlayerPoints -= 3500;
                    cloud = true;
                } else if (matrix[upRow][leftCol] == playerPoint) {
                    if (upRow - 1 >= 0) {
                        matrix[upRow - 1][leftCol] = playerPoint;
                        matrix[upRow][leftCol] = 0;
                    } else if (leftCol - 1 >= 0) {
                        matrix[upRow][leftCol - 1] = playerPoint;
                        matrix[upRow][leftCol] = 0;
                    } else {
                        currentPlayerPoints -= 3500;
                        cloud = true;
                    }
                } else if (matrix[upRow][col] == playerPoint) {
                    if (upRow - 1 >= 0) {
                        matrix[upRow - 1][col] = playerPoint;
                        matrix[upRow][col] = 0;
                    } else {
                        currentPlayerPoints -= 3500;
                        cloud = true;
                    }
                } else if (matrix[upRow][rightCol] == playerPoint) {
                    if (upRow - 1 >= 0) {
                        matrix[upRow - 1][rightCol] = playerPoint;
                        matrix[upRow][rightCol] = 0;
                    } else if (rightCol + 1 <= 14) {
                        matrix[upRow][rightCol + 1] = playerPoint;
                        matrix[upRow][rightCol] = 0;
                    } else {
                        currentPlayerPoints -= 3500;
                        cloud = true;
                    }
                } else if (matrix[row][leftCol] == playerPoint) {
                    if (leftCol - 1 >= 0) {
                        matrix[row][leftCol - 1] = playerPoint;
                        matrix[row][leftCol] = 0;
                    } else {
                        currentPlayerPoints -= 3500;
                        cloud = true;
                    }
                } else if (matrix[row][rightCol] == playerPoint) {
                    if (rightCol + 1 <= 14) {
                        matrix[row][rightCol + 1] = playerPoint;
                        matrix[row][rightCol] = 0;
                    } else {
                        currentPlayerPoints -= 3500;
                        cloud = true;
                    }
                } else if (matrix[downRow][leftCol] == playerPoint) {
                    if (downRow + 1 <= 14) {
                        matrix[downRow + 1][leftCol] = playerPoint;
                        matrix[downRow][leftCol] = 0;
                    } else if (leftCol - 1 >= 0) {
                        matrix[downRow][leftCol - 1] = playerPoint;
                        matrix[downRow][leftCol] = 0;
                    } else {
                        currentPlayerPoints -= 3500;
                        cloud = true;
                    }
                } else if (matrix[downRow][col] == playerPoint) {
                    if (downRow + 1 <= 14) {
                        matrix[downRow + 1][col] = playerPoint;
                        matrix[downRow][col] = 0;
                    } else {
                        currentPlayerPoints -= 3500;
                        cloud = true;
                    }
                } else if (matrix[downRow][rightCol] == playerPoint) {
                    if (rightCol + 1 <= 14) {
                        matrix[downRow][rightCol + 1] = playerPoint;
                        matrix[downRow][rightCol] = 0;
                    } else if (downRow + 1 <= 14) {
                        matrix[downRow + 1][rightCol] = playerPoint;
                        matrix[downRow][rightCol] = 0;
                    } else {
                        currentPlayerPoints -= 3500;
                        cloud = true;
                    }
                }

                if (currentPlayerPoints <= 0) {
                    playerIsDead = true;
                }


            }

            if (spell.equals("Eruption")) {

                if (matrix[row][col] == playerPoint) {
                    currentPlayerPoints -= 6000;
                } else if (matrix[upRow][leftCol] == playerPoint) {
                    if (upRow - 1 >= 0) {
                        matrix[upRow - 1][leftCol] = playerPoint;
                        matrix[upRow][leftCol] = 0;
                    } else if (leftCol - 1 >= 0) {
                        matrix[upRow][leftCol - 1] = playerPoint;
                        matrix[upRow][leftCol] = 0;
                    } else {
                        currentPlayerPoints -= 6000;

                    }
                } else if (matrix[upRow][col] == playerPoint) {
                    if (upRow - 1 >= 0) {
                        matrix[upRow - 1][col] = playerPoint;
                        matrix[upRow][col] = 0;
                    } else {
                        currentPlayerPoints -= 6000;

                    }
                } else if (matrix[upRow][rightCol] == playerPoint) {
                    if (upRow - 1 >= 0) {
                        matrix[upRow - 1][rightCol] = playerPoint;
                        matrix[upRow][rightCol] = 0;
                    } else if (rightCol + 1 <= 14) {
                        matrix[upRow][rightCol + 1] = playerPoint;
                        matrix[upRow][rightCol] = 0;
                    } else {
                        currentPlayerPoints -= 6000;

                    }
                } else if (matrix[row][leftCol] == playerPoint) {
                    if (leftCol - 1 >= 0) {
                        matrix[row][leftCol - 1] = playerPoint;
                        matrix[row][leftCol] = 0;
                    } else {
                        currentPlayerPoints -= 6000;

                    }
                } else if (matrix[row][rightCol] == playerPoint) {
                    if (rightCol + 1 <= 14) {
                        matrix[row][rightCol + 1] = playerPoint;
                        matrix[row][rightCol] = 0;
                    } else {
                        currentPlayerPoints -= 6000;

                    }
                } else if (matrix[downRow][leftCol] == playerPoint) {
                    if (downRow + 1 <= 14) {
                        matrix[downRow + 1][leftCol] = playerPoint;
                        matrix[downRow][leftCol] = 0;
                    } else if (leftCol - 1 >= 0) {
                        matrix[downRow][leftCol - 1] = playerPoint;
                        matrix[downRow][leftCol] = 0;
                    } else {
                        currentPlayerPoints -= 6000;

                    }
                } else if (matrix[downRow][col] == playerPoint) {
                    if (downRow + 1 <= 14) {
                        matrix[downRow + 1][col] = playerPoint;
                        matrix[downRow][col] = 0;
                    } else {
                        currentPlayerPoints -= 6000;

                    }
                } else if (matrix[downRow][rightCol] == playerPoint) {
                    if (rightCol + 1 <= 14) {
                        matrix[downRow][rightCol + 1] = playerPoint;
                        matrix[downRow][rightCol] = 0;
                    } else if (downRow + 1 <= 14) {
                        matrix[downRow + 1][rightCol] = playerPoint;
                        matrix[downRow][rightCol] = 0;
                    } else {
                        currentPlayerPoints -= 6000;

                    }
                }

                if (currentPlayerPoints <= 0) {
                    playerIsDead = true;
                }


            }


        }
        if (playerIsDead && heiganIsDead) {
            System.out.println("Heigan: Defeated!");

            System.out.println("Player: Killed by Plague Cloud");

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    if (matrix[i][j] == playerPoint) {
                        System.out.printf("Final position: %d, %d", i, j);
                    }
                }
            }
        } else if (playerIsDead) {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
            if (cloud) {
                System.out.println("Player: Killed by Plague Cloud");
            } else {
                System.out.println("Player: Killed by Eruption");
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    if (matrix[i][j] == playerPoint) {
                        System.out.printf("Final position: %d, %d", i, j);
                    }
                }
            }
        } else if (heiganIsDead) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %d%n", currentPlayerPoints);
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    if (matrix[i][j] == playerPoint) {
                        System.out.printf("Final position: %d, %d", i, j);
                    }
                }
            }
        }

    }
}
