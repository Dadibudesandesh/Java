class fact
{
 int no,f;
 fact()
 {
  no=5;
 } 
 void check()
 {
  f=1;
  int i=1;
  while(i<=no)
  {
   f=f*i;
   i++;
  }
  System.out.println(f);
 }
}

class Factorial
{
 public static void main(String args[])
 {
  fact obj=new fact();
  obj.check();
 }
}