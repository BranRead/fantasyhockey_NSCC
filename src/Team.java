public class Team {
    private String name;
    private int teamNumber;
    private String rating;
    private double budget;

    private int totalGoals = 0;

    private int totalAssists = 0;

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public double getBudget() {
        return budget;
    }

    public Team(String name, int teamNumber){
        this.name = name;
        this.teamNumber = teamNumber;
        this.budget = Math.random() * 100000;
    }

    public void setRating(int numPlayers, Player[][] players){
        for(int i = 0; i < numPlayers; i++){
            totalGoals += players[this.teamNumber][i].getGoals();
            totalAssists += players[this.teamNumber][i].getAssists();
        }

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

    public static void displayTeamStats(int numOfTeams, Team[] teams) {
        for (int i = 0; i < numOfTeams; i++) {
            System.out.println();
            Functions.lineBreak("=", 40);
            System.out.println(teams[i].name + ":");
            Functions.lineBreak("-", 40);
            System.out.print("G - " + teams[i].totalGoals + " ");
            System.out.print("A - " + teams[i].totalAssists + " ");
            System.out.println("Total - " + (teams[i].totalGoals + teams[i].totalAssists));
            Functions.lineBreak("-", 40);
            System.out.println("Budget - " + "$" + MoneyFormat.doubleToMoney(teams[i].budget));
            Functions.lineBreak("-", 40);
            System.out.println("Rating: " + teams[i].getRating() + " stars");
            Functions.lineBreak("=", 40);
        }
    }
}