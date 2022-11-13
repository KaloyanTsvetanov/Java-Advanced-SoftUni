import java.util.*;

public class TheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String [][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            input = scanner.nextLine();
            String[] arr =input.split("\\s+");
            matrix[i]=arr;
        }
        input = scanner.nextLine();

        String newSymbol = input;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals(newSymbol)){
                    matrix[i][j] = "*";
                }
            }
        }

        input = scanner.nextLine();

        int rowElement = Integer.parseInt(input.split("\\s+")[0]);
        int colElement = Integer.parseInt(input.split("\\s+")[1]);

        String oldSymbol = matrix[rowElement][colElement];

        matrix[rowElement][colElement] = newSymbol;
        boolean thereIsNoMore =false;

        while (!thereIsNoMore){

            thereIsNoMore=true;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j].equals(newSymbol)){
                        if(i-1>=0 && matrix[i-1][j].equals(oldSymbol)){
                            matrix[i-1][j] = newSymbol;
                            thereIsNoMore = false;
                        }
                        if(j-1>=0 && matrix[i][j-1].equals(oldSymbol)){
                            matrix[i][j-1] = newSymbol;
                            thereIsNoMore = false;
                        }
                        if(i+1< matrix.length && matrix[i+1][j].equals(oldSymbol)){
                            matrix[i+1][j] = newSymbol;
                            thereIsNoMore = false;
                        }
                        if(j+1<matrix[i].length && matrix[i][j+1].equals(oldSymbol)){
                            matrix[i][j+1] = newSymbol;
                            thereIsNoMore = false;
                        }
                    }

                }
            }

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("*")){
                    matrix[i][j] = newSymbol;
                }
            }
        }
        for (String[] a : matrix){
            for(String b : a){
                System.out.print(b);
            }
            System.out.println();
        }
    }
}
