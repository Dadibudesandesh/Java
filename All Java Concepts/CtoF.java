class temp {
    int c;
    float f;

    temp() {
        c = 35;
    }

    void cTOf() {
        f = 9 / 5 * c + 32;
        System.out.println("Farenheight temp:" + f);
    }
}

class CtoF {
    public static void main(String args[]) {
        temp obj = new temp();
        obj.cTOf();
    }
}