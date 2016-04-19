/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        return binaryTreePaths(root, new ArrayList<>(), Integer.toString(root.val));
    }
    
    public List<String> binaryTreePaths(TreeNode root, List<String> paths, String sb){
        if(root.left == null && root.right == null){
            paths.add(sb);
            return paths;
        }
        if(root.left != null)
            binaryTreePaths(root.left, paths, sb + "->" + root.left.val);
        if(root.right != null)
            binaryTreePaths(root.right, paths, sb + "->" + root.right.val);
        return paths;
    }
}
