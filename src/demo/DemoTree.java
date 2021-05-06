package demo;

public class DemoTree {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(3);
            root.left.right = new TreeNode(4);
            root.left.left = new TreeNode(2);
            root.left.left.left = new TreeNode(1);
            root.right = new TreeNode(6);
            root.right.right = new TreeNode(8);
            root.right.right.right = new TreeNode(9);
            root.right.right.left = new TreeNode(7);
          TreeNode tr = increasingBST(root);
//          System.out.println(tr);
          print(tr);

      }
      public static TreeNode increasingBST(TreeNode root) {
           TreeNode cur = new TreeNode();
           TreeNode dummyNode = cur;
          dfs(root, cur);
          return dummyNode.right;
      }
      public static void dfs(TreeNode root, TreeNode cur){
          if(root == null) return;
          dfs(root.left, cur);
          cur.right = new TreeNode(root.val);
          System.out.println(root.val);
          cur = cur.right;
          System.out.println(cur.val + "-----");
          dfs(root.right, cur);
      }
      public static void print(TreeNode root){
          if(root == null){
              System.out.print(null+" ");
              return;
          }
          System.out.print(root.val+" ");
          print(root.left);
          print(root.right);
      }
}
