
class Solution{
    
    int sumOfCubesNumber(int n){
        
        if(n == 0) return 0; 
        
        if(n == 1) return 1; 
        
        return n * n * n + sumOfCubesNumber(n - 1);
    }
}

public class Main
{   
	public static void main(String[] args) {
		
		System.out.println(new Solution().sumOfCubesNumber(5));
	}
}
