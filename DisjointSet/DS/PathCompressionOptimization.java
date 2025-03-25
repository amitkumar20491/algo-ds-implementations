package DS;

/*
 * For the find, union, and connected operations (the latter two operations both depend on the find operation), 
 * we need O(1) time for the best case (when the parent node for some vertex is the root node itself).
 * In the worst case, it would be O(N) time when the tree is skewed. However, on average, the time complexity 
 * will be O(logN)
 */
public class PathCompressionOptimization {
    private int[] root;

    PathCompressionOptimization(int size){
        root = new int[size];
        for(int i = 0; i < size ; i++){
            root[i] = i;
        }
    }

    public int find(int x){
        if(x == root[x]){
            return x;
        }

        return root[x] = find(root[x]);
    }

    public void union(int x , int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            root[rootY] = rootX;
        }
    }

    public boolean find(int x , int y){
        return find(x) == find(y);
    }
}
