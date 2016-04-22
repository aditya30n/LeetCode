/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
            
        Map<Character, Integer> map = new HashMap<>();
        Character c = null;
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else
                map.put(c,1);
                
            c = t.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
            }
            else
                map.put(c,-1);
        }
        
        for(Integer num : map.values()){
            if(num != 0)
                return false;
        }
        
        return true;
    }
}
