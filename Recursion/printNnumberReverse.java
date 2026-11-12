import java.util.*;

class Recursion{
  
   void printNnumber(int N){
        
        if(N == 1){
          System.out.println(N);
          return;
        }

        System.out.println(N); 

        printNnumber(N - 1);
   }
}

public class Main {
    public static void main(String[] args) {

       Recursion rec = new Recursion();

       rec.printNnumber(10); 
    }
}
