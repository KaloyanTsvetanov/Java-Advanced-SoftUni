import java.util.*;

public class SumMatrixElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int m = Integer.parseInt(input.split("\\,\\s+")[0]);
        int n = Integer.parseInt(input.split("\\,\\s+")[1]);

        int[][] firstMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            int [] arr = Arrays
                    .stream(scanner.nextLine().split("\\, "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            firstMatrix[i] = arr;

        }
        int sum = 0;
        for(int [] p : firstMatrix){
            for (int s :p){
                sum+=s;
            }
        }
        System.out.println(m);
        System.out.println(n);
        System.out.println(sum);

    }
}
