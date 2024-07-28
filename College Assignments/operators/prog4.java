
class operators {

    int a;
    int b;

    public operators() {
        a = 10;
        b = 20;
        System.out.println();
        System.out.println("a : " + a + "   b : " + b);
        System.out.println();

    }

    public void arithmatic() {
        System.out.println("a+b : " + (a + b));
        System.out.println("a-b : " + (a - b));
        System.out.println("a*b : " + (a * b));
        System.out.println("a/b : " + (a / b));
        System.out.println("a%b : " + (a % b));
    }

    public void assignment() {

        System.out.println("a=b : " + (a = b));
        System.out.println("a+=b : " + (a += b));
        System.out.println("a-=b : " + (a -= b));
        System.out.println("a*=b : " + (a *= b));
        System.out.println("a/=b : " + (a /= b));
        System.out.println("a%=b : " + (a %= b));
    }

    public void relational() {
        System.out.println("a==b : " + (a == b));
        System.out.println("a!=b : " + (a != b));
        System.out.println("a<b : " + (a < b));
        System.out.println("a>b : " + (a > b));
        System.out.println("a<=b : " + (a <= b));
        System.out.println("a>=b : " + (a >= b));
    }

    public void bitwise() {
        System.out.println("a | b : " + (a | b));
        System.out.println("a & b : " + (a & b));
        System.out.println("a ^ b : " + (a ^ b));
        System.out.println("~a : " + (~a));
        System.out.println("~b : " + (~b));
        System.out.println("a>>b : " + (a >> b));
        System.out.println("a<<b : " + (a << b));
        System.out.println("a>>>b : " + (a >>> b));

    }

    public void logical(){
        System.out.println("(a>b) && (a!=b) : " +((a>b) && (a!=b)) );
        System.out.println("(a>b) || (a!=b) : " +((a>b) || (a!=b)) );
        System.out.println("!(a>b) : " +(!(a>b)));
    }

    public void ternary(){
        System.out.println("(a<b)?(a+b):(a-b) = " + ((a<b)?(a+b):(a-b))  );

    }


}

public class prog4 {

    public static void main(String[] args) {
        operators obj = new operators();

        System.out.println("\t\t\tO P E R A T O R S    I N    J A V A");
        System.out.println();
        System.out.println("\t\tA R I T H M A T I C   O P E R A T O R S    I N    J A V A");
        obj.arithmatic();
        System.out.println("\t\tA S S I N G M E N T   O P E R A T O R S    I N    J A V A");
        obj.assignment();
        System.out.println("\t\tB I T W I S E   O P E R A T O R S    I N    J A V A");
        obj.bitwise();
        System.out.println("\t\tR E L A T I O N A L    O P E R A T O R S    I N    J A V A");
        obj.relational();
        System.out.println("\t\tL O G I C A L   O P E R A T O R S    I N    J A V A");
        obj.logical();
        System.out.println("\t\tT E R N A R Y    O P E R A T O R S    I N    J A V A");
        obj.ternary();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}