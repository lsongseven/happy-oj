//Given an M x N matrix in which each row and each column is sorted in ascending
// order, write a method to find an element. 
//
// Example: 
//
// Given matrix: 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// Given target = 5, return true. 
//
// Given target = 20, return false. 
// Related Topics 双指针 二分查找 分治算法 
// 👍 15 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

public class SortedMatrixSearchLcci {
    public static void main(String[] args) {
        Solution solution = new SortedMatrixSearchLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int m = matrix.length, n = matrix[0].length;
            int i = 0, j = n - 1;
            while (i < m && j >= 0) {
                if (matrix[i][j] > target) {
                    j--;
                } else if (matrix[i][j] < target) {
                    i++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}