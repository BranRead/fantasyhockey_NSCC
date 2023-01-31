import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //region Initializing Vars
        Scanner scan = new Scanner(System.in);
        int numTeams;
        int numPlayers;
        String playerName;
        int goals;
        int assists;

        //Width of the symbol lines used everywhere and used for indented text
        int dispWidth = 50;
        //endregion

        //region System Start
        //Any of these functions called line break take a symbol and an int
        //They then repeat that symbol in a line for that many characters
        Functions.lineBreak("=", dispWidth);
        Functions.lineBreak("=", dispWidth);
        System.out.println("\t\t\t\t\s\sFANTASY HOCKEY");
        Functions.lineBreak("=", dispWidth);
        Functions.lineBreak("=", dispWidth);

        //Using do...while loop because I want this to run at least once.
        do {
            System.out.print("Enter how many teams will be participating: ");
            //Nested while loop which runs continuously if the user doesn't enter an int
            while(!scan.hasNextInt()){
                //I have lots of these throughout to properly space the code.
                System.out.println();
                //This simply clears the scanner. Has no other function within this program.
                scan.next();
                System.out.print("Please enter a number: ");
            }
            //Only captures it if the user enters an int
            numTeams = scan.nextInt();
            //If it fails the secondary check I give them the reason it failed
            //before returning to the first of this do/while.
            if(numTeams < 2){
                System.out.println("Please enter a number greater than 1");
                System.out.println();
            }
        } while (numTeams < 2);
        Functions.lineBreak("-", dispWidth);
        //I initialize an array of Team objects after finding out how many teams are being created.
        Team[] teams = new Team[numTeams];

        //This next do/while is the same as the previous.
        //Different restriction on the int, however.
        //No point in having a competition with only 1 team
        //but you COULD have just one player per team.
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
        Functions.lineBreak("-", dispWidth);
        //An array of arrays made here for easy access to the players of each team
        //This allows finding the players with each team's index value.
        Player[][] players = new Player[numTeams * numPlayers][numPlayers];
        System.out.println();
        //Finished entering ints so need to capture the space which is left by nextInt()
        //This var is not used anywhere except to do the above.
        String blank = scan.nextLine();

        //endregion

        //region Team Entry
        Functions.lineBreak("=", dispWidth);
        Functions.lineBreak("=", dispWidth);
        System.out.println("\t\t\t\t\tTEAM ENTRY");
        Functions.lineBreak("=", dispWidth);
        Functions.lineBreak("=", dispWidth);

        //Another do/while loop nested within a for loop to validate user entry
        //For each team name. Loops for however many teams the user entered
        for (int t = 0; t < numTeams; t++) {
            do {
                //The index for the array will start at zero and increment instead of 1
                //I add one to it here so it displays properly for the user.
                System.out.print("Enter name for team #" + (t + 1) + ": ");
                //Add to the array of teams right away, along with the index number to create the object
                teams[t] = new Team(scan.nextLine(), t);

                //Like before I check to see if the user will fail the exit requirement of the loop
                //If they will I give them the reason for that failure.
                if(teams[t].getName().length() < 3){
                    System.out.println("Please enter a name at least 3 characters long.");
                    System.out.println();
                }
            }while(teams[t].getName().length() < 3);

            Functions.lineBreak("-", dispWidth);
        }
        System.out.println();
        //endregion

        //region Player Entry
        Functions.lineBreak("=", dispWidth);
        Functions.lineBreak("=", dispWidth);
        System.out.println("\t\t\t\t\s\s\sPLAYER ENTRY");
        Functions.lineBreak("=", dispWidth);
        Functions.lineBreak("=", dispWidth);
        System.out.println();

        //Loops for each team.
        //Stating the team name at the beginning and then looping through the players.
        for(int t = 0; t < numTeams; t++){
            Functions.lineBreak("=", dispWidth);
            Functions.indent("Entering players for " + teams[t].getName() + ": ", dispWidth);
            Functions.lineBreak("=", dispWidth);
            //Entering the Player name involves a very similar do/while loop nested within a for loop.
            //The for loop takes in name, goals and assists for each player every loop
            //Helpful reminder: t = index of team, p = index of player
            for(int p = 0; p < numPlayers; p++){
                do {
                    System.out.print("Enter name for player #" + (p + 1) + ": ");
                    //Temp variable used for name, goals and assists in order to store it
                    //until the end of the loop to create a player object.
                    playerName = scan.nextLine();

                    if(playerName.length() < 3){
                        System.out.println("Please enter a name at least 3 characters long.");
                        System.out.println();
                    }
                } while(playerName.length() < 3);
                Functions.lineBreak("-", dispWidth);

                //The next two do/while loops are the same, just adjusted for outputs to say goal/assist
                //Also adds the input value to the respective variable.
                do {
                    System.out.print("Enter number of goals for " + playerName + ": ");
                    while(!scan.hasNextInt()){
                        System.out.println();
                        scan.next();
                        System.out.print("Please enter a number: ");
                    }
                    goals = scan.nextInt();

                    if(goals < 0){
                        System.out.println("Please enter a number which is 0 or greater.");
                        System.out.println();
                    }
                } while(goals < 0);

                Functions.lineBreak("-", dispWidth);

                do {
                    System.out.print("Enter number of assists for " + playerName + ": ");

                    while(!scan.hasNextInt()){
                        System.out.println();
                        scan.next();
                        System.out.print("Please enter a number:");
                    }
                    assists = scan.nextInt();

                    if(assists < 0){
                        System.out.println("Please enter a number which is 0 or greater.");
                        System.out.println();
                    }
                } while(assists < 0);

                Functions.lineBreak("-", dispWidth);
                System.out.println();
                blank = scan.nextLine();
                //Basically this just adds the players in order to the correct array.
                //This array index corresponds with the teamNumber var for each team object.
                //Each of these arrays is its own array of player objects.
                //This inner loop repeats until all the players for one team has been entered.
                players[t][p] = new Player(playerName, goals, assists);
            }
            //Before the outside loop repeats, this method is called in order to calculate the team rating.
            teams[t].setRating(numPlayers, players);
        }
        //endregion

        //region Display Stats
        Functions.lineBreak("=", dispWidth);
        Functions.lineBreak("=", dispWidth);
        System.out.println("\t\t\t\sREPORT: Stats per team");
        Functions.lineBreak("=", dispWidth);
        Functions.lineBreak("=", dispWidth);
        System.out.println();
        Team.displayTeamStats(numTeams, teams);

        System.out.println();

        Functions.lineBreak("=", dispWidth);
        Functions.lineBreak("=", dispWidth);
        System.out.println("\t\t\t\sREPORT: Stats per player");
        Functions.lineBreak("=", dispWidth);
        Functions.lineBreak("=", dispWidth);
        System.out.println();
        Player.displayPlayerStats(numTeams, teams, numPlayers, players);

        Functions.lineBreak("=", dispWidth);
        System.out.println("\t\t\sTeam and player stats outputted,");
        System.out.println("\t\t\t\tScroll up to read.");
        System.out.println("\t\t\sThank you for using this program!");
        Functions.lineBreak("=", dispWidth);
        System.out.println();
        //endregion
    }
}