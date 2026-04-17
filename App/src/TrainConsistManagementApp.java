import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

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

// New class for UC12
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

        // ---------- UC7 ----------
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Sleeper", 80));

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // ---------- UC8 ----------
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        // ---------- UC9 ----------
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // ---------- UC10 ----------
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seats = " + total);

        // ---------- UC11 ----------
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        System.out.println("Train ID Valid: " + trainPattern.matcher(trainId).matches());
        System.out.println("Cargo Code Valid: " + cargoPattern.matcher(cargoCode).matches());

        // ---------- UC12: Safety Check ----------
        System.out.println("\nUC12: Safety Compliance Check");

        List<GoodsBogie> goodsList = new ArrayList<>();

        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Open", "Coal"));
        goodsList.add(new GoodsBogie("Box", "Grain"));

        // Safety rule using allMatch
        boolean isSafe = goodsList.stream()
                .allMatch(g ->
                        !g.type.equalsIgnoreCase("Cylindrical")
                                || g.cargo.equalsIgnoreCase("Petroleum")
                );

        if (isSafe) {
            System.out.println("Train is SAFE");
        } else {
            System.out.println("Train is UNSAFE");
        }
    }
}