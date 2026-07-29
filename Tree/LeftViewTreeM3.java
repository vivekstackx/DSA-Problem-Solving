class Solution {
  
  private void getLeftView(Node root, int level , ArrayList<Integer> list){
      if(root == null){
          return;
      }
      
      if(level > list.size()){
          list.add(root.data);
      }
      getLeftView(root.left , level + 1 , list);
      getLeftView(root.right, level + 1 , list);
      
  }
    public ArrayList<Integer> leftView(Node root) {
       
       ArrayList<Integer> list = new ArrayList<>();
       
       getLeftView(root , 1, list);
       
       return list;
    }
}
