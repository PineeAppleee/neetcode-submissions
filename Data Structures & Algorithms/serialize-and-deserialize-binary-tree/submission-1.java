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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder str = new StringBuilder();
        serializetion(root, str);
        return str.toString();
    }

    public void serializetion(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("N ");
            return;
        }
        str.append(root.val + " ");
        serializetion(root.left, str);
        serializetion(root.right, str);
    }

    // Decodes your encoded data to tree.
    int idx = 0;
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;

            idx = 0;
            
        String[] preorder = data.trim().split(" ");

        return build(preorder);
    }

    public TreeNode build(String[] preorder) {
        if (preorder[idx].equals("N")) {
            idx++;
            return null;
        }

        int val = Integer.parseInt(preorder[idx++]);
        TreeNode root = new TreeNode(val);

        root.left = build(preorder);
        root.right = build(preorder);

        return root;
    }
}
