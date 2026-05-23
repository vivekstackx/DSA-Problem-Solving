import java.util.Deque;
import java.util.ArrayDeque;

class Pair{
   int data;
   int min;
     Pair(int data , int min){
       this.data = data;
       this.min = min;
     }
}

class Solution{
  
    private Deque<Pair> stack;
    
     Solution(){
       this.stack = new ArrayDeque<>();
     }
     
     // push operation
     void push(int data){
        if(stack.isEmpty()){
          stack.push(new Pair(data, data));
        }
        else{
          stack.push(new Pair(data , Math.min(data, stack.peek().min)));
        }
     }
     // pop operation
    Pair pop(){
   if(stack.isEmpty()) return null;
   return stack.pop();
}
     // peek operation
     int peek(){
       
       if(stack.isEmpty()){
         return -1;
       }
       return stack.peek().data;
       
     }
     // get min
     int getMin(){
       if(stack.isEmpty()){
         return -1;
       }
       return stack.peek().min;
     }
}

public class MinStackUsingSingleStackPair {
    public static void main(String[] args) {
Solution obj = new Solution();
       
       obj.push(5);
       obj.push(9);
       obj.push(3);
       obj.push(0);
       obj.push(1);
       obj.push(7);
       obj.push(2);
       obj.push(4);
       obj.push(6);
              
      obj.pop();
       
        System.out.println(obj.getMin());
    }
}
