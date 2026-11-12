
class Recursion{
  
   void printNnumber(int currentNum , int N){
        
        if(currentNum == N){
          System.out.println(currentNum);
          return;
        }
        
        System.out.println(currentNum);

        printNnumber(currentNum + 1 , N);
   }
}

public class Main {
    public static void main(String[] args) {

       Recursion rec = new Recursion();

       rec.printNnumber(1 , 10); 
    }
}
