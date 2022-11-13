import java.util.*;

public class FillMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split("\\,\\s+")[0]);

        String pattern = input.split("\\,\\s+")[1];

        int[][] matrix = new int[n][n];

        int p = 1;

        if (pattern.equals("A")) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = p;
                    p++;
                }
            }

        } else if (pattern.equals("B")) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j++) {
                        matrix[j][i] = p;
                        p++;
                    }
                }else {
                    for (int j = n-1; j >=0 ; j--) {
                        matrix[j][i] = p;
                        p++;
                    }
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


    }
}
