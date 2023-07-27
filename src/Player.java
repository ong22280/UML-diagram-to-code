class Player {
    private String name;
    private Die[] dices;
    private Board board;
    private Piece piece;

    public Player(String name, Die[] dices, Board board) {
        this.name = name;
        this.dices = dices;
        this.board = board;
        this.piece = new Piece(board.getSquare(0)); // start at the first square
    }

    public void takeTurn() {
        int fvTotal = 0;
        for (Die dice : dices) {
            dice.roll();
            fvTotal += dice.getFaceValue();
        }
        Square oldLocation = piece.getLocation();
        int oldLocationIndex = board.getSquareIndex(oldLocation);
        int newLocationIndex = (oldLocationIndex + fvTotal) % 40; // assuming there are 40 squares on the board
        Square newLocation = board.getSquare(newLocationIndex);
        piece.setLocation(newLocation);
    }
}