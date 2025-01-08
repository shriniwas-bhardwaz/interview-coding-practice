package LowLevelDesign.DesignTicTacToe.model;

public class Player {
    String name;
    PlayingPiece piece;

    public Player(String name, PlayingPiece piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public PlayingPiece getPlayingPiece() { return piece; }

    public void setPlayingPiece(PlayingPiece piece) { this.piece = piece; }

}
