import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<Integer> firstDeck = Arrays
                .stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        input = scanner.nextLine();
        Set<Integer> secondDeck = Arrays
                .stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 0;

        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()){
            rounds++;
            if(rounds==50){
                break;
            }

            Iterator<Integer> firstIterator = firstDeck.iterator();
            int firstCard = firstIterator.next();
            firstIterator.remove();

            Iterator<Integer> secondIterator = secondDeck.iterator();
            int secondCard = secondIterator.next();
            secondIterator.remove();

            if(firstCard>secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if(firstCard<secondCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }

        }

        if(firstDeck.size()> secondDeck.size()){
            System.out.println("First player win!");
        } else if(secondDeck.size()> firstDeck.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }

    }
}
