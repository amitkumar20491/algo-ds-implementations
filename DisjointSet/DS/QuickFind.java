package DSImplementation;

/* 
 * Implementation with Quick Find: in this case, the time complexity of the find function will be O(1)
 * However, the union function will take more time with the time complexity of O(N).
*/

public class QuickFind{
    private int[] root;

    public QuickFind(int size){
        root = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
        }
    }

    public int find(int x){
        return root[x];
    }

    public void union(int x , int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            for(int i= 0 ; i < root.length; i++){
                if(root[i] == rootY){
                    root[i] = rootX;
                }
            }
        }
    }

    boolean isConnected(int x , int y){
        return find(x) == find(y);
    }
}

