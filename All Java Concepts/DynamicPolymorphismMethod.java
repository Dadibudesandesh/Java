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
  when reference of base class calls the method, the instance/object assigned to reference is checked.
  if instance/object is of derived class, function from derived class is accessed but not of base.
  as JVM solves the confusion during run time, it is an example of dynamic polymorphism.
*/
 void adisplay()  
 {
  System.out.println(a); //data member of base class is accessed through own member function
  System.out.println(b);
 }
}

class DynamicPolymorphismMethod
{
 public static void main(String args[])
 {
  aclass aref;                   //base class reference 
  aref=new aclass();            //instance of base is assigned to the reference of base
  aref.adisplay();             //method from base class gets called
  
  aref=new bclass();         //instance of derived is assigned to the reference of base
  aref.adisplay();          //method from derived class gets called 
 }
}