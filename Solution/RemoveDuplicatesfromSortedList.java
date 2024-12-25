package Solution;

import strucher.ListNode;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode c1 =head;
        
        
        while(c1.next !=null){
            
            if(c1.val==c1.next.val){
                c1.next=c1.next.next;
            }else{
                c1=c1.next;
            }
        }
        return head;

    }
}
