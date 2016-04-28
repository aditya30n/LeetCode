/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
    int quote = 1;
    for(int i= digits.length-1; i>=0; i--){
        if(quote == 0)
            break;
        int current = digits[i];
        digits[i] = (current+quote)%10;
        quote = (current+quote)/10;
    }

    if(quote > 0){
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = quote;
        for(int i=0; i<digits.length; i++)
            newDigits[i+1] = digits[i];
        return newDigits;
    }
    return digits;
}
}
