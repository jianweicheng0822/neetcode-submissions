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

Input: a signgly linked list head, a integer k 

keep reversing the k nodes until there are few k nodes left.

Output: return modifies list 

Input: head = [1,2,3,4,5,6], k = 3

Output: [3,2,1,6,5,4]

-1->1->2->3->4->5->6
          k
          c
 -1 ->3 2 1->4->5->6

*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //Edge case
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(true){
            ListNode kth = find(cur, k);
            if(kth == null){
               break;
            }
            ListNode next = kth.next;// 4 5 6
            ListNode group = cur.next; // 1 
            cur.next = reverse(group, next);
            cur = group;
            cur.next = next;
        
        }
        return dummy.next;
    }
    private ListNode find(ListNode n, int k){
        while(n!= null && k > 0){
            n = n.next;
            k--;
        }
        return n;
    }
    private ListNode reverse(ListNode n, ListNode k){
        ListNode prev = null;
        while(n != k){
 // 1 2 3
         ListNode next = n.next;
          n.next = prev;// 1 -> null
          prev = n;
          n = next;
        }
        return prev;
    }
  
    
}
