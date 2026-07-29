class Solution {
    
    private ArrayList<Integer> getLeftView(Node root , int level , boolean[] visited , ArrayList<Integer> list){
        
           if(root == null){
               return null;
           }
           if(!visited[level - 1]){
               visited[level - 1] = true;
               list.add(root.data);
           }
           
           getLeftView(root.left , level + 1 , visited, list);
           getLeftView(root.right , level + 1 , visited , list);
           
           return list;
    }
    private int getMaxLevel(Node root){
        
        if(root == null){
            return 0;
        }
        int lh = getMaxLevel(root.left);
        int rh = getMaxLevel(root.right);
        
        return Math.max(lh , rh) + 1;
    }
    
    public ArrayList<Integer> leftView(Node root) {
        
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        int height = getMaxLevel(root);
        
        boolean[] visited = new boolean[height];
        
        return getLeftView(root , 1 , visited , list);
       
    }
}
