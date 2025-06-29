package com.leveloneprojects.guessthenumber;
import java.util.*;

/*
Project - Guess the Number

Rules of the game

1. The computer generates a random number between 1 and 100 and you need to guess the number
2. If your guess is greater than the number by 10 or lower than the number by 10 - the system will output 'Cold'
3. If your guess is within a + / - 10 range from the number, the system will output 'Hot'
4. You have unlimited attempts.

*/

public class guessthenumber{

    public static int get_random_number(){
        Random random_obj = new Random();

        int max = 100;
        int min = 1;
        int n = random_obj.nextInt((max-min) + 1) + min;

        //100-1 = 99 + 1 = 100 => generates number from 0 to 99
        //Adding 1 => If generates 0 => 0+1 = 1
        //Adding 1 => If generates 99 => 99+1 = 100
        return n;
    }
    public static void main(String[] args) throws Exception{

        int n = get_random_number();

        Scanner sc = new Scanner(System.in);


        while(true) {
            System.out.print("Guess a number starting from 1 to 100: ");
            int guess = sc.nextInt();

            if (guess == n) {
                System.out.println("Correct!!");
                break;
            } else if (Math.abs(guess - n) <= 10) {
                System.out.println("Hot!");
            } else {
                System.out.println("Cold");
            }
        }
    }
}
