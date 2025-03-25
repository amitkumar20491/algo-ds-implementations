package Graph.DFS.Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * LeetCode - https://leetcode.com/problems/find-if-path-exists-in-graph/
 */
public class FindIfPathExist {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (node == destination) {
                return true;
            }

            for (int nextNode : graph.get(node)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    stack.push(nextNode);
                }
            }
        }
        return false;
    }
}
