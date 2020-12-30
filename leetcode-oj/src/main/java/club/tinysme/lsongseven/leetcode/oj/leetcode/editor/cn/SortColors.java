//Given an array nums with n objects colored red, white, or blue, sort them in-p
//lace so that objects of the same color are adjacent, with the colors in the orde
//r red, white, and blue. 
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white,
// and blue respectively. 
//
// Follow up: 
//
// 
// Could you solve this problem without using the library's sort function? 
// Could you come up with a one-pass algorithm using only O(1) constant space? 
// 
//
// 
// Example 1: 
// Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// Example 2: 
// Input: nums = [2,0,1]
//Output: [0,1,2]
// Example 3: 
// Input: nums = [0]
//Output: [0]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is 0, 1, or 2. 
// 
// Related Topics 排序 数组 双指针 
// 👍 741 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int slow = 0;

            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    temp = nums[slow];
                    nums[slow] = nums[i];
                    nums[i] = temp;
                    slow++;
                }
            }
            for (int i = slow; i < nums.length; i++) {
                if (nums[i] == 1) {
                    temp = nums[slow];
                    nums[slow] = nums[i];
                    nums[i] = temp;
                    slow++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}