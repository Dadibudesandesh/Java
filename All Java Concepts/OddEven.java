class oddeven
{
 int no;
 oddeven()
 {
  no=5;
 }
 void check()
 {
  if(no%2==0)
    System.out.println("No. is even");
  else
    System.out.println("No. is odd"); 
 }
}

class OddEven
{
 public static void main(String args[])
 {
  oddeven obj=new oddeven();
  obj.check();
 }
}