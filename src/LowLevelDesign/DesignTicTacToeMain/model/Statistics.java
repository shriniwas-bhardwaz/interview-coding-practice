package LowLevelDesign.DesignTicTacToeMain.model;

public class Statistics {
    private int wins;
    private int losses;
    private int draws;

    public Statistics() {
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }

    // Methods to update statistics
    public void incrementWins() { this.wins++; }
    public void incrementLosses() { this.losses++; }
    public void incrementDraws() { this.draws++; }

    // Getters for statistics
    public int getWins() { return wins; }
    public int getLosses() { return losses; }
    public int getDraws() { return draws; }
}
