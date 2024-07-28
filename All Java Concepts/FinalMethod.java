//Program to demonstrate final method
//Declaration of base class
class aclass
{
 int a;          
 aclass()
 {
  a=10;
 }
 final void adisplay()        //method with same signature should be there
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
  b=20;
 }

 //we can not override final method.
 //Compile the code and check the error.
 void adisplay()  
 {
  System.out.println(a); //data member of base class is accessed through own member function
  System.out.println(b);
 }
}

class FInalMethod
{
 public static void main(String args[])
 {
  aclass aobj=new aclass(10);  
  aobj.adisplay();              

  bclass bobj=new bclass();
  bobj.adisplay();             
 }
}