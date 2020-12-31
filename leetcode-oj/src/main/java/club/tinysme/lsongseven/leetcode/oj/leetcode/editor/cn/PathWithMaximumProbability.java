//You are given an undirected weighted graph of n nodes (0-indexed), represented
// by an edge list where edges[i] = [a, b] is an undirected edge connecting the no
//des a and b with a probability of success of traversing that edge succProb[i]. 
//
// Given two nodes start and end, find the path with the maximum probability of 
//success to go from start to end and return its success probability. 
//
// If there is no path from start to end, return 0. Your answer will be accepted
// if it differs from the correct answer by at most 1e-5. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0
//, end = 2
//Output: 0.25000
//Explanation: There are two paths from start to end, one having a probability o
//f success = 0.2 and the other has 0.5 * 0.5 = 0.25.
// 
//
// Example 2: 
//
// 
//
// 
//Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0
//, end = 2
//Output: 0.30000
// 
//
// Example 3: 
//
// 
//
// 
//Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
//Output: 0.00000
//Explanation: There is no path between 0 and 2.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 10^4 
// 0 <= start, end < n 
// start != end 
// 0 <= a, b < n 
// a != b 
// 0 <= succProb.length == edges.length <= 2*10^4 
// 0 <= succProb[i] <= 1 
// There is at most one edge between every two nodes. 
// Related Topics 图 
// 👍 42 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class PathWithMaximumProbability {
    public static void main(String[] args) {
        Solution solution = new PathWithMaximumProbability().new Solution();
        System.out.println(solution.maxProbability(500, new int[][]{{193,229},{133,212},{224,465}}, new double[]{0.91,0.78,0.64}, 4, 364));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

            Map<Integer, List<Pair<Double, Integer>>> graph = new HashMap<>();
            for (int i = 0; i < edges.length; ++i) {
                graph.computeIfAbsent(edges[i][0], point -> new ArrayList<>()).add(new Pair<>(succProb[i], edges[i][1]));
                graph.computeIfAbsent(edges[i][1], point -> new ArrayList<>()).add(new Pair<>(succProb[i], edges[i][0]));
            }
            double[] prob = new double[n];
            prob[start] = 1;
            Queue<Pair<Double, Integer>> queue = new LinkedBlockingQueue<>();
            queue.offer(new Pair<>(1.0, start));
            while (!queue.isEmpty()) {
                Pair<Double, Integer> pair = queue.poll();
                Double pr = pair.getKey();
                Integer currentPoint = pair.getValue();
                if (pr < prob[currentPoint]) {
                    continue;
                }
                List<Pair<Double, Integer>> nextPairs = graph.getOrDefault(currentPoint,new ArrayList<>());
                for (Pair<Double, Integer> nextPair : nextPairs) {
                    double nextPr = nextPair.getKey();
                    int nextPoint = nextPair.getValue();
                    if (prob[nextPoint] < prob[currentPoint] * nextPr) {
                        prob[nextPoint] = prob[currentPoint] * nextPr;
                        queue.offer(new Pair<>(prob[nextPoint], nextPoint));
                    }
                }
            }
            return prob[end];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}