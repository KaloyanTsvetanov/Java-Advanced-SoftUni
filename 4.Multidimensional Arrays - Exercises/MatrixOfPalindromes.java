import java.util.*;

public class MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);

        String[][] matrix = new String[rows][cols];

        String firstWord = "aaa";
        char[] arr = firstWord.toCharArray();
        int p = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Arrays.toString(arr);
                char second = arr[1];
                arr[1]=(char) ((int) second+1);
            }
            arr[0]=(char) ((int) arr[0]+1);
            arr[1]=arr[0];
            arr[2]=arr[0];
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String word = matrix[i][j].toString();
                word=word.replaceAll("[\\[\\]]","");
                word=word.replaceAll("[\\,\\s+]","");
                System.out.print(word+" ");
            }
            System.out.println();
        }

    }
}
