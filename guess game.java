import java.util.Random;
import java.util.Scanner;

public class ai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;
        int totalScore = 0;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attemptsLeft = 10; // Limit the number of attempts
            boolean guessedCorrectly = false;

            System.out.println("\nA number between 1 and 100 has been chosen. Try to guess it!");
            System.out.println("You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    totalScore += attemptsLeft; // Score based on remaining attempts
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attemptsLeft--;

                if (!guessedCorrectly && attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                } else if (attemptsLeft == 0) {
                    System.out.println("You're out of attempts! The correct number was: " + numberToGuess);
                }
            }

            System.out.println("Your current score: " + totalScore);

            System.out.print("Would you like to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nThank you for playing! Your total score: " + totalScore);
        System.out.println("Goodbye!");
        scanner.close();
    }
}  
