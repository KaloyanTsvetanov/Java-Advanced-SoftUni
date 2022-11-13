import java.util.*;

public class Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);

        String[][] matrix = new String[n][m];

        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String numToString = String.valueOf(num);
                matrix[i][j] = numToString;
                num++;
            }
        }

        input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {

            int row = Math.abs(Integer.parseInt(input.split(" ")[0]));
            int col = Math.abs(Integer.parseInt(input.split(" ")[1]));
            int radius = Integer.parseInt(input.split(" ")[2]);
            int counter = 0;
            if (row >= n || col >= m || row < 0 || col < 0) {
                input = scanner.nextLine();
                continue;
            }
            if (matrix[row][0].equals(" ")) {
                while (matrix[row][0].equals(" ")) {
                    row++;
                    counter++;
                    if(row>=n){
                        row--;
                        break;
                    }

                }

            }
            if (matrix[row][col].equals(" ")) {
                input = scanner.nextLine();
                continue;
            }
            int upRow = row - radius - counter;
            int downRow = row + radius;
            int leftCol = col - radius;
            int rightCol = col + radius;
            if (upRow < 0) {
                upRow = 0;
            }
            if (downRow > n - 1) {
                downRow = n - 1;
            }
            if (leftCol < 0) {
                leftCol = 0;
            }
            if (rightCol > m - 1) {
                rightCol = m - 1;
            }
            for (int i = upRow; i <= downRow; i++) {
                matrix[i][col] = " ";
            }
            for (int i = leftCol; i <= rightCol; i++) {
                matrix[row][i] = " ";
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j].equals(" ")) {
                        int p = j;
                        while (p < m) {
                            if (!matrix[i][p].equals(" ")) {
                                matrix[i][j] = matrix[i][p];
                                matrix[i][p] = " ";
                                j++;
                            }
                            p++;
                        }
                    }
                }
            }


            input = scanner.nextLine();
        }

        for (int i = 0; i < n; i++) {
            List<String> arr = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (!matrix[i][j].equals(" ")) {
                    arr.add(matrix[i][j]);
                }

            }
            if (!arr.isEmpty()) {
                for (String p : arr) {
                    System.out.print(p + " ");
                }
                System.out.println();
            }
        }

    }
}
