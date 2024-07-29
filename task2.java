import java.util.Random;
import java.util.Scanner;

class Task1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int randomNum = rand.nextInt(100) + 1;
        System.out.println("Guess the random number between 1 and 100");
        int attempts = 0;

        while (true) {
            int guess = sc.nextInt();
            attempts++;

            System.out.println("Your guess was: " + guess);

            if (guess > randomNum) {
                System.out.println("your number is a a little greater");
            } else if (guess < randomNum) {
                System.out.println("Your number is a little less");
            } else {
                System.out.println("Match found!");
                break;
            }
        }
        int negative_score = attempts - 1;
        System.out.println("The random number was: " + randomNum);
        int score = 100 - negative_score;
        System.out.println("Your guess score is: " + score + "/100");

        sc.close();
    }
}
