package DS;

/**
 * For the find operation, in the worst-case scenario, when we repeatedly union components of equal rank, 
 * the tree height will be at most log(N)+1, so the find operation requires O(logN) time.
 * For the union and connected operations, we also need O(logN) time since these operations are dominated by 
 * the find operation.
 */
public class UnionByRank {
    private int[] root;
    private int[] rank;

    UnionByRank(int size){
        root = new int[size];
        rank = new int[size];

        for(int i = 0 ; i < size ; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        while(x != root[x]){
            x = root[x];
        }

        return x;
    }

    public void union(int x , int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if (rank[rootX] < root[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean find(int x , int y){
        return find(x) == find(y);
    }
}
