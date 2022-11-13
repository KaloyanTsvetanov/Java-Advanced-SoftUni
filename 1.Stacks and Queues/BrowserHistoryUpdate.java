import java.util.*;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> back = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String input = scanner.nextLine();
        String currentPage = "blank";
        while (!input.equals("Home")){

            if(input.equals("forward")){
                if(forward.isEmpty()){
                    System.out.println("no next URLs");
                    input=scanner.nextLine();
                    continue;
                }else {
                    back.push(currentPage);
                    currentPage=forward.pop();

                }


            }else if(input.equals("back")){
                if(!back.isEmpty()){
                    forward.push(currentPage);
                    currentPage = back.pop();

                }else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }

            }else {
                if(!currentPage.equals("blank")){
                    back.push(currentPage);
                    if(!forward.isEmpty()){
                        forward.clear();
                    }
                }
                currentPage=input;
            }
            System.out.println(currentPage);

            input=scanner.nextLine();
        }
    }
}
