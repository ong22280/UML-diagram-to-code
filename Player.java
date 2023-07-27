class Player {
    private String name;
    private Die[] dices; // ลูกเต๋าที่ผู้เล่นใช้
    private Board board; // board ที่ผู้เล่นเล่นอยู่
    private Piece piece; // ชิ้นเกมที่ผู้เล่นควบคุม

    public Player(String name, Die[] dices, Board board) {
        this.name = name;
        this.dices = dices;
        this.board = board;
        this.piece = new Piece(board.getSquare(0)); // ให้ชิ้นเกมของผู้เล่นเริ่มที่ช่องแรก
    }

    // ทำให้ผู้เล่นทอยลูกเต๋าและเคลื่อนที่ชิ้นเกม
    public void takeTurn() {
        int fvTotal = 0;
        // ทอยลูกเต๋าทุกลูกและบวกค่าที่ได้เข้ากับ fvTotal
        for (Die dice : dices) {
            dice.roll();
            fvTotal += dice.getFaceValue();
        }
        // หาตำแหน่งปัจจุบันของชิ้นเกม
        Square oldLocation = piece.getLocation();
        // หา index ของตำแหน่งปัจจุบันใน array ของช่อง
        int oldLocationIndex = board.getSquareIndex(oldLocation);
        // คำนวณ index ของตำแหน่งใหม่โดยการบวก fvTotal และหารด้วยจำนวนช่องทั้งหมด (ในที่นี้คือ 40)
        int newLocationIndex = (oldLocationIndex + fvTotal) % 40;
        // หาช่องใหม่จาก index ที่คำนวณได้
        Square newLocation = board.getSquare(newLocationIndex);
        // ย้ายชิ้นเกมไปยังช่องใหม่
        piece.setLocation(newLocation);
    }
}