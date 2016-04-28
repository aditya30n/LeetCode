/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if((top == '(' && c != ')') || (top == '{' && c != '}') || (top == '[' && c != ']'))
                    return false;       
            }
        }
        
        return stack.isEmpty();
    }
}
