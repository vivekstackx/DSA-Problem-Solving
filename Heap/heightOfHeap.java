class Solution {

     int heapHeight(int n, int arr[]) {
        
        int level = 0;
        
        while(n > 1){
           
           n = n / 2;
           level++; 
        }
        
        return level; // it is height of tree 
    }
}
