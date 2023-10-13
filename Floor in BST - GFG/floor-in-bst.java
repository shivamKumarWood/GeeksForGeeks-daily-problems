//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class GFG {

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) {
            return new Node(val);
        }

        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }

        return tree;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Node root = null;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                root = insert(root, k);
            }

            int s = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.floor(root, s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private static int min;
    private static int res;
    public static int floor(Node root, int x) {
        // Code here
        min=Integer.MAX_VALUE;
        res=-1;
        if(root==null) return -1;
        recursive(root,x);
        return res;
    }
    public static void recursive(Node root,int x){
        if(root==null){
            return;
        }
        if(root.data==x){
            res=root.data;
            return;
        }
        if(root.data>x){
            recursive(root.left,x);
        }else if(root.data<x){
            if(Math.abs(root.data-x)<min){
                min=Math.abs(root.data-x);
                res=root.data;
            }
            recursive(root.right,x);
        }
    }
}