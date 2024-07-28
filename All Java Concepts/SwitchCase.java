class switchcase
{
 int per;
 switchcase()
 {
  per=57;
 }
 void check()
 {
  switch(per/10)
  {
  case 7:
    System.out.println("Distinction");
    break;
  case 6:
    System.out.println("First class");
    break; 
  case 5:
    System.out.println("Second class");
    break; 
  case 4:
    System.out.println("Pass");
  default:
    System.out.println("Fail");
  }  
 }
}

class SwitchCase
{
 public static void main(String args[])
 {
  switchcase obj=new switchcase();
  obj.check();
 }
}