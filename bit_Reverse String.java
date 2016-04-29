/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/

public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() <= 1)
            return s;
        StringBuilder br = new StringBuilder(s);
        for(int i=0; i<= (br.length()-1)/2; i++){
            char c = br.charAt(i);
            br.setCharAt(i, br.charAt(br.length()-1-i));
            br.setCharAt(br.length()-1-i, c);
        }
        
        return br.toString();
    }
}
