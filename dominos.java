// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MinDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = -1;
        res = findMinRotation(tops, bottoms, tops[0]);
        if (res != -1)
            return res;
        return findMinRotation(tops, bottoms, bottoms[0]); // check for the other number
    }

    private int findMinRotation(int[] tops, int[] bottoms, int target) {
         int topsRotations = 0;
  int bottomsRotations = 0;
        for (int i = 0; i < tops.length; i++) { // check if the target is present in all the dominos
             if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }

             if (tops[i] != target) {
                topsRotations++; // if the target is not present in the top, then we need to rotate the top
             }

            if (bottoms[i] != target) {
                bottomsRotations++;
            }

        }
        return Math.min(topsRotations, bottomsRotations);
    }
}