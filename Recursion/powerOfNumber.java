
class Solution{
    
    int powerOfNumber(int base , int exponent){
        
         if(base == 1 || exponent == 0) return 1; 
         
         if(exponent == 1) return base; 
         
         return base * powerOfNumber(base , exponent - 1);
        
    
    }
}

public class Main
{   
	public static void main(String[] args) {
		
		 int base = 2; 
		 int exponent = 3; 
		 
		System.out.println(new Solution().powerOfNumber(base , exponent));
	}
}
