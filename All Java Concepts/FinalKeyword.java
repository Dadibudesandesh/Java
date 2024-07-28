//Program to demonstrate final keyword
class bclass {
    final int a;

    public bclass() {
        a = 10;
    }

    void incr() {
        // value of final variable can not be modified once it's iniltialized
        // a++;
        System.out.println(a);
    }
}

class FinalKeyword {
    public static void main(String args[]) {
        bclass obj = new bclass();
        obj.incr();
    }
}