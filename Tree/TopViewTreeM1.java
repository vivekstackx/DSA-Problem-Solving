import java.util.Arrays;

class TreeNode{
    
    TreeNode left;
    int data;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree{
    private int leftMostPosition;
    private int rightMostPosition;
    
      Tree(){
          leftMostPosition = 0;
          rightMostPosition = 0;
      }
      
     private void getPosition(TreeNode root , int position){
       
          if(root == null){
              return;
          }
          leftMostPosition = Math.min(leftMostPosition , position);
          rightMostPosition = Math.max(rightMostPosition , position);
          
          getPosition(root.left , position - 1);
          getPosition(root.right , position + 1);
          
     }
    private void getTopViewHelper(TreeNode root, int level, int index, int[] levelControl, int[] ans){
        
         if(root == null){
             return;
         }
         if(level < levelControl[index]){
             levelControl[index] = level;
             ans[index] = root.data;
         }
         
         getTopViewHelper(root.left, level + 1, index - 1, levelControl, ans);
         getTopViewHelper(root.right, level + 1 , index + 1, levelControl , ans);
         
    }
     
    int[] getTopView(TreeNode root){
        
        if(root == null){
            return new int[0];
        }
        
        leftMostPosition = 0;
        rightMostPosition = 0;
        
        getPosition(root , 0);
        
        int topViewLength = rightMostPosition - leftMostPosition + 1;
        
        int[] ans = new int[topViewLength];
        
        int[] levelControl = new int[topViewLength];
        Arrays.fill(levelControl , Integer.MAX_VALUE);
        
        getTopViewHelper(root, 1, Math.abs(leftMostPosition), levelControl , ans);
        
        return ans;
        
    }
}



class Main{
    public static void main(String[] args){
        
        TreeNode root = null;
        
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.left.left.left.left = new TreeNode(11);
        
        root.right =  new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        root.right.right.right.left = new TreeNode(13);
        root.right.right.right.right = new TreeNode(30);
        root.right.right.right.left.right = new TreeNode(20);
        root.right.right.right.left.right.right = new TreeNode(25);
        
        int[] ans = new Tree().getTopView(root);
        
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    
    }
}
