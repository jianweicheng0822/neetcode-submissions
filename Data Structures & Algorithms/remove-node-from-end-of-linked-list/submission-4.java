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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        cur = dummy;
        int steps = count - n;
        while(steps > 0){
            cur = cur.next;
            steps--;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
