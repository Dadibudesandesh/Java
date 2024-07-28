class grade
{
 int per;
 grade()
 {
  per=57;
 }
 void check()
 {
  if(per>=70)
    System.out.println("Distinction");
  else if(per>=60)
    System.out.println("First class"); 
  else if(per>=50)
    System.out.println("Second class"); 
  else if(per>=40)
    System.out.println("Pass");
  else
    System.out.println("Fail");  
 }
}

class Grade
{
 public static void main(String args[])
 {
  grade obj=new grade();
  obj.check();
 }
}