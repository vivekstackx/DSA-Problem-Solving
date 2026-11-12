
class Recursion {
  
   void printEvenNumber(int N){
        
        if(N == 2){
          System.out.println(N);
          return;
        }

        printEvenNumber(N - 2);
       System.out.println(N); 

   }
}

public class Main {
    public static void main(String[] args) {

       Recursion rec = new Recursion();
        
        int num = 11; 

        if(num % 2 != 0){
           num--;
        }
       rec.printEvenNumber(num); 
    }
}
