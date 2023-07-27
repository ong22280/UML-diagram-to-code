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
        // สร้างผู้เล่นแต่ละคน
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player("Player " + (i + 1), dices, board);
        }
    }

    // สร้างเมธอด playGame ที่จะเล่นเกมจนกว่าจะถึงจำนวนรอบที่กำหนด
    public void playGame() {
        while (roundCount < 10) { // แทน 10 ด้วยจำนวนรอบที่ต้องการ
            playRound();
            roundCount++;
        }
    }

    // สร้างเมธอด playRound ที่จะทำให้ผู้เล่นทุกคนเล่นตาของตัวเอง
    public void playRound() {
        for (Player player : players) {
            player.takeTurn();
        }
    }
}