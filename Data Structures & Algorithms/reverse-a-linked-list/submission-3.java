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
0->1->2->3
dummy->0->1->2->3
prev.  cur 

next : 1->2->3
prev = null points to cur
keep the pointer
cur = next
prev = cur;


*/
class Solution {
    public ListNode reverseList(ListNode head) {
         ListNode prev = null;
         ListNode cur = head;
         while(cur != null){
            ListNode next = cur.next;
            cur.next = prev; // 0->null
            prev = cur;
            cur = next;
         }
         return prev;
    }
}
