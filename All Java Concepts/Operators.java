class operator {
    int a, b;

    operator() {
        a = 4;
        b = 2;
    }

    void arithmetic() {
        System.out.println("Results of Arithmetic Operation");
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
    }

    void bitwise() {
        System.out.println("Results of Bitwise Operation");
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
        System.out.println(a << b);
        System.out.println(a >> b);
    }

    void relational() {
        System.out.println("Results of Relational Operaton");
        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(a <= b);
        System.out.println(a >= b);
        System.out.println(a != b);
    }

    void logical() {
        System.out.println("Results of Logical Operation");
        System.out.println(a < b && b < 5);
        System.out.println(a > b || b < 5);
    }
}

class Operators {
    public static void main(String args[]) {
        operator obj = new operator();
        obj.arithmetic();
        obj.bitwise();
        obj.relational();
        obj.logical();
    }
}