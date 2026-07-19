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
    public int goodNodes(TreeNode root) {
        return count(root,root.val);
    }
    public int count(TreeNode root,int max){
     if(root==null) return 0;

     int pick = 0;
     if(root.val>=max){
        pick = 1;
        max = root.val;
     }

     pick+=count(root.left,max);
     pick+=count(root.right,max);
     return pick;
    }
}
