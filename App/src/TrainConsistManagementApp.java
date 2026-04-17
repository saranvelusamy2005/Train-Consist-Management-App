import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

// ✅ Custom Exception (UC14)
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie
class Bogie {
    String name;
    int capacity;

    // Constructor with validation (UC14)
    Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String toString() {
        return name + " - Capacity: " + capacity;
    }
}

// Goods Bogie (UC12)
class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        try {

            // ---------- UC7 ----------
            List<Bogie> bogies = new ArrayList<>();

            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 40));
            bogies.add(new Bogie("Sleeper", 80));

            // Sort
            bogies.sort(Comparator.comparingInt(b -> b.capacity));

            System.out.println("After Sorting:");
            bogies.forEach(System.out::println);

            // ---------- UC8 ----------
            System.out.println("\nUC8: Filter capacity > 60");

            List<Bogie> filtered = bogies.stream()
                    .filter(b -> b.capacity > 60)
                    .toList();

            filtered.forEach(System.out::println);

            // ---------- UC9 ----------
            System.out.println("\nUC9: Grouping");

            Map<String, List<Bogie>> grouped = bogies.stream()
                    .collect(Collectors.groupingBy(b -> b.name));

            grouped.forEach((k, v) -> {
                System.out.println(k + ":");
                v.forEach(b -> System.out.println("  " + b));
            });

            // ---------- UC10 ----------
            int total = bogies.stream()
                    .map(b -> b.capacity)
                    .reduce(0, Integer::sum);

            System.out.println("\nTotal Seats = " + total);

            // ---------- UC11 ----------
            Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
            Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

            System.out.println("\nUC11 Validation:");
            System.out.println(trainPattern.matcher("TRN-1234").matches());
            System.out.println(cargoPattern.matcher("PET-AB").matches());

            // ---------- UC12 ----------
            System.out.println("\nUC12 Safety Check");

            List<GoodsBogie> goodsList = List.of(
                    new GoodsBogie("Cylindrical", "Petroleum"),
                    new GoodsBogie("Open", "Coal")
            );

            boolean isSafe = goodsList.stream()
                    .allMatch(g ->
                            !g.type.equalsIgnoreCase("Cylindrical")
                                    || g.cargo.equalsIgnoreCase("Petroleum")
                    );

            System.out.println(isSafe ? "SAFE" : "UNSAFE");

            // ---------- UC13 ----------
            System.out.println("\nUC13 Performance");

            List<Bogie> bigList = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                bigList.add(new Bogie("Sleeper", 50 + (i % 50)));
            }

            long startLoop = System.nanoTime();
            List<Bogie> loopResult = new ArrayList<>();
            for (Bogie b : bigList) {
                if (b.capacity > 60) loopResult.add(b);
            }
            long endLoop = System.nanoTime();

            long startStream = System.nanoTime();
            List<Bogie> streamResult = bigList.stream()
                    .filter(b -> b.capacity > 60)
                    .toList();
            long endStream = System.nanoTime();

            System.out.println("Loop Time: " + (endLoop - startLoop));
            System.out.println("Stream Time: " + (endStream - startStream));

            // ---------- UC14 ----------
            System.out.println("\nUC14: Exception Handling");

            // VALID
            Bogie valid = new Bogie("Sleeper", 70);
            System.out.println("Valid Bogie Created: " + valid);

            // INVALID
            Bogie invalid = new Bogie("AC Chair", -10); // will throw exception

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}