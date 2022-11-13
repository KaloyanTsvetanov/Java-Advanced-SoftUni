import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfPresents = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        String[][] neighborhood = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("\\s+");
            neighborhood[i] = arr;
        }
        boolean equalEnd = false;
        int goodBoys = 0;
        int santaRow = 0;
        int santaColl = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (neighborhood[i][j].equals("S")) {
                    santaRow = i;
                    santaColl = j;
                }
                if (neighborhood[i][j].equals("V")) {
                    goodBoys++;
                }
            }
        }
        String input = scanner.nextLine();
        while (countOfPresents > 0 && !input.equals("Christmas morning")) {
            switch (input) {
                case "up":


                    if (santaRow - 1 >= 0) {
                        if (neighborhood[santaRow - 1][santaColl].equals("V")) {
                            neighborhood[santaRow - 1][santaColl] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                            countOfPresents--;
                        } else if (neighborhood[santaRow - 1][santaColl].equals("C")) {
                            neighborhood[santaRow - 1][santaColl] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                            if (neighborhood[santaRow - 2][santaColl].equals("X") || neighborhood[santaRow - 2][santaColl].equals("V")) {
                                neighborhood[santaRow - 2][santaColl] = "-";
                                countOfPresents--;
                            }
                            if (neighborhood[santaRow - 1][santaColl - 1].equals("X") || neighborhood[santaRow - 1][santaColl - 1].equals("V")) {
                                neighborhood[santaRow - 1][santaColl - 1] = "-";
                                countOfPresents--;
                            }
                            if (neighborhood[santaRow - 1][santaColl + 1].equals("X") || neighborhood[santaRow - 1][santaColl + 1].equals("V")) {
                                neighborhood[santaRow - 1][santaColl + 1] = "-";
                                countOfPresents--;
                            }
                            if (countOfPresents <= 0) {
                                equalEnd = true;
                            }

                        } else {
                            neighborhood[santaRow - 1][santaColl] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                        }
                    }


                    break;
                case "down":

                    if (santaRow + 1 < n) {
                        if (neighborhood[santaRow + 1][santaColl].equals("V")) {
                            neighborhood[santaRow + 1][santaColl] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                            countOfPresents--;
                        } else if (neighborhood[santaRow + 1][santaColl].equals("C")) {
                            neighborhood[santaRow + 1][santaColl] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                            if (neighborhood[santaRow + 2][santaColl].equals("X") || neighborhood[santaRow + 2][santaColl].equals("V")) {
                                neighborhood[santaRow + 2][santaColl] = "-";
                                countOfPresents--;
                            }
                            if (neighborhood[santaRow + 1][santaColl - 1].equals("X") || neighborhood[santaRow + 1][santaColl - 1].equals("V")) {
                                neighborhood[santaRow + 1][santaColl - 1] = "-";
                                countOfPresents--;
                            }
                            if (neighborhood[santaRow + 1][santaColl + 1].equals("X") || neighborhood[santaRow + 1][santaColl + 1].equals("V")) {
                                neighborhood[santaRow + 1][santaColl + 1] = "-";
                                countOfPresents--;
                            }
                            if (countOfPresents <= 0) {
                                equalEnd = true;
                            }
                        } else {
                            neighborhood[santaRow + 1][santaColl] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                        }
                    }


                    break;
                case "left":

                    if (santaColl - 1 >= 0) {
                        if (neighborhood[santaRow][santaColl - 1].equals("V")) {
                            neighborhood[santaRow][santaColl - 1] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                            countOfPresents--;
                        } else if (neighborhood[santaRow][santaColl - 1].equals("C")) {
                            neighborhood[santaRow][santaColl - 1] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                            if (neighborhood[santaRow][santaColl - 2].equals("X") || neighborhood[santaRow][santaColl - 2].equals("V")) {
                                neighborhood[santaRow][santaColl - 2] = "-";
                                countOfPresents--;
                            }
                            if (neighborhood[santaRow - 1][santaColl - 1].equals("X") || neighborhood[santaRow - 1][santaColl - 1].equals("V")) {
                                neighborhood[santaRow - 1][santaColl - 1] = "-";
                                countOfPresents--;
                            }
                            if (neighborhood[santaRow + 1][santaColl - 1].equals("X") || neighborhood[santaRow + 1][santaColl - 1].equals("V")) {
                                neighborhood[santaRow + 1][santaColl - 1] = "-";
                                countOfPresents--;
                            }
                            if (countOfPresents <= 0) {
                                equalEnd = true;
                            }
                        } else {
                            neighborhood[santaRow][santaColl - 1] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                        }
                    }


                    break;
                case "right":

                    if (santaColl + 1 < n) {
                        if (neighborhood[santaRow][santaColl + 1].equals("V")) {
                            neighborhood[santaRow][santaColl + 1] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                            countOfPresents--;
                        } else if (neighborhood[santaRow][santaColl + 1].equals("C")) {
                            neighborhood[santaRow][santaColl + 1] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                            if (neighborhood[santaRow][santaColl + 2].equals("X") || neighborhood[santaRow][santaColl + 2].equals("V")) {
                                neighborhood[santaRow][santaColl + 2] = "-";
                                countOfPresents--;
                            }
                            if (neighborhood[santaRow - 1][santaColl + 1].equals("X") || neighborhood[santaRow - 1][santaColl + 1].equals("V")) {
                                neighborhood[santaRow - 1][santaColl + 1] = "-";
                                countOfPresents--;
                            }
                            if (neighborhood[santaRow + 1][santaColl + 1].equals("X") || neighborhood[santaRow + 1][santaColl + 1].equals("V")) {
                                neighborhood[santaRow + 1][santaColl + 1] = "-";
                                countOfPresents--;
                            }
                            if (countOfPresents <= 0) {
                                equalEnd = true;
                            }
                        } else {
                            neighborhood[santaRow][santaColl + 1] = "S";
                            neighborhood[santaRow][santaColl] = "-";
                        }
                    }
                    break;

            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (neighborhood[i][j].equals("S")) {
                        santaRow = i;
                        santaColl = j;
                    }
                }
            }

            if (countOfPresents <= 0) {
                break;
            }

            input = scanner.nextLine();
        }
        if (countOfPresents <= 0 && !equalEnd) {
            System.out.println("Santa ran out of presents!");
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(neighborhood[i][j] + " ");
                if (neighborhood[i][j].equals("V")) {
                    count++;
                }
            }
            System.out.println();
        }
        if (count == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", goodBoys);
        } else {
            System.out.printf("No presents for %d nice kid/s.", count);
        }
    }
}
