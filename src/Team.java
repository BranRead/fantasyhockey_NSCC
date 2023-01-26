public class Team {
    private String name;
    private Player[] players;
    private String rating;
    private double budget;

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public double getBudget() {
        return budget;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Team(String name, Player[] players){
        this.name = name;
        this.players = players;

        int total = 0;
        for(Player i : players){
            total += i.getGoals();
            total += i.getAssists();
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

       budget = Math.random() * 100000;
    }

    public void displayPlayerStats() {
        for (Player element : players) {
            System.out.println(this.getName());
            System.out.println(element.getName() + ": " + "G - " + element.getGoals() + " A - " +
                    element.getAssists() + " Total - " + (element.getGoals() + element.getAssists()));
        }

    }

   
}
