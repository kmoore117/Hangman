import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    static Scanner input;

    public static void hangman() {
        input = new Scanner(System.in);
        String[] animals = {"bear", "cat", "dolphin", "sheep"};
        System.out.println("Welcome to our Hangman Game!");
        Random obj = new Random();
        int RandNum = obj.nextInt(5);
        String word = (animals[RandNum]);
        word = word.toUpperCase();
        String firstWord = word.replaceAll("[A-Z]", "_ ");
        System.out.println("Let's play:");
        startGame(word, firstWord);
    }

    public static void startGame(String word, String firstWord) {
        int guess = 0;
        int wrong = 0;
        String eachGuess;
        char letter;
        boolean alreadyGuessed;
        String guesses = "";
        boolean guessInWord;
        while (wrong < 5 && firstWord.contains("_")) {
            System.out.println(firstWord + "\n");
            int temp = 5 - wrong;
            if (wrong != 0) {
                System.out.println("You have " + temp + " guesses left.");
            }
            System.out.print("Your Guess: ");
            eachGuess = input.nextLine();
            eachGuess = eachGuess.toUpperCase();
            letter = eachGuess.charAt(0);
            alreadyGuessed = (guesses.indexOf(letter)) != -1;
            guesses += letter;
            letter = Character.toUpperCase(letter);
            System.out.println();
            if (alreadyGuessed == true) {
                System.out.println("You already guessed " + letter + ". \n");
            }
            guessInWord = (word.indexOf(letter)) != -1;
            if (guessInWord == true) {
                System.out.println(letter + " is present in the word.\n");
                for (int position = 0; position < word.length(); position++) {
                    if (word.charAt(position) == letter && firstWord.charAt(position) != letter) {
                        firstWord = firstWord.replaceAll("_ ", "_");
                        String secondWord;
                        secondWord = firstWord.substring(0, position) + letter + firstWord.substring(position + 1);
                        secondWord = secondWord.replaceAll("_", "_ ");
                        firstWord = secondWord;
                    }
                }
            } else {
                System.out.println(letter + " is not present in the word.");
                wrong++;
            }
            guess++;
        }
        if (wrong == 5) {
            System.out.println("You lost!");
        } else {
            System.out.print("The word is: " + firstWord + "\nYou did it!");
        }
    }

    public static void main(String[] args) {
        hangman();
    }
}
