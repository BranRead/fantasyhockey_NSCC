import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //region Initializing Vars
        Scanner scan = new Scanner(System.in);
        int numTeams = 0;
        int numPlayers = 0;
        String playerName = "";
        int goals = 0;
        int assists = 0;
        //endregion

        //region System Start
        System.out.println("FANTASY HOCKEY");


        do {
            System.out.print("Enter how many teams will be participating: ");
            while(!scan.hasNextInt()){
                System.out.println();
                scan.next();
                System.out.print("Please enter a number: ");
            }
            numTeams = scan.nextInt();
            if(numTeams < 2){
                System.out.println("Please enter a number greater than 1");
                System.out.println();
            }
        } while (numTeams < 2);
        System.out.println();

        Team[] teams = new Team[numTeams];

        do {
            System.out.print("Enter how many players will be on each team: ");
            while(!scan.hasNextInt()){
                System.out.println();
                scan.next();
                System.out.print("Please enter a number: ");
            }
            numPlayers = scan.nextInt();
            if(numPlayers < 1){
                System.out.println("Please enter a number greater than 0.");
                System.out.println();
            }

        } while (numPlayers < 1);

        Player[][] players = new Player[numTeams * numPlayers][numPlayers];
        System.out.println();
        String blank = scan.nextLine();

        //endregion

        //region Team Entry
        System.out.println("TEAM ENTRY");
        for (int i = 0; i < numTeams; i++) {
            do {
                System.out.print("Enter name for team #" + (i + 1) + ": ");
                teams[i] = new Team(scan.nextLine(), i);

                if(teams[i].getName().length() < 3){
                    System.out.println("Please enter a name at least 3 characters long.");
                }
                System.out.println();
            }while(teams[i].getName().length() < 3);
        }
        //endregion

        //region Player Entry
        System.out.println("PLAYER ENTRY");

        for(int i = 0; i < numTeams; i++){
            System.out.println("Entering players for " + teams[i].getName() + ": ");
            for(int j = 0; j < numPlayers; j++){
                do {
                    System.out.print("Enter name for player #" + (j + 1) + ": ");
                    playerName = scan.nextLine();

                    if(playerName.length() < 3){
                        System.out.println();
                        System.out.println("Please enter a player name at least 3 characters long.");
                    }
                } while(playerName.length() < 3);

                System.out.println();

                do {
                    System.out.print("Enter number of goals for " + playerName + ": ");
                    while(!scan.hasNextInt()){
                        System.out.println();
                        scan.next();
                        System.out.print("Please enter a number: ");
                    }
                    goals = scan.nextInt();

                    if(goals < 0){
                        System.out.println();
                        System.out.println("Please enter a number which is 0 or greater.");
                    }
                } while(goals < 0);

                System.out.println();

                do {
                    System.out.print("Enter number of assists for " + playerName + ": ");

                    while(!scan.hasNextInt()){
                        System.out.println();
                        scan.next();
                        System.out.print("Please enter a number:");
                    }
                    assists = scan.nextInt();

                    if(assists < 0){
                        System.out.println();
                        System.out.println("Please enter a number which is 0 or greater.");

                    }
                } while(assists < 0);

                System.out.println("\n");
                blank = scan.nextLine();
                players[i][j] = new Player(playerName, goals, assists);

            }

            teams[i].setRating(numPlayers, players);
        }
        //endregion

        //region Display Stats
        System.out.println("REPORT: Stats per team");
        Team.displayTeamStats(numTeams, teams);

        System.out.println("REPORT: Stats per player");
        Player.displayPlayerStats(numTeams, teams, numPlayers, players);
        //endregion
    }
}