import java.util.*;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        int elemRow = rows - 1;
        int elemCol = cols - 1;

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            input = scanner.nextLine();
            int[] arr = Arrays
                    .stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }
//        matrix[elemRow][elemCol];
//        matrix[elemRow][elemCol-1];//pechatame matrix[elemRow-1][elemeCol+0]
//        matrix[elemRow][elemCol-2]// pechatame matrix[elemRow-1][elemCol-1] and matrix [elemRow -2] [elemCol+0]
//        matrix[elemRow][elemCol-3];//pechatame matrix[elemRow -1][elemCol-2] and matrix[elemRow -2] [elemCol-1]
        int index = 0;
        while (elemCol + index >= 0) {
            System.out.print(matrix[elemRow][elemCol + index] + " ");
            int i = 1;
            int j = 1;
            int currentCol = elemCol + index;
            while (elemRow - i >= 0 && currentCol + j <= elemCol) {
                System.out.print(matrix[elemRow - i][currentCol + j] + " ");
                i++;
                j++;
            }
            if (elemCol + index == 0) {
                i = 1;

                while (elemRow - i >= 0) {
                    int p = 0;
                    int currentRow = elemRow - i;
                    System.out.println();
                    int k = 0;
                    while (currentRow - p >= 0 && currentCol+k<matrix[0].length) {
                        System.out.print(matrix[currentRow - p][currentCol + k] + " ");
                        p++;
                        k++;
                    }
                    i++;
                }

            }


            index--;
            System.out.println();
        }

    }
}
