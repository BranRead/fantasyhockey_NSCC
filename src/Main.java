import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter name for team 1: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        System.out.println("Enter name for player 1 :");
        String namePlayer1 = input.nextLine();

        System.out.println("Enter goals for " + namePlayer1 +  ": ");
        int goalsPlayer1 = input.nextInt();
        String blank = input.nextLine();

        System.out.println("Enter assists for " + namePlayer1 +  ": ");
        int assistsPlayer1 = input.nextInt();
        blank = input.nextLine();

        Player[] player = new Player[3];
        player[0] = new Player(namePlayer1, goalsPlayer1, assistsPlayer1);

        System.out.println("Enter name for player 2 :");
        String namePlayer2 = input.nextLine();

        System.out.println("Enter goals for " + namePlayer2 +  ": ");
        int goalsPlayer2 = input.nextInt();
        blank = input.nextLine();

        System.out.println("Enter assists for " + namePlayer2 +  ": ");
        int assistsPlayer2 = input.nextInt();
        blank = input.nextLine();

        player[1] = new Player(namePlayer2, goalsPlayer2, assistsPlayer2);

        System.out.println("Enter name for player 3 :");
        String namePlayer3 = input.nextLine();

        System.out.println("Enter goals for " + namePlayer3 +  ": ");
        int goalsPlayer3 = input.nextInt();
        blank = input.nextLine();

        System.out.println("Enter assists for " + namePlayer3 +  ": ");
        int assistsPlayer3 = input.nextInt();
        blank = input.nextLine();

        player[2] = new Player(namePlayer3, goalsPlayer3, assistsPlayer3);

        Team team1 = new Team(name, player);

        System.out.println("Team name is: " + team1.getName() + "\n" +
                "Team rating is: " + team1.getRating() + "\n" +
                "Team budget is: " + team1.getBudget());

        team1.displayPlayerStats();
    }
}