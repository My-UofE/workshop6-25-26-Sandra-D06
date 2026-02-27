import java.util.Scanner;
import java.util.Random;

/**
 * Enum that represents the three possible hand signs in Rock, Paper, Scissors
 */
enum HandSign {
    ROCK, 
    PAPER,
    SCISSORS 
}

public class RPSApp {
    /**
     * Get the computer’s move (randomly generated)
     * @return a HandSign value chosen randomly from ROACK, PAPER or SCISSORS
     */
    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        
        HandSign computerMove = null; 

        if (n == 0) {
            computerMove = HandSign.ROCK;
        } else if (n == 1) {
            computerMove = HandSign.PAPER;
        } else {
            computerMove = HandSign.SCISSORS;
        }

        // code using n to select
        // a HandSign

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     * @return the player's chosen HandSign or null if the player chooses to quit the game
     */
    public static HandSign getPlayerMove(){
        Scanner in = new Scanner(System.in);
        boolean validInput = true;
        HandSign playerHandSign = null;

        do {
            System.out.println("Enter your more: (r)ock, (p)aper, (s)cissors, or (q)uit");

            char inChar = in.next().toLowerCase().charAt(0);

            switch(inChar) {
                case 'r':
                    System.out.println("You chose ROCK");
                    playerHandSign = HandSign.ROCK;
                    validInput = true;
                    break;

                case 'p':
                    System.out.println("You chose PAPER");
                    playerHandSign = HandSign.PAPER;
                    validInput = true;
                    break;

                case 's':
                    System.out.println("You chose SCISSORS");
                    playerHandSign = HandSign.SCISSORS;
                    validInput = true;
                    break;

                case 'q':
                    System.out.println("You chose to quit.");
                    return null;

                default:
                    System.out.println("Invalid input. Try again.");
                    validInput = false;
            }

            // switch-statement goes here

        } while(!validInput);
        
        return playerHandSign;
    }

    /**
     * Check who wins
     */
    public static int whoWins(HandSign h1, HandSign h2){
         // your code goes here

        if (h1 == h2) return 0;

        if (h1 == HandSign.ROCK && h2 == HandSign.SCISSORS) return 1;
        if (h1 == HandSign.PAPER && h2 == HandSign.ROCK) return 1;
        if (h1 == HandSign.SCISSORS && h2 == HandSign.PAPER) return 1;

        return -1;

    }
    
    /**
     * The main method.
     * Runs the Rock, Paper, Scissors game loop.
     * Continues until the player chooses to quit
     */
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;

        HandSign playerMove;
        HandSign computerMove;

        int checkwin;
        boolean gameOver = false;

        while (!gameOver){
            //Step1: Get the player move
            playerMove = getPlayerMove();
            if (playerMove == null) {   // user typed q
                gameOver = true;
                continue;
            }

            //Step2: Get the computer’s move
            computerMove = getComputerMove();

            //Step3: Check who wins
            checkwin = whoWins(playerMove, computerMove);

            //Step4: Output who played what and who won
            System.out.println("Player played: " + playerMove);
            System.out.println("Computer played: " + computerMove);

            if (checkwin == 0) {
                System.out.println("It's a draw!");
            } else if (checkwin == 1) {
                System.out.println("Player wins this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }

          
              //Step5: Update and print scores
              System.out.println("Score → Player: " + playerScore + " | Computer: " + computerScore);
            System.out.println();

        }
    }
}