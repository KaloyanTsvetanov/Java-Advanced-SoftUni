import java.util.*;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> uRL = new ArrayDeque<>();
        String input = scanner.nextLine();

        String currentPage = "";

        while (!input.equals("Home")) {

            if(input.equals("back")){

                if(!uRL.isEmpty()){
                    currentPage = uRL.pop();
                }else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }

            }else {
                if(!currentPage.equals("")) {
                    uRL.push(currentPage);
                }
                currentPage = input;
            }
            System.out.println(currentPage);
            input = scanner.nextLine();
        }
    }
}
