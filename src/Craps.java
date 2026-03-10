import java.util.Random;
import java.util.Scanner;
public class Craps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Craps Simulator!");

        while (playAgain) {
            System.out.println("\n--- New Game ---");

            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Crapped out! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Won with a natural!");
            } else {

	            System.out.println("The point is now: " + sum);

                boolean pointResolved = false;

                while (!pointResolved) {

                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    int newSum = die1 + die2;

                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + newSum);

                    if (newSum == sum) {
                        System.out.println("Made point and won.");
                        pointResolved = true; // End the current game loop
                    } else if (newSum == 7) {
                        System.out.println("Got a seven and lost.");
                        pointResolved = true; // End the current game loop
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }
            System.out.print("\nDo you want to play again? (y/n): ");
            String response = scanner.nextLine();

            if (!response.equalsIgnoreCase("y")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }
    }
}