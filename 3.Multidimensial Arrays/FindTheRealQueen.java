import java.util.*;

public class FindTheRealQueen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[][] chessBoard = new String[8][8];

        for (int i = 0; i < 8; i++) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            chessBoard[i] = arr;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int counter = 0;
                if (chessBoard[i][j].equals("q")) {
                    int rowIndex = i;
                    int min = Math.min(i, j);
                    int max = Math.max(i, j);
                    int colIndex = j;
                    for (int k = 0; k < 8; k++) {
                        if (chessBoard[i][k].equals("q")) {
                            counter++;

                        }
                    }
                    if(counter>2){
                        break;
                    }
                    for (int k = 0; k < 8; k++) {
                        if (chessBoard[k][j].equals("q")) {
                            counter++;

                        }
                    }
                    if(counter>2){
                        break;
                    }
                    if(max<7) {
                        for (int k = 1; k < 8 - max; k++) {
                            if (chessBoard[rowIndex + k][colIndex + k].equals("q")) {
                                counter++;
                            }
                            if(counter>2){
                                break;
                            }

                        }
                    }
                    if(counter>2){
                        break;
                    }
                    if(min>=1 ) {
                        if(i>4 && j >4){
                            min=8-max;
                        }
                        for (int k = 1; k < min; k++) {
                            if (chessBoard[rowIndex - k][colIndex + k].equals("q")) {
                                counter++;
                            }
                            if(counter>2){
                                break;
                            }

                        }
                        if(counter>2){
                            break;
                        }
                    }
                    if(min>=1) {
                        if(i>4 && j >4){
                            min=8-max;
                        }
                        for (int k = 1; k < min; k++) {
                            if (chessBoard[rowIndex + k][colIndex - k].equals("q")) {
                                counter++;
                            }
                            if(counter>2){
                                break;
                            }

                        }
                        if(counter>2){
                            break;
                        }
                    }
                    if(min!=0) {
                        for (int k = 1; k <= min; k++) {
                            if (chessBoard[rowIndex - k][colIndex - k].equals("q")) {
                                counter++;
                            }
                            if(counter>2){
                                break;
                            }

                        }
                    }
                    if(counter==2){
                        System.out.println(i+" "+ j);
                    }
                }
            }
        }
    }
}
