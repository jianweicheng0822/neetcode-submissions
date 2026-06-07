/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
Input : array of linked lists sorted in asecending order

Output: merge the linked list and return the sorted linked list

Examples:
 lists = [[1,2,4],[1,3,5],[3,6]]

 1 -> 1-> 2-> 3-> 3-> 4 -> 5 -> 6


Using PriorityQueue as min-heap to add each head of linked list, and create a sorted linked list by dummynode and add each of node one by one(pq.poll()).


*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         //Edge case
         if(lists == null || lists.length ==0){
           return null;
         }
         //Sort the linked list
         PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
         for(ListNode n : lists){
            while(n != null){
                pq.offer(n);
                n = n.next;
            }
         }
         //Create a linked list
         ListNode dummy = new ListNode(-1);
         ListNode cur = dummy;
         while(!pq.isEmpty()){
            ListNode n = pq.poll();
            cur.next = n;
            cur = cur.next;
         }
         return dummy.next;
    }
}
