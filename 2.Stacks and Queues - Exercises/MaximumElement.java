import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n>0){
            String input = scanner.nextLine();
            if(input.split(" ")[0].equals("1")){
                int num = Integer.parseInt(input.split(" ")[1]);
                stack.push(num);
            }else if(input.split(" ")[0].equals("2")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(input.split(" ")[0].equals("3")){
                if(!stack.isEmpty()){
                    int max = Integer.MIN_VALUE;
                    for(int p : stack){
                        if(p>max){
                            max=p;
                        }
                    }
                    System.out.println(max);
                }
            }
            n--;
        }
    }
}
