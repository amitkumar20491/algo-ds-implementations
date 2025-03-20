package Problems;

import DS.OptimizedUnionFind;
/**
 * Leetcode - https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 */
public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        int connectedComponents = n;
        
        OptimizedUnionFind djs = new OptimizedUnionFind(n);
        
        for(int[] edge : edges){
            if(!djs.connected(edge[0] ,edge[1])){
                djs.union(edge[0] ,edge[1]);
                connectedComponents--;
            }        
        }
        
        return connectedComponents;
    }
}
