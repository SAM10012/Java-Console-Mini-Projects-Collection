import java.util.*;

/* Rock Paper Scissors Console Game (Java)
Objective:
Design and implement a console-based Java application that simulates
the classic Rock, Paper, Scissors game between a user and the computer.
The game should consist of multiple rounds, track scores, and declare a winner
based on performance across the rounds.*/

class SpellingException extends Exception {
    public SpellingException(String msg) {
        super(msg);
    }
}
/*class SameInputException extends Exception {
    public SameInputException(String message) {
        super(message);
    }
}*/


public class RockPaperScissorsGame {

    public static String check_winner(String move1, String move2) throws SpellingException {

        switch (move1) {

            case "rock":
                if (move2.equalsIgnoreCase("paper")) {
                    return "paper";
                }
                if (move2.equalsIgnoreCase("scissors")) {
                    return "rock";
                }
                break;

            case "paper":
                if (move2.equalsIgnoreCase("rock")) {
                    return "paper";
                }
                if (move2.equalsIgnoreCase("scissors")) {
                    return "scissors";
                }

                break;

            case "scissors":
                if (move2.equalsIgnoreCase("paper")) {
                    return "scissors";
                }
                if (move2.equalsIgnoreCase("rock")) {
                    return "rock";
                }

                break;

            default: {

                throw new SpellingException("Please enter from provided choices. Check spelling.");

            }

        }

        return "Tie";

    }

    public static String Game() throws SpellingException {
        int num_of_rounds = 3;
        Scanner sc = new Scanner(System.in);
        String user = new String();
        String comp = new String();
        Random random = new Random();
        String[] options = {"rock", "paper", "scissors"};
        String winner = new String();
        int user_score = 0;
        int comp_score = 0;


        for (int i = 0; i < num_of_rounds; i++) {
            System.out.println("\n--------------------- Starting Round " + (i + 1) + " --------------------");
            System.out.print("\nChoose Rock/Paper/Scissors: ");
            user = sc.nextLine().toLowerCase();

            comp = options[random.nextInt(options.length)];
            System.out.println("Computer chose: " + comp);
            winner = check_winner(user, comp);

            if (winner.equals(user)) {
                user_score = user_score + 1;
            } else if (winner.equals(comp)) {
                comp_score = comp_score + 1;
            } else if (winner.equalsIgnoreCase("Tie")) {
                System.out.println("Both you and computer chose same option! Repeating this round.");
                i = i - 1;
                //throw new SameInputException("Both you and computer chose same option! Start again please.");
            }

            System.out.println("Current Score: User | " + user_score + " Computer | " + comp_score);

        }

        System.out.println("\n==================== \uD83C\uDFC6 WINNER OF GAME \uD83C\uDFC6 =======================\n");
        if (user_score > comp_score) {
            return "You";
        }

        return "Computer";

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String flag = "N";

        System.out.println("\n================= \u270A \u270B \u270C\uFE0F Welcome to Rock Paper Scissors Game \u270A \u270B \u270C\uFE0F =========================");
        System.out.println("There will be 3 rounds between you and computer to determine the winner :)");


        while (true) {
            try {
                String winner = Game();
                System.out.println("The winner of this game is: " + winner + "!\nCongratulations to " + winner + ":)");

                System.out.println("Do you want to play again (Y/N)? ");
                flag = sc.nextLine();

                if (flag.equalsIgnoreCase("N")) {
                    break;
                } else if (flag.equalsIgnoreCase("Y")) {
                    continue;
                }

            } catch (SpellingException e) {
                System.out.println(e.getMessage());
            }

            /*catch (SameInputException e) {
                System.out.println(e.getMessage());
            }*/
        }


    }
}
