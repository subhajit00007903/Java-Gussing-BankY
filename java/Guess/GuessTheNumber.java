import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int number = random.nextInt(100) + 1;
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Guess a number between 1 and 100: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < number) {
                System.out.println("Higher! This was attempt number " + attempts + ".");
            } else if (guess > number) {
                System.out.println("Lower! This was attempt number " + attempts + ".");
            } else {
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                break;
            }
        }

        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Sorry, you didn't guess the number within " + MAX_ATTEMPTS + " attempts. The number was: " + number);
        }

        scanner.close();
    }
}
