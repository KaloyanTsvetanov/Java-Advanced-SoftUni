import java.util.*;

public class CompareMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);
        if(Arrays.deepEquals(firstMatrix, secondMatrix)){
            System.out.println("equal");
        }else System.out.println("not equal");
    }

    private static int[][] readMatrix(Scanner scanner) {
        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        int[][] matrix = new int[rows][cols];


        for (int i = 0; i < rows; i++) {
            input = scanner.nextLine();
            int[] arr = Arrays
                    .stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }

        return matrix;
    }
}
