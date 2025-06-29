import java.security.SecureRandom;
import java.util.*;

/* Objective:
Create a secure password generator in Java that:

Accepts the desired password length as input from the user.

Ensures the password includes at least one uppercase letter, one lowercase letter, one digit, and one special character.

Generates a strong random password of the specified length.

Shuffles the password to eliminate predictable character positioning.

Handles invalid user inputs gracefully.*/

public class PasswordGenerator {

    public static StringBuilder shuffle(StringBuilder pwd)
    {
        List<Character> chars = new ArrayList<>();
        for (char c : pwd.toString().toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars);

        StringBuilder shuffled_password = new StringBuilder();
        for (char c : chars) {
            shuffled_password.append(c);
        }

        return shuffled_password;
    }

    public static String generatePassword(int n) {


        System.out.println("\nGenerating your custom password of length " + n + "..");
        System.out.println("It will contain uppercase and lowercase characters, digits and special characters!");


        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?/";
        String all = upper + lower + digits + special;

        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        // Ensuring at least one lowercase, uppercase character, digit and special character
        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        // Filling the remaining positions in the password randomly
        for (int i = 0; i < n - 4; i++) {
            password.append(all.charAt(random.nextInt(all.length())));
        }


        //Always the first four characters will be in order of upper, lower, digit and special character
        // Using Collections to shuffle all characters in the generated password

        password = shuffle(password);

        return password.toString();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("\nWhat will be the length of your password? ");

            if(!sc.hasNextInt())
            {
                throw new InputMismatchException("\nPlease enter numeric value only.");
            }
            int len = sc.nextInt();
            if (len < 8) {
                throw new IllegalArgumentException("\nPassword should be at least 8 characters long to ensure security.");
            }

            String gen_password = generatePassword(len);
            System.out.println("\nWe have generated your custom password: " + gen_password);
        }
        catch(InputMismatchException e)
        {
            System.out.println(e.getMessage());

        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Something went wrong. We need to check.");
        }
        finally {
            System.out.println("Thank you for using our Password Generator :)");
        }

    }
}



