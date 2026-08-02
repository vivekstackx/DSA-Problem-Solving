
class Solution {
    
    private int leftMostPosition, rightMostPosition;
    
      Solution(){
          leftMostPosition = rightMostPosition = 0;
      }
    
    private void getPosition(Node root, int position){
        
        if(root == null){
            return;
        }
        leftMostPosition = Math.min(leftMostPosition , position);
        rightMostPosition = Math.max(rightMostPosition, position);
        
        getPosition(root.left, position - 1);
        getPosition(root.right, position + 1);
    }
    
    private void getBottomView(Node root , int level, int index, int[] controlLevelArr, int[] ans){
        
        if(root == null){
            return;
        }
        
        if(level >= controlLevelArr[index]){
            controlLevelArr[index] = level;
            ans[index] = root.data;
        }
        
        getBottomView(root.left, level + 1, index - 1, controlLevelArr, ans);
        getBottomView(root.right, level + 1, index + 1, controlLevelArr , ans);
        
    }
    
    public ArrayList<Integer> bottomView(Node root) {
       
         ArrayList<Integer> ans = new ArrayList<>();
         
         if(root == null){
             return ans;
         }
         
        leftMostPosition = rightMostPosition = 0;
         
         getPosition(root, 0);
         
         int bottomViewLength = rightMostPosition - leftMostPosition + 1;
         
         int[] tempAns = new int[bottomViewLength]; 
         int[] controlLevelArr = new int[bottomViewLength];
         
         Arrays.fill(controlLevelArr , Integer.MIN_VALUE);
         
         getBottomView(root , 1, Math.abs(leftMostPosition), controlLevelArr, tempAns);
         
         for(int i = 0; i < tempAns.length; i++){
             ans.add(tempAns[i]);
         }
         
         return ans;
    }
}
