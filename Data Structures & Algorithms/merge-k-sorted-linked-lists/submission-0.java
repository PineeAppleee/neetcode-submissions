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
    public ListNode mergeKLists(ListNode[] lists) {
      if(lists.length==0) return null;
     return merge(lists,0,lists.length-1);
    }
    public ListNode mergeLinkedList(ListNode l1,ListNode l2){
      if(l1==null) return l2;
      if(l2==null) return l1;

      if(l1.val<l2.val){
        l1.next =  mergeLinkedList(l1.next,l2);
        return l1;
      }else{
        l2.next = mergeLinkedList(l1,l2.next);
        return l2;
      }
    }
    public ListNode merge(ListNode[] lists,int s,int e){
      if(s==e) return lists[s];

      int m = s+(e-s)/2;
      ListNode l1 = merge(lists,s,m);
      ListNode l2 = merge(lists,m+1,e);
      return mergeLinkedList(l1,l2);
      
    } 
     
}
