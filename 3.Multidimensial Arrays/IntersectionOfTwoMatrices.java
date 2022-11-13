import java.util.*;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean iSNotFound = true;
        int[][] firstMatrix = readMatrix(scanner);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if(n==firstMatrix[i][j]){
                    System.out.println(i+" "+j);
                    iSNotFound = false;
                }
            }
        }
        if(iSNotFound){
            System.out.println("not found");
        }
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
