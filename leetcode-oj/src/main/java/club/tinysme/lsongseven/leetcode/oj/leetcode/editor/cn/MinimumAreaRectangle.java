//Given a set of points in the xy-plane, determine the minimum area of a rectang
//le formed from these points, with sides parallel to the x and y axes. 
//
// If there isn't any rectangle, return 0. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
//Output: 4
// 
//
// 
// Example 2: 
//
// 
//Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
//Output: 2
// 
//
// 
//
// Note: 
//
// 
// 1 <= points.length <= 500 
// 0 <= points[i][0] <= 40000 
// 0 <= points[i][1] <= 40000 
// All points are distinct. 
// 
// 
// Related Topics 哈希表 
// 👍 64 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {
    public static void main(String[] args) {
        Solution solution = new MinimumAreaRectangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAreaRect(int[][] points) {
            Set<Integer> pointSet = new HashSet<Integer>();
            for (int[] point : points) {
                pointSet.add(point[0] * 40001 + point[1]);
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < points.length; ++i) {
                for (int j = i + 1; j < points.length; ++j) {
                    if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                        if (pointSet.contains(points[i][0] * 40001 + points[j][1]) && pointSet.contains(points[j][0] * 40001 + points[i][1])) {
                            ans = Math.min(ans, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                        }
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}