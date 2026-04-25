/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int lvl = qu.size();
            for(int i=0; i<lvl; i++){
                TreeNode l = qu.peek().left;
                TreeNode r = qu.peek().right;
                if(qu.peek().left!=null) qu.offer(qu.peek().left);
                if(qu.peek().right!=null) qu.offer(qu.peek().right);
                qu.peek().left = r;
                qu.peek().right = l;
                qu.poll();
            }
        }
        return root;
    }
}
