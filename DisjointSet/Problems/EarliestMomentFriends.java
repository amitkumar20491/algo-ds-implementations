package Problems;

import java.util.Arrays;
import DS.OptimizedUnionFind;
/**
 * Leetcode - https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 */
public class EarliestMomentFriends {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs , (a , b) -> Integer.compare(a[0] , b[0]));
        int connectedComponents = n;
        
        OptimizedUnionFind djs = new OptimizedUnionFind(n);
        
        for(int[] log : logs){
            if(!djs.connected(log[1] , log[2])){
                djs.union(log[1] , log[2]);
                connectedComponents--;
            }
            
            if(connectedComponents == 1){
                return log[0];
            }
        }
        
        return -1;
    }
}
