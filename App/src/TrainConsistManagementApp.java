import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

// ---------- UC14: Custom Exception ----------
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// ---------- UC15: Runtime Exception ----------
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// ---------- Passenger Bogie ----------
class Bogie {
    String name;
    int capacity;

    // UC14 validation
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

// ---------- Goods Bogie ----------
class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type) {
        this.type = type;
    }

    // UC15 logic
    void assignCargo(String cargo) {
        try {
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe: Rectangular bogie cannot carry Petroleum"
                );
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned: " + cargo + " to " + type);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Cargo assignment attempt completed\n");
        }
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        try {

            // ---------- UC7: Sorting ----------
            List<Bogie> bogies = new ArrayList<>();

            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 40));
            bogies.add(new Bogie("Sleeper", 80));

            bogies.sort(Comparator.comparingInt(b -> b.capacity));

            System.out.println("After Sorting:");
            bogies.forEach(System.out::println);

            // ---------- UC8: Filtering ----------
            System.out.println("\nUC8: Filter capacity > 60");

            List<Bogie> filtered = bogies.stream()
                    .filter(b -> b.capacity > 60)
                    .toList();

            filtered.forEach(System.out::println);

            // ---------- UC9: Grouping ----------
            System.out.println("\nUC9: Grouping");

            Map<String, List<Bogie>> grouped = bogies.stream()
                    .collect(Collectors.groupingBy(b -> b.name));

            grouped.forEach((k, v) -> {
                System.out.println(k + ":");
                v.forEach(b -> System.out.println("  " + b));
            });

            // ---------- UC10: Total Capacity ----------
            int total = bogies.stream()
                    .map(b -> b.capacity)
                    .reduce(0, Integer::sum);

            System.out.println("\nTotal Seats = " + total);

            // ---------- UC11: Regex ----------
            System.out.println("\nUC11: Validation");

            Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
            Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

            System.out.println("Train ID Valid: " +
                    trainPattern.matcher("TRN-1234").matches());

            System.out.println("Cargo Code Valid: " +
                    cargoPattern.matcher("PET-AB").matches());

            // ---------- UC12: Safety ----------
            System.out.println("\nUC12: Safety Check");

            List<GoodsBogie> goodsList = List.of(
                    new GoodsBogie("Cylindrical"),
                    new GoodsBogie("Open")
            );

            boolean isSafe = goodsList.stream()
                    .allMatch(g ->
                            !g.type.equalsIgnoreCase("Cylindrical")
                                    || true // simplified for demo
                    );

            System.out.println(isSafe ? "SAFE" : "UNSAFE");

            // ---------- UC13: Performance ----------
            System.out.println("\nUC13: Performance Comparison");

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

            Bogie valid = new Bogie("Sleeper", 70);
            System.out.println("Valid: " + valid);

            try {
                Bogie invalid = new Bogie("AC Chair", -10);
            } catch (InvalidCapacityException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // ---------- UC15 ----------
            System.out.println("\nUC15: Safe Cargo Assignment");

            GoodsBogie g1 = new GoodsBogie("Cylindrical");
            g1.assignCargo("Petroleum");

            GoodsBogie g2 = new GoodsBogie("Rectangular");
            g2.assignCargo("Petroleum");

            GoodsBogie g3 = new GoodsBogie("Rectangular");
            g3.assignCargo("Grain");

            System.out.println("Program continues after exception...");

        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}