public class Player {
    //region Class Variables
    private String name;
    private int goals;
    private int assists;
    //endregion

    //region Getters
    //Both required in Team class to calculate rating.
    public int getGoals() {
        return goals;
    }
    public int getAssists() {
        return assists;
    }
    //endregion

    //region Constructor
    public Player(String name, int goals, int assists) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
    }
    //endregion

    //region Methods
    //Requires:
    //number of teams,
    //array of Team objects,
    //number of players and
    //array of arrays of Player objects
    public static void displayPlayerStats(int numTeams, Team[] teams, int numPlayers,
                                          Player[][] players) {
        //Displays all stats team by team with a for loop nested within a for loop
        for (int t = 0; t < numTeams; t++) {
            //The outside loop simply prints the team name and tracks the team index
            //t = team index, p = player index
            Functions.lineBreak("=", 50);
            Functions.indent(teams[t].getName(), 50);
            Functions.lineBreak("=", 50);

            for(int p = 0; p < numPlayers; p++){
                //This outputs the name, goals, assists and total of these two
                //This all goes on the same line then it goes to the next player
                //Once all players for the team are entered it goes to the next outside loop and team.
                System.out.print(players[t][p].name + ": ");
                System.out.print("\tG - " + players[t][p].goals);
                System.out.print("\tA - " + players[t][p].assists);
                System.out.print("\tTotal - " + (players[t][p].goals + players[t][p].assists) + "\n");

                //Just a conditional to format it properly.
                //Doesn't add the line of "-" after the last player for the team.
                if(p < numPlayers - 1) {
                    Functions.lineBreak("-", 50);
                }
            }
            Functions.lineBreak("=", 50);
            System.out.println();
        }
    }
    //endregion
}
