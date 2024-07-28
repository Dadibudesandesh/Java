import java.util.Scanner;

class findArea {
    double pi;

    public findArea() {
        pi = 3.14;
    }

    public double aoc(double radius) {
        return (pi * radius * radius);
    }

    public double aot(double base, double height) {
        return (0.5 * base * height);
    }

    public double aor(double length, double width) {
        return (length * width);
    }
    public double aos(double a) {
        return (a * a);
    }

}

public class area {

    public static void main(String[] args) {
        double radius;

        Scanner sc = new Scanner(System.in);
        findArea findArea = new findArea();
        System.out.println("---------------  F I N E D    A R E A  ----------------------");
        System.out.println("1] Circle");
        System.out.println("2] Triangle");
        System.out.println("3] Rectangle");
        System.out.println("4] Square");

        System.out.print("Enter Option : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter radius : ");
                radius = sc.nextDouble();
                System.out.println("Area Of Circle is : " + findArea.aoc(radius));
                break;
            case 2:
                System.out.print("Enter Base : ");
                double base = sc.nextDouble();
                System.out.print("Enter height : ");
                double height = sc.nextDouble();
                System.out.println("Area Of Triangle is : " + findArea.aot(base, height));
                break;
            case 3:
                System.out.print("Enter Length : ");
                double length = sc.nextDouble();
                System.out.print("Enter Width : ");
                double width = sc.nextDouble();
                System.out.println("Area Of Rectangle is : " + findArea.aor(length, width));
                break;
            case 4:
                System.out.print("Enter Length of side : ");
                double a = sc.nextDouble();
                System.out.println("Area Of Square is : " + findArea.aoc(a));
                break;

            default:
                System.out.println("Enter valid option.....!");
                break;
        }

    }
}