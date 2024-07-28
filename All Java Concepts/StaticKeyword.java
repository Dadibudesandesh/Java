//Program to demonstrate static keyword
class sdemo {
  int nsdm; // non static data members
  static int sdm; // static data member

  static // static block is used to initialize static data members
  {
    sdm = 10; // static data members are owned by class
  }

  sdemo() // constructor is used to initialize non static data members
  {
    nsdm = 10; // non static data members are owned by objects
  }

  // non static member function
  void nsmf() {
    // non static member function can access both non static and static data member
    nsdm++;
    sdm++;
    System.out.println(nsdm);
    System.out.println(sdm);
  }

  // static member function
  static void smf() {
    System.out.println("static member function");
  }

  static void smf(sdemo r) {
    r.nsdm++; // static member function can access non static data members using object of the
              // class
    sdm++; // static member function can access static data members directly
    System.out.println(r.nsdm);
    System.out.println(sdm);
  }

}

class StaticKeyword {
  public static void main(String args[]) {
    // multiple objects share the value of static data member.
    sdemo obj1 = new sdemo();
    obj1.nsmf();

    sdemo obj2 = new sdemo();
    obj2.nsmf();

    // OR

    // static members are accessed using class name
    sdemo.smf(obj1);
    System.out.println(sdemo.sdm);
    sdemo.smf();
  }
}