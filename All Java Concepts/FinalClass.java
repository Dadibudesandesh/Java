//Program to demonstrate final class
final class aclass
{
 int a;          
 aclass()
 {
  a=10;
 }
 void adisplay() 
 {
  System.out.println(a);
 }
}

//Compile the program and check the error.
class bclass extends aclass
{
 int b;
 bclass()    
 {
  b=20;
 }
 void bdisplay()
 {
  System.out.println(a); 
  System.out.println(b);
 }
}

class FinalClass
{
 public static void main(String args[])
 {
  aclass aobj=new aclass();  
  aobj.adisplay();

  bclass bobj=new bclass();
  bobj.adisplay();     
  bobj.bdisplay();      
 }
}