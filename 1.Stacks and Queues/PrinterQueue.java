import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!input.equals("print")){

            if(input.equals("cancel")){
                if(queue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.printf("Canceled %s%n",queue.poll());
                }

            }else {
                queue.offer(input);
            }
            input=scanner.nextLine();
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
