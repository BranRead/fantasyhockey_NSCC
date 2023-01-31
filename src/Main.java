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
        Functions.lineBreak("=", 40);
        System.out.println("FANTASY HOCKEY");
        Functions.lineBreak("=", 40);


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
        Functions.lineBreak("-", 40);

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
        Functions.lineBreak("-", 40);
        Player[][] players = new Player[numTeams * numPlayers][numPlayers];
        System.out.println();
        String blank = scan.nextLine();

        //endregion

        //region Team Entry
        Functions.lineBreak("=", 40);
        System.out.println("TEAM ENTRY");
        Functions.lineBreak("=", 40);

        for (int i = 0; i < numTeams; i++) {
            do {
                System.out.print("Enter name for team #" + (i + 1) + ": ");
                teams[i] = new Team(scan.nextLine(), i);

                if(teams[i].getName().length() < 3){
                    System.out.println("Please enter a name at least 3 characters long.");
                }
            }while(teams[i].getName().length() < 3);

            Functions.lineBreak("-", 40);

        }
        //endregion

        //region Player Entry
        Functions.lineBreak("=", 40);
        System.out.println("PLAYER ENTRY");
        Functions.lineBreak("=", 40);
        System.out.println();

        for(int i = 0; i < numTeams; i++){
            Functions.lineBreak("=", 40);
            System.out.println("Entering players for " + teams[i].getName() + ": ");
            Functions.lineBreak("=", 40);
            for(int j = 0; j < numPlayers; j++){
                do {
                    System.out.print("Enter name for player #" + (j + 1) + ": ");
                    playerName = scan.nextLine();

                    if(playerName.length() < 3){
                        System.out.println();
                        System.out.println("Please enter a player name at least 3 characters long.");
                    }
                } while(playerName.length() < 3);
                Functions.lineBreak("-", 40);

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
                Functions.lineBreak("-", 40);

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

                Functions.lineBreak("-", 40);
                System.out.println();
                blank = scan.nextLine();
                players[i][j] = new Player(playerName, goals, assists);

            }

            teams[i].setRating(numPlayers, players);
        }
        //endregion

        //region Display Stats
        Functions.lineBreak("=", 40);
        System.out.println("REPORT: Stats per team");
        Functions.lineBreak("=", 40);

        Team.displayTeamStats(numTeams, teams);

        Functions.lineBreak("=", 40);
        System.out.println("REPORT: Stats per player");
        Functions.lineBreak("=", 40);
        Player.displayPlayerStats(numTeams, teams, numPlayers, players);
        //endregion
    }
}