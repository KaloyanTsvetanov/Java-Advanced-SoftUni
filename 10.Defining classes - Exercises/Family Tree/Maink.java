import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        List<Action> actionList = new ArrayList<>();
        Map<String, String> personMap = new LinkedHashMap<>();
        Set<String> parentSet = new LinkedHashSet<>();
        Set<String> childSet = new LinkedHashSet<>();

        String firstInput = "";

        String[] input1 = scanner.nextLine().split("\\s+");
        if (input1.length == 1) {
            person.setDate(input1[0]);
            person.setName("");
            firstInput = input1[0];
        } else {
            person.setName(input1[0] + " " + input1[1]);
            person.setDate("");
            firstInput = input1[0] + " " + input1[1];
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            if (tokens.length == 5) {
                String parentName = tokens[0] + " " + tokens[1];
                String childName = tokens[3] + " " + tokens[4];
                Action action = new Action(parentName,childName);
                actionList.add(action);


            } else if (tokens.length == 4) {
                if (tokens[1].equals("-")) {
                    String parentDate = tokens[0];
                    String childName = tokens[2] + " " + tokens[3];
                    Action action = new Action(parentDate,childName);
                    actionList.add(action);

                } else {
                    String parentName = tokens[0] + " " + tokens[1];
                    String childDate = tokens[3];
                    Action action = new Action(parentName,childDate);
                    actionList.add(action);

                }
            } else if (tokens.length == 3) {
                if (tokens[1].equals("-")) {
                    String parentDate = tokens[0];
                    String childDate = tokens[2];
                    Action action = new Action(parentDate,childDate);
                    actionList.add(action);

                } else {
                    String personName = tokens[0] + " " + tokens[1];
                    String personDate = tokens[2];
                    personMap.putIfAbsent(personName, personDate);
                }
            }

            input = scanner.nextLine();
        }
        for (var a : personMap.entrySet()) {
            if (a.getKey().equals(firstInput)) {
                person.setDate(a.getValue());
                break;
            }else if(a.getValue().equals(firstInput)){
                person.setName(a.getKey());
                break;
            }
        }

        for(var a: actionList){
            if(a.getFirst().equals(person.getName()) || a.getFirst().equals(person.getDate())){
                childSet.add(a.getSecond());
            }else if(a.getSecond().equals(person.getName()) || a.getSecond().equals(person.getDate())){
                parentSet.add(a.getFirst());
            }
        }

        for (var a : personMap.entrySet()){
            if(parentSet.contains(a.getKey())){
                Parent parent = new Parent();
                parent.setName(a.getKey());
                parent.setDate(a.getValue());
                person.getParentList().add(parent);
            }
            if(childSet.contains(a.getKey())){
                Child child = new Child();
                child.setName(a.getKey());
                child.setDate(a.getValue());
                person.getChildList().add(child);
            }
            if(parentSet.contains(a.getValue())) {
                Parent parent = new Parent();
                parent.setName(a.getKey());
                parent.setDate(a.getValue());
                person.getParentList().add(parent);
            }
            if(childSet.contains(a.getValue())){
                Child child = new Child();
                child.setName(a.getKey());
                child.setDate(a.getValue());
                person.getChildList().add(child);
            }
        }

        System.out.println(person);

    }
}