//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int[] freq = new int[128]; // Array to store character frequencies
        int cnt = 0; // Count of unique characters in the current window
        int l = 0, max = 0;

        for (int i= 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 0) {
                cnt++;
            }
            freq[s.charAt(i)]++;

            while (cnt > k) {
                freq[s.charAt(l)]--;
                if (freq[s.charAt(l)] == 0) {
                    cnt--;
                }
                l++;
            }

            max = Math.max(max, i - l + 1);
        }

        if (max < k) return -1;
        return max;
    }
}