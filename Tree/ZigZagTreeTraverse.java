class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        if(root == null){
            return list;
        }

         Deque<TreeNode> stack1 = new ArrayDeque<>();
         Deque<TreeNode> stack2 = new ArrayDeque<>();

         stack1.push(root);

         while(!stack1.isEmpty() || !stack2.isEmpty()){

            if(!stack1.isEmpty()){
                List<Integer> leftToRightRow = new ArrayList<>();

                while(!stack1.isEmpty()){
                    
                   TreeNode temp = stack1.pop();
                    leftToRightRow.add(temp.val);

                    if(temp.left != null){
                        stack2.push(temp.left);
                    }
                    if(temp.right != null){
                        stack2.push(temp.right);
                    }
                }
                list.add(leftToRightRow);
            }

            if(!stack2.isEmpty()){
                List<Integer> rightToLeftRow = new ArrayList<>();

                while(!stack2.isEmpty()){

                  TreeNode temp = stack2.pop();
                    rightToLeftRow.add(temp.val);

                    if(temp.right != null){
                        stack1.push(temp.right);
                    }
                    if(temp.left != null){
                        stack1.push(temp.left);
                    }

                }
                list.add(rightToLeftRow);
            }
         }

         return list;
    }
}
