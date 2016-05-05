/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class Solution {
    public int reverse(int x) {
        long d = x;
        if(d < 0)
            d = -d;
        
        long reverse = 0;
        while(d > 0){
            reverse = reverse * 10 + d %10;
            d = d/10;
        }
        
        if(x < 0)
            reverse = -reverse;
        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
            return 0;
        return (int)reverse;
    }
}
