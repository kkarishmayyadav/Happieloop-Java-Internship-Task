import java.util.Scanner;

public class WordGuessingGame {
    public static void main(String[] args) {
        String hiddenWord = "programming";
        Scanner scanner = new Scanner(System.in);
        boolean isGuessed = false;

        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Try to guess the hidden word.");

        while (!isGuessed) {
            System.out.print("Guess a word: ");
            String userGuess = scanner.next().toLowerCase(); // Convert the guess to lowercase

            if (userGuess.equals(hiddenWord)) {
                isGuessed = true;
                System.out.println("Congratulations! You guessed the correct word: " + hiddenWord);
            } else {
                System.out.println("Incorrect guess. Try again.");
            }
        }

        scanner.close();
    }
}

