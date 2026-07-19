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
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        checklevel(root,1);
        return list;
    }
    int max = 0;
    public void checklevel(TreeNode root,int level){
        if(root==null) return;

        if(max<level){
        list.add(root.val);
        max = level;
        }

        checklevel(root.right,level+1);
        checklevel(root.left,level+1);
    }
}
