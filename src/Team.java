public class Team {
    //region Class Variables
    private String name;
    private int teamNumber;
    private String rating;
    private double budget;
    private int totalGoals = 0;
    private int totalAssists = 0;
    //endregion

    //region Getters
    public String getName() {
        return name;
    }
    //endregion

    //region Constructor
    public Team(String name, int teamNumber){
        this.name = name;
        this.teamNumber = teamNumber;
        //Budget is generated randomly with Math.random()
        //Multiplied by max value.
        this.budget = Math.random() * 100000;
    }
    //endregion

    //region Methods
    //Requires:
    //Number of players as int
    //Array of arrays of Player objects
    public void setRating(int numPlayers, Player[][] players){
        //For loop goes through and adds up total goals and assists
        //Saved to class variables, so they can be used later for team stats
        for(int p = 0; p < numPlayers; p++){
            totalGoals += players[this.teamNumber][p].getGoals();
            totalAssists += players[this.teamNumber][p].getAssists();
        }

        //If/else statement to decide rating based on the addition
        //of total goals and assists of the whole team
        //Greater than 20 is ***
        //Less than 20 but more than 10 is **
        //10 or less is *
        //0 is 0 (shocking)
        if (totalGoals + totalAssists > 20) {
            rating = "***";
        } else if (totalGoals + totalAssists >= 10) {
            rating = "**";
        } else if (totalGoals + totalAssists > 0) {
            rating = "*";
        } else {
            rating = "0";
        }
    }

    //Required:
    //Number of teams
    //Array of Team objects
    public static void displayTeamStats(int numOfTeams, Team[] teams) {
        //For loop goes through each team and lists:
        //goals, assists and total of the two
        //Budget
        //Rating
        for (int t = 0; t < numOfTeams; t++) {
            Functions.lineBreak("=", 50);
            System.out.println(teams[t].name + ":");
            Functions.lineBreak("=", 50);
            System.out.print("G - " + teams[t].totalGoals + " \t");
            System.out.print("A - " + teams[t].totalAssists + " \t");
            System.out.println("Total - " + (teams[t].totalGoals + teams[t].totalAssists));
            Functions.lineBreak("-", 50);
            System.out.println("Budget - " + "$" + MoneyFormat.doubleToMoney(teams[t].budget));
            Functions.lineBreak("-", 50);
            System.out.println("Rating: " + teams[t].rating + " stars");
            Functions.lineBreak("=", 50);
        }
    }
    //endregion
}