//Design the CombinationIterator class:
//
// 
// CombinationIterator(string characters, int combinationLength) Initializes the
// object with a string characters of sorted distinct lowercase English letters an
//d a number combinationLength as arguments. 
// next() Returns the next combination of length combinationLength in lexicograp
//hical order. 
// hasNext() Returns true if and only if there exists a next combination. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext
//"]
//[["abc", 2], [], [], [], [], [], []]
//Output
//[null, "ab", true, "ac", true, "bc", false]
//
//Explanation
//CombinationIterator itr = new CombinationIterator("abc", 2);
//itr.next();    // return "ab"
//itr.hasNext(); // return True
//itr.next();    // return "ac"
//itr.hasNext(); // return True
//itr.next();    // return "bc"
//itr.hasNext(); // return False
// 
//
// 
// Constraints: 
//
// 
// 1 <= combinationLength <= characters.length <= 15 
// All the characters of characters are unique. 
// At most 104 calls will be made to next and hasNext. 
// It's guaranteed that all calls of the function next are valid. 
// 
// Related Topics 设计 回溯算法 
// 👍 35 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

public class IteratorForCombination {
    public static void main(String[] args) {
        CombinationIterator solution = new IteratorForCombination().new CombinationIterator("ab", 3);
        while (solution.hasNext()) {
            System.out.println(solution.next());
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CombinationIterator {

        String characters;
        int[] pointers;
        int combinationLength;
        boolean full = false;

        public CombinationIterator(String characters, int combinationLength) {
            this.characters = characters;
            this.combinationLength = combinationLength;
            this.pointers = new int[combinationLength];
            for (int i = 0; i < combinationLength; ++i) {
                pointers[i] = i;
            }
        }

        public String next() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pointers.length; ++i) {
                sb.append(characters.charAt(pointers[i]));
            }
            boolean updated = false;
            for (int i = pointers.length - 1; i >= 0; --i) {
                if (pointers[i] < characters.length() - (pointers.length - i)) {
                    pointers[i]++;
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                full = true;
            }

            return sb.toString();
        }

        public boolean hasNext() {
            return !full && characters.length() - combinationLength >= pointers[0];
        }
    }

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}