import java.util.List;
import java.util.ArrayList;

public class TrainConsistManagementApp {

    // Inner class representing a Bogie for the collection
    public static class Bogie {
        // Future properties and methods will go here
    }

    public static void main(String[] args) {
        // 1. Print the welcome message
        System.out.println("=== Train Consist Management App ===");

        // 2. Initialize the train consist using a List interface and ArrayList implementation
        // This dynamic collection allows bogies to be added or removed at runtime.
        List<Bogie> trainConsist = new ArrayList<>();

        // 3. Display the initial state of the train
        System.out.println("Train consist initialized successfully.");

        // 4. Display the initial bogie count using the size() method
        System.out.println("Initial bogie count: " + trainConsist.size());

        // Program continues...
    }
}