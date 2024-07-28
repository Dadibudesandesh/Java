//program to demonstrate abstract class.
//abstract class is a class having at least one method declared as an abstract.
abstract class abclass
{
 int ab;          
 abclass()
 {
  ab=10;
 }

 abstract void abdisplay();  //abstract method is a method which does not have any definition.
}

//declaration of derived class using extends keyword.
class bclass extends abclass
{
 int b;
 bclass()    
 {
  b=20;
 }

/*method overriding means method of derived class hides method of base class.
  when reference of abstract class calls the method, the instance/object assigned to reference is checked.
  if instance/object is of derived class, function from derived class is accessed but not of base.
  as JVM solves the confusion during run time, it is an example of dynamic polymorphism.
*/
 void abdisplay()  
 {
  System.out.println(ab); //data member of base class is accessed through own member function.
  System.out.println(b);
 }
}

class AbstractClass
{
 public static void main(String args[])
 {
  abclass abref;                      //We can create reference of abstract class. 
  //abclass abobj=new abclass();     //we can not create object of abstract class.
  //abref=abobj;                    //object of base is assigned to the reference of base.
  //abref.abdisplay();             //method from base class gets called.
  
  bclass bobj=new bclass();       //derived class object.
  abref=bobj;                    //object of derived is assigned to the reference of abstract.
  abref.abdisplay();            //method from derived class gets called. 
 }
}