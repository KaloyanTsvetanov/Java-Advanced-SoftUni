package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(a -> a.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        Person p = null;
        p = roster.stream().filter(a -> a.getName().equals(name) && a.getHometown().equals(hometown)).findAny().orElse(null);
        return p;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The people in the hotel ").append(name).append(" are:").append("\n");
        for (Person datum : roster) {
            sb.append(datum).append("\n");
        }
        return sb.toString();
    }
}
