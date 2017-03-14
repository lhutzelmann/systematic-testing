package org.hutzelmann.javakurs.sut;

import java.util.Random;
import java.util.Scanner;

/**
 * PLEASE, DON'T CHEAT BY VIEWING THE SOURCE CODE!
 */
















































































































public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }

    public void setNumberToGuess(int numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    private State state;
    private int numberToGuess;
    private Random generator = new Random();

    public Application() {
        state = State.START;
    }

    public void run() {
        String value = null;
        while (!State.END.equals(state)) {
            switch (state) {
                case START:
                    startNewRound();
                    break;
                case NEW_ROUND:
                    chooseNumberToGuess();
                    break;
                case PLAY:
                    value = guess();
                    break;
                case RESULT:
                    evaluateGuess(value);
                    break;
                case WIN:
                    congratulate();
                    break;
                case REPEAT:
                    askForRepetition();
                    break;
            }
        }
    }

    public void startNewRound() {
        System.out.println("Welcome to the number guess game");
        state = State.NEW_ROUND;
    }

    public void chooseNumberToGuess() {
        numberToGuess = generator.nextInt(10) + 1;
        System.out.println("Ok, I have chosen my number between 1 and 10.");
        state = State.PLAY;
    }

    public String guess() {
        System.out.println("Make your guess: ");
        String guess = scanner.next();
        state = State.RESULT;
        return guess;
    }

    public void evaluateGuess(String input) {
        System.out.println("Evaluating your guess...");
        int guessedNumber = Integer.parseInt(input);
//        if (guessedNumber < 1 || guessedNumber > 10){
        if (guessedNumber < 0 || guessedNumber > 10) {
            System.out.println("Your number must between 1 and 10");
            state = State.PLAY;
        } else if (guessedNumber < numberToGuess) {
            System.out.println("Your number is too low...");
            state = State.PLAY;
        } else if (guessedNumber > numberToGuess) {
            System.out.println("Your number is too high...");
            state = State.PLAY;
        } else {
            System.out.println();
            state = State.WIN;
        }
    }

    public void congratulate() {
        System.out.println("Well, you guessed my number " + Integer.toString(numberToGuess));
        state = State.REPEAT;
    }

    public void askForRepetition() {
        System.out.println("Do you want to play again [y/n]? ");
        String answer = scanner.next();
        if (answer.equals("n")){
            state = state.END;
        } else {
            state = State.NEW_ROUND;
        }
    }
}
