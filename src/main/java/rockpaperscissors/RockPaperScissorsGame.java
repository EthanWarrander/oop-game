package rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissorsGame implements Game {
    RockPaperScissorsWords play;
    RockPaperScissorsWords userPlay;
    String userInput;
    int userScore = 0;
    int compScore = 0;
    boolean finished = false;
    Scanner scanner = new Scanner(System.in);
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";

    public void playGame() {
        while(!finished) {
            int randomNum = (int)(Math.random() * 3);
            if (randomNum == 0) play = RockPaperScissorsWords.ROCK;
            else if (randomNum == 1) play = RockPaperScissorsWords.PAPER;
            else if (randomNum == 2) play = RockPaperScissorsWords.SCISSORS;

            System.out.println("Enter rock, paper, or scissors: ");

            boolean validEntry = false;
            while (!validEntry) {
                userInput = scanner.nextLine();
                userInput = userInput.toUpperCase();
                userInput = userInput.trim();
                userPlay = RockPaperScissorsWords.valueOf(userInput);
                if (userPlay == RockPaperScissorsWords.ROCK || userPlay == RockPaperScissorsWords.SCISSORS || userPlay == RockPaperScissorsWords.PAPER) validEntry = true;
                else System.out.println("Invalid entry. Please enter a valid option: ");
            }

            if (play.equals(userPlay)) {
                System.out.println("Computer plays: " + play);
                System.out.println("Draw!");
            } else if ((play == RockPaperScissorsWords.ROCK && userPlay == RockPaperScissorsWords.SCISSORS) || (play == RockPaperScissorsWords.PAPER && userPlay == RockPaperScissorsWords.ROCK) || (play == RockPaperScissorsWords.SCISSORS && userPlay == RockPaperScissorsWords.PAPER)) {
                compScore++;
                System.out.println("Computer plays: " + play);
                System.out.println("Computer wins this round.");
            } else if ((userPlay == RockPaperScissorsWords.ROCK && play == RockPaperScissorsWords.SCISSORS) || (userPlay == RockPaperScissorsWords.PAPER && play == RockPaperScissorsWords.ROCK) || (userPlay == RockPaperScissorsWords.SCISSORS && play == RockPaperScissorsWords.PAPER)) {
                userScore++;
                System.out.println("Computer plays: " + play);
                System.out.println("You win this round.");
            }


            if (userScore >= 2) {
                System.out.println("You win! The final score was " + userScore + "-" + compScore + " to you!");
                finished = true;
            } else if (compScore >= 2) {
                System.out.println("The computer wins! The final score was " + compScore + "-" + userScore + " to the computer!");
                finished = true;
            } else System.out.println("Next round");
        }
    }
}
