import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer,BankAccount> bankAccountMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){

            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            String output = null;

            if(command.equals("Create")){
                BankAccount bankAccount = new BankAccount();
                bankAccountMap.put(bankAccount.getId(),bankAccount);
                output = "Account ID"+bankAccount.getId()+" created";
            }else if(command.equals("Deposit")){
                BankAccount bankAccount = bankAccountMap.get(Integer.parseInt(tokens[1]));
                if(bankAccount!=null) {
                    bankAccount.deposit(Integer.parseInt(tokens[2]));
                    output = "Deposited "+ Integer.parseInt(tokens[2])+" to ID"+Integer.parseInt(tokens[1]);
                }else {
                    System.out.println("Account does not exist");
                }


            }else if(command.equals("SetInterest")){
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
            }else{
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);
                BankAccount bankAccount = bankAccountMap.get(id);
                if(bankAccount!=null) {
                    output = String.format("%.2f", bankAccount.getInterest(years));
                }else {
                    System.out.println("Account does not exist");
                }
            }
            if(output!=null){
                System.out.println(output);
            }

            input=scanner.nextLine();
        }
    }
}