import java.util.*;

public class MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);

        String[][] matrix = new String[n][m];

        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            String[] arr = input.split(" ");
            matrix[i]=arr;
        }
        input = scanner.nextLine();
        while (!input.equals("END")) {

            if(input.split(" ").length!=5){
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            if(input.split(" ")[0].equals("swap")){
                int firstRow = Integer.parseInt(input.split(" ")[1]);
                int firstCol = Integer.parseInt(input.split(" ")[2]);
                int secondRow = Integer.parseInt(input.split(" ")[3]);
                int secondCol = Integer.parseInt(input.split(" ")[4]);
                if(firstRow>n-1 || firstCol>m-1 || secondRow>n-1 || secondCol>m-1){
                    System.out.println("Invalid input!");
                    input = scanner.nextLine();
                    continue;
                }
                String saveWord = matrix[firstRow][firstCol];
                matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                matrix[secondRow][secondCol] = saveWord;
                printMatrix(matrix);
            }else {
                System.out.println("Invalid input!");
            }


            input = scanner.nextLine();
        }


    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
