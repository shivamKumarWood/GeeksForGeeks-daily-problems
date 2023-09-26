//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        int n=arr.length;
        if(n<4) return list;
        Arrays.sort(arr);
        
        for(int i=0;i<n-3;i++){
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int first=arr[i];
            for(int j=i+1;j<n-2;j++){
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int second=arr[j];
                int l=j+1,r=n-1;
                while(l<r){
                    if (l > j+ 1 && arr[l] == arr[l - 1]) { 
                        l++;
                        continue;
                    }
                    if (r < n-1 && arr[r] == arr[r+1]) {
                        r--;
                        continue;
                    }
                    if(first+second+arr[l]+arr[r]<k){
                        l++;
                    }
                    else if(first+second+arr[l]+arr[r]>k){
                        r--;
                    }else{
                        ArrayList<Integer>ll=new ArrayList<>();
                        ll.add(first);
                        ll.add(second);
                        ll.add(arr[l]);
                        ll.add(arr[r]);
                        list.add(ll);
                        l++;r--;
                    }
                }
            }
        }
        return list;
    }
}