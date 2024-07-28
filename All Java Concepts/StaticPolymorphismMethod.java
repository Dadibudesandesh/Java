//Program to demonstrate method overriding
//Declaration of base class
class aclass
{
 int a;          
 aclass()
 {
  a=10;
 }
 void adisplay()        //method with same signature should be there in derived class.
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

/*method overriding meeans method of derived class hides method of base class.
  when object of derived class calls the method it will be accessed from derived class but not of base.
  as compiler solves the confusion it is an example of static polymorphism.
*/
 void adisplay()  
 {
  System.out.println(a); //data member of base class is accessed through own member function
  System.out.println(b);
 }
}

class MethodOverriding
{
 public static void main(String args[])
 {
  aclass aobj=new aclass();  
  aobj.adisplay();             //method from base class gets called  

  bclass bobj=new bclass();
  bobj.adisplay();            //method from deived class gets called 
 }
}