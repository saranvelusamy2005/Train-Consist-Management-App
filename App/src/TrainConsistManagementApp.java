import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String toString() {
        return name + " - Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // ---------- UC7: Sorting ----------
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Sleeper", 80)); // for grouping + sum

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting (by Capacity):");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // ---------- UC8: Filtering ----------
        System.out.println("\nUC8: Filter bogies with capacity > 60");

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        for (Bogie b : filtered) {
            System.out.println(b);
        }

        // ---------- UC9: Grouping ----------
        System.out.println("\nUC9: Group bogies by type");

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        for (String key : grouped.keySet()) {
            System.out.println(key + ":");
            for (Bogie b : grouped.get(key)) {
                System.out.println("  " + b);
            }
        }

        // ---------- UC10: Total Capacity ----------
        System.out.println("\nUC10: Total seating capacity");

        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seats = " + totalCapacity);
    }
}