//Program to demonstrate simple inheritance
//Declaration of base class
class aclass
{
 int a;          
 aclass(int p)
 {
  a=p;
 }
 void adisplay() 
 {
  System.out.println(a);
 }
}

//Declaration of derived class using extends keyword.
class bclass extends aclass
{
 int b;
 bclass()    
 {
  //parametrized constructor of base class gets explicitly accessed using super keyword
  //super keyword should be the first statement in constructor.
  super(10);
  b=20;
 }
 void bdisplay()
 {
  System.out.println(a); //data member of base class is accessed through own member function
  System.out.println(b);
 }
}

class SuperKeyword
{
 public static void main(String args[])
 {
  aclass aobj=new aclass(10);  //object should be created using parametrized constructor
  aobj.adisplay();

  bclass bobj=new bclass();
  bobj.adisplay();      //member function of base class is accessed through own object
  bobj.bdisplay();      
 }
}