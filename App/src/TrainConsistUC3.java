import java.util.Set;
import java.util.HashSet;

public class TrainConsistUC3 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n--- UC3: Track Unique Bogie IDs ---");

        // 1. Create a HashSet<String> for bogie IDs to enforce uniqueness
        Set<String> bogieIDs = new HashSet<>();

        // 2. Add values, including duplicates intentionally
        System.out.println("Registering Bogie ID: BG101");
        bogieIDs.add("BG101");

        System.out.println("Registering Bogie ID: BG102");
        bogieIDs.add("BG102");

        System.out.println("Attempting to register duplicate Bogie ID: BG101...");
        // The add() method returns false if the item is already in the Set
        boolean isAdded = bogieIDs.add("BG101");

        if (!isAdded) {
            System.out.println(" -> ERROR: Bogie BG101 is already registered! Duplicate ignored.");
        }

        System.out.println("Registering Bogie ID: BG103");
        bogieIDs.add("BG103");

        // 3. Print the final set (Observe that duplicates are handled automatically)
        System.out.println("\nFinal unique Bogie IDs in the train consist: " + bogieIDs);

        System.out.println("\nProgram continues...");
    }
}