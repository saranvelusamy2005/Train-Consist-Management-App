import java.util.LinkedList;

public class TrainConsistUC4 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n--- UC4: Maintain Ordered Train Sequence ---");

        // 1. Create a LinkedList<String> for the consist to maintain physical order
        // We use LinkedList as the reference type to access specific methods like removeFirst()
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. Add initial bogies to the train
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial train formation: " + trainConsist);

        // 3. Insert a Pantry Car at position 2 (Index 2 is the 3rd spot)
        trainConsist.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at position 2: " + trainConsist);

        // 4. Remove the first and last bogie
        String removedFirst = trainConsist.removeFirst(); // Removes "Engine"
        String removedLast = trainConsist.removeLast();   // Removes "Guard"

        System.out.println("Detached front: " + removedFirst);
        System.out.println("Detached rear: " + removedLast);

        // 5. Display the final ordered train consist
        System.out.println("\nFinal ordered train consist: " + trainConsist);

        System.out.println("\nProgram continues...");
    }
}