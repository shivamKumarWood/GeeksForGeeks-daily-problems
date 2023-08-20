//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int l=0,h=n-1,mid=0;
        while(l<=h){
            mid=(l+h)/2;
            if(arr[mid]<x){
                l=mid+1;
            }else if(arr[mid]>x){
                h=mid-1;
            }else break;
        }
        int count=0;
        l=mid;
        while(l>=0&&arr[l]==x) {
            count++;
            l--;
        }
        h=mid+1;
        while(h<n&&arr[h]==x){
            count++;
            h++;
        }
        return count;
    }
}