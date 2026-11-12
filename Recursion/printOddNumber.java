
class Recursion {
  
   void printOddNumber(int N){
        
        if(N == 1){
          System.out.println(N);
          return;
        }

        printOddNumber(N - 2);
       System.out.println(N); 

   }
}

public class Main {
    public static void main(String[] args) {

       Recursion rec = new Recursion();
        
        int num = 10; 

        if(num % 2 == 0){
           num--;
        }
       rec.printOddNumber(num); 
    }
}
