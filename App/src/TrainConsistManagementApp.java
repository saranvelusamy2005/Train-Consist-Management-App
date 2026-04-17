import java.util.Stack;

public class TrainConsistUC6 {
    public static void main(String[] args) {

        // Create Stack for train consist
        Stack<String> trainStack = new Stack<>();

        System.out.println("Attaching bogies...\n");

        // Push bogies (attach)
        trainStack.push("Engine");
        trainStack.push("Sleeper");
        trainStack.push("AC Chair");
        trainStack.push("Cargo");
        trainStack.push("Guard");

        System.out.println("Current Train Formation: " + trainStack);

        // Remove last attached bogie (LIFO)
        System.out.println("\nEmergency removal (Last attached bogie):");
        String removedBogie = trainStack.pop();
        System.out.println("Removed: " + removedBogie);

        // Show updated formation
        System.out.println("\nUpdated Train Formation: " + trainStack);

        // Peek last bogie
        System.out.println("\nCurrent Last Bogie: " + trainStack.peek());
    }
}