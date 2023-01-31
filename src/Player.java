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
            Functions.lineBreak("=", 50);
            System.out.println(teams[i].getName());
            Functions.lineBreak("=", 50);
            for(int j = 0; j < numPlayers; j++){
                System.out.print(players[i][j].name + ": ");
                System.out.print("\tG - " + players[i][j].goals);
                System.out.print("\tA - " + players[i][j].assists);
                System.out.print("\tTotal - " + (players[i][j].goals + players[i][j].assists) + "\n");
                Functions.lineBreak("-", 50);
            }
            System.out.println();
        }
    }
}
