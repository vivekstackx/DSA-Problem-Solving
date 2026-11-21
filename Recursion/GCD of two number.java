class Solution {
    
    public static int getGCD(int a , int b){
      
       int gcd = 1; 
       
       int min = Math.min(a , b); 
       
       for(int i = 2; i <= min; i++){
           
           if(a % i == 0 && b % i == 0){
               gcd = i;
           }
       }
       
       return gcd; 
    }
    
    public static int gcd(int a, int b) {
       
       return getGCD(a , b); 
    }
}
