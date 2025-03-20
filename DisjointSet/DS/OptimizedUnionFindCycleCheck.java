package DS;

/*
 * This is a combination of UnionByRank which optimize Union and Path Compression which optmizied Find.
 * N is the number of vertices in the graph. α refers to the Inverse Ackermann function. In practice, 
 * we assume it's a constant.In other words, O(α(N)) is regarded as O(1) on average.
 * 
 * When using the combination of union by rank and the path compression optimization, the find operation will take O(α(N))
 *  time on average.Since union and connected both make calls to find and all other operations require constant time, 
 * union and connected functions will also take O(α(N)) time on average.
 */
public class OptimizedUnionFindCycleCheck {
    private int[] root;
    private int[] rank;

    public OptimizedUnionFindCycleCheck(int size){
        root = new int[size];
        rank = new int[size];

        for(int i = 0; i < size ; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(x == root[x]){
            return x;
        }

        return root[x] = find(root[x]);
    }

    public boolean union(int x , int y){
        if(connected(x , y)){
            return false;
        }
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if (rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }

        return true;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
