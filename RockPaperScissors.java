import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        int rounds, userScore = 0, computerScore = 0;
        String userChoice, computerChoice;
        int computerIndex;

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.print("Enter the number of rounds you want to play: ");
        rounds = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < rounds; i++) {
            // Get user input
            System.out.print("Round " + (i + 1) + " - Enter rock, paper, or scissors: ");
            userChoice = scanner.nextLine().toLowerCase();

            // Validate user input
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid input. Please try again.");
                i--; // repeat the round
                continue;
            }

            // Generate computer choice
            computerIndex = random.nextInt(3); // 0, 1, or 2
            computerChoice = choices[computerIndex];
            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner of the round
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                       (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
                       (userChoice.equals("paper") && computerChoice.equals("rock"))) {
                System.out.println("You win this round!");
                userScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }
        }

        // Announce the overall winner
        System.out.println("\nFinal Scores:");
        System.out.println("You: " + userScore);
        System.out.println("Computer: " + computerScore);

        if (userScore > computerScore) {
            System.out.println("Congratulations! You are the overall winner!");
        } else if (userScore < computerScore) {
            System.out.println("Sorry, the computer won overall.");
        } else {
            System.out.println("It's an overall tie!");
        }

        scanner.close();
    }
}
