package acwing.acwing1497;

import java.util.*;

public class Main {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder){
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        int rootval = postorder[postEnd];
        int index = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(rootval == inorder[i]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootval);
        int leftsize = inEnd - index;
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postEnd - leftsize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postEnd - leftsize, postEnd - 1);
        return root;
    }
    void traverse(TreeNode root){
        if(root == null) return;
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            arr.add(cur.val);
            if(cur.left != null){
                q.offer(cur.left);
            }
            if(cur.right != null){
                q.offer(cur.right);
            }
        }
//        System.out.println(arr);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] inorder = new int[num];
        int[] postorder = new int[num];
        for(int i = 0; i < num; i++){
            postorder[i] = sc.nextInt();
        }
        for(int i = 0; i < num; i++){
            inorder[i] = sc.nextInt();
        }
        Main demomain = new Main();
        TreeNode treeNode = demomain.buildTree(inorder, postorder);
        demomain.traverse(treeNode);
    }
}
