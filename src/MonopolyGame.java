public class MonopolyGame {
    private int roundCount;
    private final Die[] dices = new Die[2];
    private final Player[] players;
    private final Board board;

    public MonopolyGame(int numPlayers) {
        if (numPlayers < 2 || numPlayers > 8) {
            throw new IllegalArgumentException("Number of players must be between 2 and 8.");
        }
        players = new Player[numPlayers];
        board = new Board();
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player("Player " + (i + 1), dices, board);
        }
    }

    public void playGame() {
        while (roundCount < 100) { // replace 100 with your desired number of rounds
            playRound();
            roundCount++;
        }
    }

    public void playRound() {
        for (Player player : players) {
            player.takeTurn();
        }
    }
}