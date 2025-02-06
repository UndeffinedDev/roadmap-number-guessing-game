package io.github.undeffineddev.ngg;

import java.util.Random;
import java.util.Scanner;

public class NGG {

    private static int chances = 0;
    private static boolean IS_PLAYING;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random;
    private static int attempts = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Please select the difficulty level:\n" +
                "1. Easy (10 chances)\n" +
                "2. Medium (5 chances)\n" +
                "3. Hard (3 chances)");

        int difficulty = scanner.nextInt();
        startGame(difficulty);
    }

    public static void startGame(int difficulty) {
        IS_PLAYING = true;
        attempts = 0;
        int randomNumber = 0;

        System.out.println("I'm thinking of a number between 1 and 10.");

        switch (difficulty) {
            case 1: // Easy
                chances = 10;
                break;
            case 2: // Medium
                chances = 5;
                break;
            case 3: // Hard
                chances = 3;
                break;
            default:
                System.out.println("Invalid difficulty selected. Exiting game.");
                return;
        }

        random = new Random();
        randomNumber = random.nextInt(100) + 1;

        System.out.println("You have selected " + (difficulty == 1 ? "Easy" : (difficulty == 2 ? "Medium" : "Hard")) + " difficulty.");
        System.out.println("You have " + chances + " chances. Let's start the game!");

        while (IS_PLAYING && chances > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            } else {
                chances--;
                if (chances > 0) {
                    System.out.println("Incorrect guess. You have " + chances + " chances left.");
                } else {
                    System.out.println("Sorry! You've run out of chances. The correct number was " + randomNumber + ".");
                }
            }
        }
        System.out.println("Game over! Would you like to play again? (yes/no)");

        String response = scanner.next();
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Please select the difficulty level again.");
            difficulty = scanner.nextInt();
            startGame(difficulty);
        } else {
            System.out.println("Thanks for playing!");
        }
    }
}
