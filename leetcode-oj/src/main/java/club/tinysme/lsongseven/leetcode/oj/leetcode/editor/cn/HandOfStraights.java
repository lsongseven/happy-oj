//Alice has a hand of cards, given as an array of integers. 
//
// Now she wants to rearrange the cards into groups so that each group is size W
//, and consists of W consecutive cards. 
//
// Return true if and only if she can. 
//
// Note: This question is the same as 1296: https://leetcode.com/problems/divide
//-array-in-sets-of-k-consecutive-numbers/ 
//
// 
// Example 1: 
//
// 
//Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
//Output: true
//Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
// 
//
// Example 2: 
//
// 
//Input: hand = [1,2,3,4,5], W = 4
//Output: false
//Explanation: Alice's hand can't be rearranged into groups of 4.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= hand.length <= 10000 
// 0 <= hand[i] <= 10^9 
// 1 <= W <= hand.length 
// 
// Related Topics Ordered Map 
// 👍 85 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

import java.util.TreeMap;

public class HandOfStraights {
    public static void main(String[] args) {
        Solution solution = new HandOfStraights().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNStraightHand(int[] hand, int W) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int n : hand) {
                Integer integer = treeMap.getOrDefault(n, 0);
                treeMap.put(n, ++integer);
            }
            while (treeMap.size() > 0) {
                int k = treeMap.firstKey();
                for (int i = k; i < k + W; ++i) {
                    if (!treeMap.containsKey(i)) {
                        return false;
                    }
                    int v = treeMap.get(i);
                    if (v == 1) {
                        treeMap.remove(i);
                    } else {
                        treeMap.replace(i, v - 1);
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}