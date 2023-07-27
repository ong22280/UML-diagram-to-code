class Board {
    private Square[] squares = new Square[40];

    public Board() {
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square("Square " + (i + 1));
        }
    }

    public Square getSquare(int index) {
        return squares[index];
    }

    public int getSquareIndex(Square square) {
        for (int i = 0; i < squares.length; i++) {
            if (squares[i].equals(square)) {
                return i;
            }
        }
        return -1; // return -1 if the square is not found
    }
}