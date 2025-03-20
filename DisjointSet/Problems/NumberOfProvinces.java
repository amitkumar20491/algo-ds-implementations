package Problems;

import DS.OptimizedUnionFind;
/**
 * Leetcode - https://leetcode.com/problems/number-of-provinces/description/
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        OptimizedUnionFind djs = new OptimizedUnionFind(n);
        int numberOfProvinces = n;

        for(int i = 0; i < n ; i++){
            for(int j = i +1 ; j < n ; j++){
                if(isConnected[i][j] == 1 && djs.find(i) != djs.find(j)){
                    numberOfProvinces--;
                    djs.union(i , j);
                }
            }
        }

        return numberOfProvinces;
    }
}

