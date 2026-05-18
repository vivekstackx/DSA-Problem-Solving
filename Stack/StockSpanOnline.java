import java.util.Stack;
/*
 daily tempretures vale ias sawal me ham har element ke next greater check kar ke uaske bich ka distance get karte h ,
 vahi stock span vale sawal me just iske ulte h , usme ham har element ke previous greater element check karte h or uaske bich 
 ka distance get karte h 
*/
class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {

        int span = 1;

        while(!stack.isEmpty() && stack.peek()[0] <= price){

            span += stack.peek()[1];

            stack.pop();
        }

        // current price + span push
        stack.push(new int[]{price, span});

        return span;
    }
}
public class OnlineStockSpan{
   public static void main(String[] args){
       StockSpanner obj = new StockSpanner();
       
       System.out.println(obj.next(3));
       System.out.println(obj.next(5));
       System.out.println(obj.next(10));
       System.out.println(obj.next(20));
       System.out.println(obj.next(52));
       System.out.println(obj.next(100));
        System.out.println(obj.next(80));
       System.out.println(obj.next(55));
       System.out.println(obj.next(70));
       System.out.println(obj.next(60));
       System.out.println(obj.next(75));
       System.out.println(obj.next(85));
       }
}
