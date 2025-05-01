import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void run (){
        Scanner scanner = new Scanner(System.in);
        int targetNumber = generateRandomInteger();
        System.out.println("\n");
        System.out.println("=".repeat(24));
        System.out.println("Number Guessing Game");
        displayOpening();
        while (true){
            int choice = scanner.nextInt();
            if (choice == 1){
                displayResponse("Easy");
                guessingNumber(10, targetNumber);
                return;
            } else if (choice == 2) {
                displayResponse("Medium");
                guessingNumber(5, targetNumber);
                return;
            } else if (choice == 3) {
                displayResponse("Hard");
                guessingNumber(3, targetNumber);
                return;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            run();
            System.out.println("\nDo you want to play again? (y/n)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("y")){
                continue;
            } else {
                return;
            }
        }
    }

    public static int generateRandomInteger (){
        return (int) (Math.random() * 101);
    }

    public static void displayOpening (){
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have chances to guess the correct number.\n");
        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
        System.out.println("Enter your choice:");
    }

    public static void displayResponse (String s){
        System.out.println(String.format("Great! You have selected the %s difficulty level.", s));
        System.out.println("Let's start the game!");
    }

    public static void guessingNumber (int chances, int targetNumber){
        Scanner s = new Scanner(System.in);
        int i;
        for (i = 0; i < chances; i++) {
            System.out.println("Enter your guess:");
            int guess = s.nextInt();
            if (guess != targetNumber){
                if (guess > targetNumber){
                    System.out.println("Incorrect! The number is less than " + guess + ".");
                } else {
                    System.out.println("Incorrect! The number is greater than " + guess + ".");
                }
                if (chances == 3 && i == 1 || chances == 5 && i == 3 || chances == 10 && i == 8){
                    System.out.println("Do you want a hint? (y/n)");
                    String hint = s.next();
                    if (hint.equalsIgnoreCase("y")){
                        System.out.println(String.format("Target number is between %d and %d", targetNumber - (int)(Math.random() * 4), targetNumber + (int)(Math.random() * 5)));
                    }
                }

                if (chances == 5 && i == 1 || chances == 10 && i == 1){
                    System.out.println("Do you want a hint? (y/n)");
                    String hint = s.next();
                    if (hint.equalsIgnoreCase("y")){
                        System.out.println("The number is " + ((targetNumber % 2 == 0)? "even" : "odd"));
                    }
                }

            } else if (i == chances - 1) {
                System.out.println("No chances left");
                System.out.println("The right number is " + targetNumber);
                break;
            } else {
                System.out.printf("Congratulations! You guessed the correct number in %d attempts.%n", i + 1);
                break;
            }
        }

    }
}