public class Player {
    private String name;
    private int goals;
    private int assists;

    public Player(String name, int goals, int assists) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public String getName() {
        return name;
    }

    public static void displayPlayerStats(int numTeams, Team[] teams, int numPlayers, Player[][] players) {
        for (int i = 0; i < numTeams; i++) {
            for(int j = 0; j < numPlayers; j++){
                System.out.println(teams[i].getName());
                System.out.println(players[i][j].getName() + ": " + "G - " + players[i][j].getGoals() + " A - " +
                        players[i][j].getAssists() + " Total - " + (players[i][j].getGoals() + players[i][j].getAssists()));
            }
        }
    }
}
