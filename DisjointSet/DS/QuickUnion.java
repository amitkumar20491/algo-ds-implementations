package DSImplementation;

/*
 * Implementation with Quick Union: compared with the Quick Find implementation, the time complexity of the union 
 * function is better. Meanwhile, the find function will take more time in this case O(N).
 */
public class QuickUnion {
    private int[] root;

    QuickUnion(int size){
        root = new int[size];
        for(int i = 0; i < size ; i++){
            root[i] = i;
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
            root[rootY] = rootX;
        }
    }

    public boolean isConnected(int x , int y){
        return find(x) == find(y);
    }
}
