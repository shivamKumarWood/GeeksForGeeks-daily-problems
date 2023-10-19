//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    private int res;
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        res=-1;
        bfs(adj,X,V);
        return res;
    }
    public void bfs(ArrayList<ArrayList<Integer>>adj,int X,int V){
        boolean[] vis=new boolean[V];
        vis[0]=true;
        int cnt=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
              int temp=q.poll();
               if(temp==X){
                  res=cnt;
                  return;
               }

             for(int i=0;i<adj.get(temp).size();i++){
                int neighbour=adj.get(temp).get(i);
                if(neighbour==X){
                    res=cnt+1;
                    return;
                }
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    q.add(neighbour);
                }
             }
            }
            cnt++;
        }
    }
}