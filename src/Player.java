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
            System.out.println(teams[i].getName());
            for(int j = 0; j < numPlayers; j++){
                System.out.println();
                Functions.lineBreak("-", 40);
                System.out.print(players[i][j].name + ": ");
                System.out.print("G - " + players[i][j].goals);
                System.out.print(" A - " + players[i][j].assists);
                System.out.print(" Total - " + (players[i][j].goals + players[i][j].assists) + "\n");
                Functions.lineBreak("-", 40);
            }
        }
    }
}
