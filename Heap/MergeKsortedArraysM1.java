
class Solution {
    private int heapSize; 
    
    
    private void swap(ArrayList<Integer> ans , int a , int b){
       
         int temp = ans.get(a); 
         ans.set(a , ans.get(b)); 
         ans.set(b , temp); 
    }
    
    private void heapify(ArrayList<Integer> ans , int parent){
       
        while(true){
             int largest = parent; 
             
             int leftChild = 2 * parent + 1; 
             int rightChild = 2 * parent + 2; 
             
             if(leftChild < heapSize && ans.get(leftChild) > ans.get(largest)){
                 largest = leftChild; 
             }
             
             if(rightChild < heapSize && ans.get(rightChild) > ans.get(largest)){
                 largest = rightChild; 
             }
             
             if(largest == parent) break; 
             
             swap(ans , parent , largest); 
             parent = largest; // move to downward
        }    
    }
    
    private void deleteNode(ArrayList<Integer> ans){
       
        swap(ans , 0 , heapSize - 1); 
        heapSize--; 
        
        heapify(ans, 0);
    }
    
    private void heapSort(ArrayList<Integer> ans){
        
         heapSize = ans.size();   
        // convert into max-heap 
        int nonLeaf = ans.size() / 2 - 1; 
        
        for(int i = nonLeaf; i >= 0; i--){
            heapify(ans , i); 
        }
        
        // delete every node from max-heap 
        for(int i = 1; i < ans.size(); i++){
            deleteNode(ans); 
        }
        
    }
    
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        
        ArrayList<Integer> ans = new ArrayList<>(); 
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                ans.add(mat[i][j]);
            }
        }
        
        heapSort(ans);
        
        return ans; 
        
    }
}
