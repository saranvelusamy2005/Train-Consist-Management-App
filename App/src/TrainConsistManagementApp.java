import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Display
    public String toString() {
        return name + " - Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // ---------- UC7: Create & Sort Bogies ----------
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Sleeper", 80)); // duplicate for grouping demo

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Sort using Comparator
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting (by Capacity):");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // ---------- UC8: Filter using Streams ----------
        System.out.println("\nUC8: Filter bogies with capacity > 60");

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the condition.");
        } else {
            for (Bogie b : filteredBogies) {
                System.out.println(b);
            }
        }

        // ---------- UC9: Group Bogies by Type ----------
        System.out.println("\nUC9: Group bogies by type");

        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Bogie b : entry.getValue()) {
                System.out.println("  " + b);
            }
        }
    }
}