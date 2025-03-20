package Problems;

import DS.OptimizedUnionFindCycleCheck;

/**
 * https://leetcode.com/problems/graph-valid-tree/editorial/
 */
public class ValidGraphTree {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }
        
        OptimizedUnionFindCycleCheck djs = new OptimizedUnionFindCycleCheck(n);
        
        for(int[] edge : edges){
            if(!djs.union(edge[0] ,edge[1])){
                return false;
            }
        }
        
        return true;
    }
}
