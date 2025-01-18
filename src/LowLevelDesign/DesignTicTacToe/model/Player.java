package LowLevelDesign.DesignTicTacToe.model;

public class Player {
    private String name;
    private PlayingPiece piece;
    private Statistics statistics;

    public Player(String name, PlayingPiece piece) {
        this.name = name;
        this.piece = piece;
        this.statistics = new Statistics();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public PlayingPiece getPlayingPiece() { return piece; }

    public void setPlayingPiece(PlayingPiece piece) { this.piece = piece; }

    public Statistics getStatistics() {
        return  this.statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
