class Solution {
    public int fib(int n) {
        
        if(n == 0) return 0; 

        int a = 0; 
        int b = 1; 
        
        int temp = 0; 

        int fn = 1;

        while(true){
            
            if(fn == n) return b;

            temp = b;
            b = a + b;
            a = temp; 

            fn++; 
        }
    }
}
