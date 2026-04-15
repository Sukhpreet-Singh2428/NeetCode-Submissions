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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        ListNode next = null;
        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);
        if(n==1){
            head = head.next;
            return reverse(head);
        }
        int cnt = 1;
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            if(cnt==n){
                prev.next = temp.next;
                break;
            }
            cnt++;
            prev = temp;
            temp = temp.next;
        }

        head = reverse(head);

        return head;
    }
}
