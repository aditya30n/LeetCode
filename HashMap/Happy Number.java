/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

public class Solution {
    public boolean isHappy(int n) {
        return isHappy(n,new HashSet<Integer>());
    }
    
    private boolean isHappy(int n, HashSet<Integer> set) {
        if(!set.add(n))
            return false;
        int newNumber = getsum(n);
        if(newNumber == 1)
            return true;
        return isHappy(newNumber, set);
    }
    
    private int getsum(int n){
        int sum =0;
        while(n != 0){
            sum += (n%10)*(n%10);
            n = n/10;
        }
        
        return sum;
    }
}
