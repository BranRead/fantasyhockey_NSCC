public class Player {
    private String name;
    private int goals;
    private int assists;

    public Player(String name, int goals, int assists){
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
}
