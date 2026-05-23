import java.util.Deque;
import java.util.ArrayDeque;

class Solution{
  
   private Deque<Integer> stack1;
   private Deque<Integer> stack2;
    
      Solution(){
         this.stack1 = new ArrayDeque<>();
         this.stack2 = new ArrayDeque<>();
      }
     // push operation
     void push(int data){
       
       
        if(stack1.isEmpty()){
           stack1.push(data);
           stack2.push(data);
        }
        else{
          stack1.push(data);
          stack2.push(Math.min(data , stack2.peek()));
        }
     }
     //pop operation
     int pop(){
       
       if(stack1.isEmpty()){
          return -1;
       }
       int temp = stack1.pop();
       stack2.pop();
       return temp;
       
     }
     // get min
     int getMin(){
       if(stack1.isEmpty()){
         return -1;
       }
       return stack2.peek();
     }
     
     // display stack
      void display(){
          System.out.println(stack1);
        System.out.println(stack2);
      }
}

public class MinStackUsingTwoStack {
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
      
      obj.display();
         
         obj.pop();
       
        System.out.println(obj.getMin());
       
    }
}
