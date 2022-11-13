import java.util.*;

public class RadioactiveMutant {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean playerLost = false;
        boolean playerWin = false;
        int lasIndex1 = 0;
        int lasIndex2 = 0;

        String[] input = scanner.nextLine().split("\\s+");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        String[][] matrix = new String[a][b];

        for (int i = 0; i < matrix.length; i++) {
            input = scanner.nextLine().split("");
            matrix[i] = input;
        }
        input = scanner.nextLine().split("");
        int k = 0;
        while (!playerLost && !playerWin) {

            String direction = input[k];
            String[][] helpMatrix =new String[a][b];

            int rowP =-1;
            int colP = -1;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    helpMatrix[i][j]= matrix[i][j];
                    if (matrix[i][j].equals("P")) {
                        rowP = i;
                        colP = j;

                    }
                }
            }
            if(rowP==-1){
                playerLost = true;
                continue;
            }
            switch (direction){
                case "U":
                    if(rowP-1<0){
                        playerWin=true;
                        lasIndex1 = rowP;
                        lasIndex2 = colP;
                        matrix[rowP][colP]=".";
                    }else if(matrix[rowP-1][colP].equals("B")){
                        playerLost = true;
                        lasIndex1 = rowP-1;
                        lasIndex2 = colP;
                    }else {
                        matrix[rowP-1][colP]= "P";
                        matrix[rowP][colP]=".";
                        lasIndex1 = rowP-1;
                        lasIndex2 = colP;

                    }
                    break;
                case "R":
                    if(colP+1>=matrix[0].length){
                        playerWin=true;
                        lasIndex1 = rowP;
                        lasIndex2 = colP;
                        matrix[rowP][colP]=".";
                    }else if(matrix[rowP][colP+1].equals("B")){
                        playerLost = true;
                        lasIndex1 = rowP;
                        lasIndex2 = colP+1;
                    }else {
                        matrix[rowP][colP+1]= "P";
                        matrix[rowP][colP]=".";
                        lasIndex1 = rowP;
                        lasIndex2 = colP+1;
                    }
                    break;
                case "D":
                    if(rowP+1>= matrix.length){
                        playerWin=true;
                        lasIndex1 = rowP;
                        lasIndex2 = colP;
                        matrix[rowP][colP]=".";
                    }else if(matrix[rowP+1][colP].equals("B")){
                        playerLost = true;
                        lasIndex1 = rowP+1;
                        lasIndex2 = colP;
                    }else {
                        matrix[rowP+1][colP]= "P";
                        matrix[rowP][colP]=".";
                        lasIndex1 = rowP+1;
                        lasIndex2 = colP;
                    }
                    break;
                case "L":
                    if(colP-1<0){
                        playerWin=true;
                        lasIndex1 = rowP;
                        lasIndex2 = colP;
                        matrix[rowP][colP]=".";
                    }else if(matrix[rowP][colP-1].equals("B")){
                        playerLost = true;
                        lasIndex1 = rowP;
                        lasIndex2 = colP-1;
                    }else {
                        matrix[rowP][colP-1]= "P";
                        matrix[rowP][colP]=".";
                        lasIndex1 = rowP;
                        lasIndex2 = colP-1;
                    }
                    break;

            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {

                    if (matrix[i][j].equals("B")) {
                        if (i - 1 >= 0) {
                            helpMatrix[i - 1][j] = "B";
                        }
                        if (j - 1 >= 0) {
                            helpMatrix[i][j - 1] = "B";
                        }
                        if (i + 1 < matrix.length){
                            helpMatrix[i+1][j]="B";
                        }
                        if(j+1<matrix[i].length){
                            helpMatrix[i][j+1]="B";
                        }

                    }

                }
            }
            for (int i = 0; i < helpMatrix.length; i++) {
                for (int j = 0; j < helpMatrix[i].length; j++) {
                    if(helpMatrix[i][j].equals("B")) {
                        matrix[i][j] ="B";
                    }
                }
            }

            k++;
        }
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        if(playerWin){
            System.out.printf("won: %d %d",lasIndex1,lasIndex2);
        }else {
            System.out.printf("dead: %d %d",lasIndex1,lasIndex2);
        }

    }
}
