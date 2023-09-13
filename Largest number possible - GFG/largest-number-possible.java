//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
        StringBuffer buff=new StringBuffer("");
        if(S>N*9||(N>1&&S==0)) {
            buff.append("-1");
            return buff.toString();
        }
        int sum=0;
        while(N>0){
            if(S>=9){
                buff.append("9");
                S-=9;
            }else if(S>=1&&S<9){
                buff.append(S);
                S=0;
            }else{
                buff.append("0");
            }
            N--;
        }
        return buff.toString();
    }
}