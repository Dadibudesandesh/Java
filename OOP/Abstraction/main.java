package Abstraction;

abstract class animal {
    animal() {
        System.out.println("creating a new animal");
    }

    abstract void walk();

    public void eat() {
        System.out.println("eating");
    }
}

class Hourse extends animal {
    Hourse() {
        System.out.println("create a new Hourse");

    }

    public void walk() {
        System.out.println("Hours is walking....");
    }
}

class Dog extends animal {

    Dog() {
        System.out.println("create a new Dog");

    }

    public void walk() {
        System.out.println("Dog is walking....");

    }

}

class Cat extends animal {
    Cat() {
        System.out.println("create a new Cat");

    }

    public void walk() {
        System.out.println("Cat is walking....");

    }
}

public class main {
    public static void main(String[] args) {
        Hourse Hourse = new Hourse();
        Dog dog = new Dog();
    }
}
