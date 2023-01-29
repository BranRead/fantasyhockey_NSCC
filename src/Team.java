public class Team {
    private String name;
    private int teamNumber;
    private String rating;
    private double budget;

    public String getName() {
        return name;
    }

    public int getTeamNumber() {
        return teamNumber;
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
        int total = 0;
        for(int i = 0; i < numPlayers; i++){
            total += players[this.getTeamNumber()][i].getGoals();
            total += players[this.getTeamNumber()][i].getAssists();
        }

        if (total > 20) {
            rating = "***";
        } else if (total >= 10) {
            rating = "**";
        } else if (total > 0) {
            rating = "*";
        } else {
            rating = "0";
        }
    }
}