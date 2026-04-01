import java.util.Set;
import java.util.LinkedHashSet;

public class TrainConsistUC5 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n--- UC5: Preserve Insertion Order (LinkedHashSet) ---");

        // 1. Create a LinkedHashSet<String> to represent the train formation
        // This guarantees uniqueness AND keeps the exact order we attach them
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attach bogies: Engine, Sleeper, Cargo, Guard
        System.out.println("Attaching: Engine");
        trainFormation.add("Engine");

        System.out.println("Attaching: Sleeper");
        trainFormation.add("Sleeper");

        System.out.println("Attaching: Cargo");
        trainFormation.add("Cargo");

        System.out.println("Attaching: Guard");
        trainFormation.add("Guard");

        // 3. Attempt to attach a duplicate bogie intentionally
        System.out.println("\nAttempting to attach duplicate: Sleeper");
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println(" -> ERROR: 'Sleeper' is already in the formation. Duplicate ignored.");
        }

        // 4. Display the final formation order
        // Notice that the order is perfectly preserved, unlike the regular HashSet in UC3!
        System.out.println("\nFinal train formation: " + trainFormation);

        System.out.println("\nProgram continues...");
    }
}