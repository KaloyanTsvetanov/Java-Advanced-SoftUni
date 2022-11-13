package christmas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bag bag = new Bag("black", 10);
        Present present = new Present("Doll", 0.4, "girl");
        System.out.println(present);
        bag.add(present);
        bag.remove("Toy");
        Present secondPresent = new Present("Train", 2, "boy");
        bag.add(secondPresent);
        Present heaviest = bag.heaviestPresent();
        System.out.println(heaviest);
        Present p = bag.getPresent("Doll");
        System.out.println(p);
        System.out.println(bag.count());
        System.out.println(bag.report());
        System.out.println(bag.getCapacity());

    }
}
