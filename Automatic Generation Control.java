import java.util.Scanner;

public class AutomaticGenerationControl {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Automatic Generation Control (AGC) ===");

        System.out.print("Enter Load Demand (MW): ");
        double loadDemand = sc.nextDouble();

        System.out.print("Enter Initial Generation (MW): ");
        double generation = sc.nextDouble();

        System.out.print("Enter Maximum Generator Capacity (MW): ");
        double maxGeneration = sc.nextDouble();

        // Calculate initial power error
        double powerError = loadDemand - generation;

        System.out.println("\nInitial Generation : " + generation + " MW");
        System.out.println("Load Demand        : " + loadDemand + " MW");
        System.out.println("Power Error        : " + powerError + " MW");

        // Automatic Generation Control
        if (powerError > 0) {

            System.out.println("\nLoad is greater than generation.");
            System.out.println("Increasing generator output...");

            generation = generation + powerError;

            if (generation > maxGeneration) {
                generation = maxGeneration;
            }

        } else if (powerError < 0) {

            System.out.println("\nGeneration is greater than load.");
            System.out.println("Reducing generator output...");

            generation = generation + powerError;

            if (generation < 0) {
                generation = 0;
            }

        } else {

            System.out.println("\nGeneration and load are balanced.");
        }

        // Final error
        double finalError = loadDemand - generation;

        System.out.println("\n--- AGC Result ---");
        System.out.printf("Final Generation : %.2f MW%n", generation);
        System.out.printf("Load Demand      : %.2f MW%n", loadDemand);
        System.out.printf("Final Error       : %.2f MW%n", finalError);

        if (Math.abs(finalError) < 0.01) {
            System.out.println("System Status     : BALANCED");
        } else {
            System.out.println("System Status     : GENERATION LIMIT REACHED");
        }

        sc.close();
    }
}
