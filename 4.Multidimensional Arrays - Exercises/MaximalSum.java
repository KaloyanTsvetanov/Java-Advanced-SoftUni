import java.util.*;

public class MaximalSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);
        int maxSum = 0;
        int[] index= new int[2];

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;

        }

        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j <m-2 ; j++) {
                int sum = matrix[i][j]+matrix[i][j+1]+matrix[i][j+2]+matrix[i+1][j]+matrix[i+1][j+1]+matrix[i+1][j+2]+matrix[i+2][j]+matrix[i+2][j+1]+matrix[i+2][j+2];
                if(sum>maxSum){
                    maxSum=sum;
                    index[0]=i;
                    index[1]=j;
                }

            }
        }
        System.out.println("Sum = "+maxSum);
        for (int i = index[0]; i < index[0]+3; i++) {
            for (int j = index[1]; j < index[1]+3; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
