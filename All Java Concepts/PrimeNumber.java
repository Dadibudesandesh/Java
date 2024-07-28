class prime {
   int no;

   prime() {
      no = 13;
   }

   void check() {
      int i = 2;
      while (i < no) {
         if (no % i == 0)
            break;
         i++;
      }
      if (i == no)
         System.out.println("Prime");
      else
         System.out.println("Not Prime");
   }
}

class PrimeNumber {
   public static void main(String args[]) {
      prime obj = new prime();
      obj.check();
   }
}