import java.util.List;
import java.util.ArrayList;

public class TrainConsistUC2 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n--- UC2: Passenger Bogie Management ---");

        // 1. Create an ArrayList<String> for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // 2. Add bogies: Sleeper, AC Chair, First Class
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // 3. Print the list after insertion
        System.out.println("Passenger bogies added: " + passengerBogies);

        // 4. Remove one bogie (for example, AC Chair)
        passengerBogies.remove("AC Chair");
        System.out.println("Bogie 'AC Chair' has been detached.");

        // 5. Use contains() to check if Sleeper exists
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Checking for Sleeper bogie... Exists: " + hasSleeper);

        // 6. Print final list state
        System.out.println("Final train consist: " + passengerBogies);

        System.out.println("\nProgram continues...");
    }
}