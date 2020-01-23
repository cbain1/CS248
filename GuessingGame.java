
import java.util.*;

class GuessingGame {
    public static void main(String [] args) {
        int play='Y';
        int number = (int)(1+100*Math.random());
        Scanner cin=new Scanner(System.in);

        System.out.println("I have a number between 1 and 100. Can you guess it?");
        System.out.println("Enter your guess: "); 

        while (play == 'Y' ) {
            int guess = 0;
            guess = cin.nextInt(); 

            if (guess > number) {
                int insult = (int)(1+5*Math.random());
                if (insult == 1)
                    System.out.println("You are too high dummy buns");
                if (insult == 2)
                    System.out.println("This is not the number you are looking for weak minded one, you are too high");
                if (insult == 3)
                    System.out.println("You are too high, silly");
                if (insult == 4)
                    System.out.println("Too high, silly English Knight");
                if (insult == 5)
                    System.out.println("Too high, guess better fool");
            }
            if (guess < number) {
                int insult = (int)(1+5*Math.random());
                if (insult == 1)
                    System.out.println("You are too low fish face");
                if (insult == 2)
                    System.out.println("You couldn't be more wrong, you are too low");
                if (insult == 3)
                    System.out.println("That guess is more dissappointing than an unsalted pretzel, you are too low!");
                if (insult == 4)
                    System.out.println("Too low, crunchy lizard");
                if (insult == 5)
                    System.out.println("You are too low, noob");
            }
            if (guess == number) {

                System.out.println("Congrats! You finally got it!");
                System.out.println("Would you like to play again? Please enter Y or N ");
                play = cin.next().charAt(0);
                if (play == 'Y') {
                    number = (int)(1+100*Math.random());
                    System.out.println("I have a new number, please enter your guess: "); 
                }
            }
                
        }
        cin.close();
    }
}