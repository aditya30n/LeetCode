/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
 
 //Using Stack
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if(root == null)
            return out;
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root);
        List<Integer> level;
        while(!s1.isEmpty() || !s2.isEmpty()){
            level = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode temp = s1.pop();
                level.add(temp.val);
                if(temp.left != null)
                    s2.add(temp.left);
                if(temp.right != null)
                    s2.add(temp.right);
            }
            
            if(level.size() > 0)
                out.add(level);
            
            level = new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode temp = s2.pop();
                level.add(temp.val);
                if(temp.right != null)
                    s1.add(temp.right);
                if(temp.left != null)
                    s1.add(temp.left);
            }
            if(level.size() > 0)
                out.add(level);
        }
        
        return out;
    }
}


//Using Queue
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if(root == null)
            return out;
        
        List<Integer> level;
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next;
        current.add(root);
        boolean flag = true;
        while(!current.isEmpty()){
            next = new LinkedList<>();
            level = new ArrayList<>();
            while(!current.isEmpty()){
                TreeNode temp = current.remove();
                level.add(temp.val);
                if(temp.left != null)
                    next.add(temp.left);
                if(temp.right != null)
                    next.add(temp.right);
            }
            
            if(flag)
                out.add(level);
            else
                out.add(reverseList(level));
            flag = !flag;
            current = next;
        }
        
        
        return out;
    }
    
    private List<Integer> reverseList(List<Integer> myList) {
    List<Integer> invertedList = new ArrayList<>();
    for (int i = myList.size() - 1; i >= 0; i--) {
            invertedList.add(myList.get(i));
    }
    return invertedList;
}
}
