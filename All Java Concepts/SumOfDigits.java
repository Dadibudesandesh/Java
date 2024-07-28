class sod
{
 int no,s;
 sod()
 {
  no=123;
 } 
 void check()
 {
  s=0;
  while(no>0)
  {
   s=s+no%10;
   no/=10;
  }
  System.out.println(s);
 }
}

class prog10
{
 public static void main(String args[])
 {
  sod obj=new sod();
  obj.check();
 }
}