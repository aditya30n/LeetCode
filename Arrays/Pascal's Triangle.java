/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        if(numRows <= 0)
            return pascal;

        List<Integer> row = new ArrayList<>();
        row.add(1);
        pascal.add(row);

        if(numRows == 1)
            return pascal;

        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        pascal.add(row);

        for (int i = 2; i<numRows; i++){
            List<Integer> prev = pascal.get(i-1);
            row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i)
                    row.add(prev.get(0));
                else
                    row.add(prev.get(j-1) + prev.get(j));
            }
            pascal.add(row);
        }
        
        return pascal;
    }
}
