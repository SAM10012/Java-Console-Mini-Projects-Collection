import java.util.*;

public class HangmanGame {

    public static StringBuilder build_word(String word, String guess, StringBuilder new_word) {

        // Update the word with the correctly guessed letter Like I/p -> banana,n,______ will become O/p ->  __n_n_
        if (word.indexOf(guess.charAt(0)) != -1) {
            for (int i = 0; i < word.length(); i++) {
                if (guess.charAt(0) == word.charAt(i)) {
                    new_word.setCharAt(i, guess.charAt(0));
                }
            }

        }
        return new_word;
    }


    public static void hangmanGame() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        String[] list = {"banana", "mango", "Paris", "France", "India"};
        Random random = new Random();
        String word = list[random.nextInt(list.length)].toLowerCase();
        System.out.println("\nWord has been selected! Let's start the game :)");
        Set<String> guessed = new HashSet<>();

        StringBuilder word_so_far = new StringBuilder();
        System.out.print("Guess the " + word.length() + " letter word: ");

        for (Character c : word.toCharArray()) {
            word_so_far.append("_");
        }
        System.out.println(word_so_far);

        int attempts = 0;


        while (true) {
            System.out.print("\nGuess a letter: ");
            String guess = sc.nextLine().toLowerCase();

            // Make sure user enter a string of length 1 between a-z
            // Second condition means exactly one lowercase letter but what if "a "
            // First cond does not allow empty character after lowercase letter. Length restricts to 1 only.
            if (guess.length() != 1 || !guess.matches("[a-z]")) {
                //throw new InputMismatchException("Please enter single letter! (Numbers/ Special Characters/ Multiple Letters are not allowed)");
                System.out.println("Please enter single letter! (Numbers/ Special Characters/ Multiple Letters are not allowed)");
                continue;
            }

            // Previously guessed letter will not be considered -> Using HashSet
            if (!guessed.contains(guess)) {
                guessed.add(guess);

                // If the guessed letter is not present in the word -> Max 6 times -> Game ends
                if (word.indexOf(guess.charAt(0)) == -1) {
                    attempts++;

                    System.out.println("Letter not present in word. Try again!");
                    //System.out.println("Number of wrong attempts: " + attempts);
                    System.out.println("Remaining attempts: " + (6-attempts));


                    if (attempts == 6) {
                        System.out.println("You have guessed wrong letter 6 times!");
                        System.out.println("The word was " + word.toUpperCase() + ".");
                        System.out.println("Better luck next time :)");
                        break;
                    }
                } else {
                    // If the guessed letter is in the word, create the update word using build_word method
                    word_so_far = build_word(word, guess, word_so_far);
                }

                // Shows the current word irrespective of right/wrong guess
                System.out.println("Word so far: " + word_so_far);


                // If the current word contains no underscores => word guessed correctly. Hence, ending the current game.
                if ((word_so_far.toString()).indexOf('_') == -1) {
                    System.out.println("You guessed right! The word is " + word_so_far.toString().toUpperCase() + ".");
                    break;
                }
            } else {

                // Guessed letter already in HashSet => Repeated guess
                System.out.println("Letter already guessed. Guess another letter!");
            }
        }


    }


    public static void main(String[] args) {

        System.out.println("\n=============== \uD83D\uDE03 Welcome to the Hangman Game \uD83D\uDE03 =====================");
        System.out.println("You can afford a total of 6 wrong guesses :)");
        Scanner sc = new Scanner(System.in);

        while (true) {

            hangmanGame();
            System.out.println("\nDo you want to play again? (Y/N): ");
            String cont = sc.nextLine();

            if (cont.equalsIgnoreCase("N")) {
                break;
            } else if (cont.equalsIgnoreCase("Y")) {
                continue;
            }
        }
        System.out.println("=================== Hope you enjoyed the game \uD83D\uDE0A =========================");

    }
}



