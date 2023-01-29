import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        //region System Start
        System.out.println("FANTASY HOCKEY");

        System.out.print("Enter how many teams will be participating: ");
        int numTeams = scan.nextInt();
        System.out.println();

        Team[] teams = new Team[numTeams];

        System.out.print("Enter how many players will be on each team: ");
        int numPlayers = scan.nextInt();
        Player[][] players = new Player[numTeams * numPlayers][numPlayers];
        System.out.println();
        String blank = scan.nextLine();
        //endregion

        //region Team Entry
        System.out.println("TEAM ENTRY");
        for (int i = 0; i < numTeams; i++) {
            System.out.print("Enter name for team #" + (i + 1) + ": ");
            teams[i] = new Team(scan.nextLine(), i);
            System.out.println();
        }
        //endregion

        //region Player Entry
        System.out.println("PLAYER ENTRY");

        for(int i = 0; i < numTeams; i++){
            System.out.println("Enter players for: " + teams[i].getName());
            for(int j = 0; j < numPlayers; j++){
                System.out.print("Enter name for player #" + (j + 1) + ": ");
                String name = scan.nextLine();
                System.out.println();

                System.out.print("Enter number of goals for " + name + ": ");
                int goals = scan.nextInt();
                System.out.println();

                System.out.print("Enter number of assists for " + name + ": ");
                int assists = scan.nextInt();
                System.out.println("\n");
                blank = scan.nextLine();

                players[i][j] = new Player(name, goals, assists);
            }

            teams[i].setRating(numPlayers, players);
        }
        //endregion




        //region Display Stats
        System.out.println("REPORT: Stats per team");
        for(int i = 0; i < numTeams; i++) {
            System.out.println("Team name is: " + teams[i].getName() + "\n" +
                    "Team rating is: " + teams[i].getRating() + "\n" +
                    "Team budget is: " + "$" + MoneyFormat.doubleToMoney(teams[i].getBudget()));
        }

        System.out.println("REPORT: Stats per player");
        Player.displayPlayerStats(numTeams, teams, numPlayers, players);
        //endregion
    }
}