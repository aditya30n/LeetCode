/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
*/

public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        
        while(i < j){
            if(isVowel(chars[i]) && isVowel(chars[j])){
                chars[i] ^= chars[j];
                chars[j] ^= chars[i];
                chars[i] ^= chars[j];
                
                i++;
                j--;
            }
            if(!isVowel(chars[i]))
                i++;
            if(!isVowel(chars[j]))
                j--;
        }
        
        return new String(chars);
    }
    
    private boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c =='i' || c =='o' || c=='u';
    }
}
