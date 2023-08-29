//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        // your code here
        if(head==null)  return null;
        Node cur=head;
        Node prev1=null;
        while(cur!=null){
            Node temp2=cur.next;
            cur.next=prev1;
            prev1=cur;
            cur=temp2;
        }
	    Node temp=prev1,temp1=prev1;
	    temp=temp.next;
	    int prev=prev1.data;
	    while(temp!=null){
	        if(temp.data>=prev){
	            temp1.next=temp;
	            temp1=temp1.next;
	            prev=temp1.data;
	        }
	        temp=temp.next;
	    }
	    temp1.next=null;
	    Node cur5=prev1;
        Node prev5=null;
        while(cur5!=null){
            Node temp5=cur5.next;
            cur5.next=prev5;
            prev5=cur5;
            cur5=temp5;
        }
	    return prev5;
    }
}
  