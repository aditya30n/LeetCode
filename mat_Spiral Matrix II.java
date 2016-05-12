/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int xStart = 0;
        int xEnd = n-1;
        int yStart =0;
        int yEnd = n-1;
        int count = 1;
        
        while(true){
            for(int i=yStart; i<=yEnd; i++)
                matrix[xStart][i] = count++;
            if(++xStart > xEnd)
                break;
            for(int i=xStart; i<=xEnd; i++)
                matrix[i][yEnd] = count++;
            if(yStart > --yEnd)
                break;
            for(int i=yEnd; i>= yStart; i--)
                matrix[xEnd][i] = count++;
            if(xStart > --xEnd)
                break;
            for(int i=xEnd; i>= xStart; i--)
                matrix[i][yStart] = count++;
            if(++yStart > yEnd)
                break;             
        }
        return matrix;
    }
}
