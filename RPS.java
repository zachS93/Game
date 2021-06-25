package rock_paper_scissor;

import java.util.Scanner;

enum Game {
    ROCK,
    PAPER,
    SCISSOR
}
public class RPS {
    public static void main(String[] args) {

        int gameRound = 0; // counts the number of rounds for the total game
        int userScore = 0; // keeps track of number of rounds user wins
        int pcScore = 0; // keeps track of number of rounds computer wins

        int winner = 0; // keeps track of the final winner

        System.out.printf("Welcome to --- ROCK PAPER SCISSOR --- %nFirst to 5 wins\n");
        System.out.println();

        while ( userScore != 5 && pcScore != 5 ) {
            System.out.println("Ok give me a number => 1-3");
            System.out.printf("1 => ROCK%n2 => PAPER%n3 => SCISSOR%n");
            printRound(gameRound);

            Scanner scan = new Scanner(System.in);
            int userInput = 0; // getting user input

             //* modified 06.23.2021 ZS

            Game pcPick = null; // holds the enum value the computer chooses
            Game userPick = null; // holds the enum value the user chooses
            if ( scan.hasNextInt() ) {
                 userInput = scan.nextInt();
                 boolean validate = checkNumberValidation(userInput);
                 if ( validate ) {
                     int computerInput = (int)( Math.random() * 3 ) + 1;
                     pcPick = getPick(computerInput);
                     userPick = getPick(userInput);
                     winner = findTheWinner(pcPick, userPick);

                 } else {
                     System.out.println("You've entered an amount that is out" +
                                    " of range");
                     System.out.println("-----------------------------------------");
                     continue;
                 }
             } else {
                 System.out.println("Only integers please");
                 continue;
             }
            if ( winner == 5 ) {
                System.out.println("Player chose " + userPick + " --- || --- Computer chose " + pcPick);
                System.out.println("It's a tie");
            } else if ( winner == 1 ) {
                System.out.println("Player chose " + userPick + " --- || --- Computer chose " + pcPick);
                System.out.println("Congratulations!!! ... You've won this round");
                userScore++;
            } else {
                System.out.println("Player chose " + userPick + " --- || --- Computer chose " + pcPick);
                System.out.println("Sorry ... You've lost this round");
                pcScore++;
            }
            declareWinner(userScore, pcScore);
            System.out.println("==============================================");
            System.out.println("**********************************************");
            System.out.println("==============================================");
            gameRound++;
        }
        System.out.println("It took " + gameRound + " rounds to determine the winner");
    }
    private static void printRound( int gRound ) {
        if ( gRound == 0 ) {
            return;
        } else {
            System.out.println("==============================================");
            System.out.println("**********************************************");
            System.out.println("==============================================");
        }
    }
    private static void declareWinner(int uScore, int pScore) {
        if ( uScore == 5 ) {
            System.out.println("Player has won the game!!!");
        } else if ( pScore == 5 ) {
            System.out.println("Computer has won the game ):");
        } else {
            System.out.println("Player score " + uScore + " --- || --- Computer score " + pScore);
        }
    }
    private static int findTheWinner(Game pcPick, Game uPick) {
        if ( pcPick == uPick ) {
            return 5;
        } else if ( pcPick == pcPick.ROCK ) {
            if ( uPick == uPick.PAPER ) {
                return 1;
            } else {
                return 0;
            }
        } else if ( pcPick == pcPick.PAPER ) {
            if ( uPick == uPick.ROCK ) {
                return 0;
            } else {
                return 1;
            }
        } else if ( pcPick == pcPick.SCISSOR ) {
            if ( uPick == uPick.ROCK ) {
                return 1;
            } else {
                return 0;
            }
        } else {
            System.out.println("There is an error in my logic" +
                    " so I am throwing a -1");
            return -1;
        }
    }
    private static Game getPick(int input) {
        Game playerInput = null;
        switch ( input ) {
            case 1 :
                playerInput = Game.ROCK;
                break;
            case 2 :
                playerInput = Game.PAPER;
                break;
            case 3 :
                playerInput = Game.SCISSOR;
                break;
            default:
                System.out.println("This line should never " +
                        "execute unless there is an error in my logic");
                break;
        }
        return playerInput;
    }
    private static boolean checkNumberValidation(int uInput) {
        if ( uInput > 0 && uInput <= 3 ) {
            return true;
        } else {
            return false;
        }
    }
}
