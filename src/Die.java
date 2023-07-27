public class Die {
    private int faceValue; // ค่าที่ได้จากการทอดลูกเต๋า

    // สร้างเมธอด roll ที่จะทำการทอดลูกเต๋าและเก็บค่าที่ได้ใน faceValue
    public void roll() {
        faceValue = (int) (Math.random() * 6) + 1;
    }

    public int getFaceValue() {
        return faceValue;
    }
}
