//Given two arrays of integers, find a pair of values (one value from each array
//) that you can swap to give the two arrays the same sum. 
//
// Return an array, where the first element is the element in the first array th
//at will be swapped, and the second element is another one in the second array. I
//f there are more than one answers, return any one of them. If there is no answer
//, return an empty array. 
//
// Example: 
//
// 
//Input: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
//Output: [1, 3]
// 
//
// Example: 
//
// 
//Input: array1 = [1, 2, 3], array2 = [4, 5, 6]
//Output: [] 
//
// Note: 
//
// 
// 1 <= array1.length, array2.length <= 100000 
// 
// Related Topics 排序 数组 
// 👍 16 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class SumSwapLcci {
    public static void main(String[] args) {
        Solution solution = new SumSwapLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findSwapValues(int[] array1, int[] array2) {
            /**
             * 1 2 3 -> 6
             * 4 5 6 -> 15
             * diff -> 9
             */
            int sa = 0, sb = 0;
            Set<Integer> sbSet = new HashSet<>();
            for (int a1 : array1) {
                sa += a1;
            }
            for (int a2 : array2) {
                sb += a2;
                sbSet.add(a2);
            }
            int diff = sa - sb;
            if (diff % 2 != 0) {
                return new int[]{};
            }
            int halfDiff = diff / 2;
            for (int i = 0; i < array1.length; i++) {
                if (sbSet.contains(array1[i] - halfDiff)) {
                    return new int[]{array1[i], array1[i] - halfDiff};
                }
            }
            return new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}