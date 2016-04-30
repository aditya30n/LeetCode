/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/

//No extra memory
public class Solution {
    public String reverseString(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] chars = s.toCharArray();
        for (i=0; i<j; i++, j--){
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }
        
        return new String(chars);
    }
}

// Using 1 char space
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
