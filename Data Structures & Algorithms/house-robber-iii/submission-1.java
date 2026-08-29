/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int curr;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int curr) { this.curr = curr; }
 *     TreeNode(int curr, TreeNode left, TreeNode right) {
 *         this.curr = curr;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        // dfs + dp
        // if visit root, cannot visit root.left or root.right
        int[] result = dfs(root);
        return Math.max(result[0], result[1]); // prev, prevPrev
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {0,0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = node.val + left[0] + right[0];

        return new int[] {notRob, rob};
    }


}