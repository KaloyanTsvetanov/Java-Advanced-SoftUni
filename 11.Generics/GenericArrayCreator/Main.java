import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = ArrayCreator.create(13, 69);
        Integer[] arr2 = ArrayCreator.create(Integer.class, 13, 13);

        for (var i : arr2) {
            System.out.println(i);
        }
    }
}