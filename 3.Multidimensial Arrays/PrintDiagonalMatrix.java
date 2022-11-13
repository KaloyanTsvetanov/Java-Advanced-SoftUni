import java.util.*;

public class PrintDiagonalMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int m = Integer.parseInt(input);
        int[][] firstMatrix = new int[m][m];

        for (int i = 0; i < m; i++) {

            input=scanner.nextLine();

            int[] arr = Arrays
                    .stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            firstMatrix[i] = arr;
        }
        for (int i = 0; i < m; i++) {
            System.out.print(firstMatrix[i][i]+" ");
        }
        System.out.println();
        int j = m-1;
        for (int i = 0; i < m; i++) {
            System.out.print(firstMatrix[j][i]+" ");
            j--;
        }
    }
}
