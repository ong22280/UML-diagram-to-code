class Board {
    private Square[] squares = new Square[40]; // สร้าง array ของช่องที่มี 40 ช่อง

    public Board() {
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square("Square " + (i + 1)); // สร้างช่องและตั้งชื่อตามลำดับ
        }
    }

    // คืนค่าช่องที่ตำแหน่งที่กำหนด
    public Square getSquare(int index) {
        return squares[index];
    }

    // คืนค่าตำแหน่งของช่องที่กำหนดใน array ของช่อง
    public int getSquareIndex(Square square) {
        for (int i = 0; i < squares.length; i++) {
            if (squares[i].equals(square)) {
                return i; // ถ้าพบช่องที่ตรงกับที่กำหนด คืนค่าตำแหน่งของช่องนั้น
            }
        }
        return -1; // ถ้าไม่พบช่องที่ตรงกับที่กำหนด คืนค่า -1
    }
}