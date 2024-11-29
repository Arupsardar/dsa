package Solution;

import strucher.ListNode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur =head;
        int count =0;
        while(cur != null){
            cur=cur.next;
            count++;
        }

        int step =count-n;

        if(step ==0){
            return head.next;
        }
        cur =head;
        for(int i=1;i<step;i++){
            cur =cur.next;
        }

        cur.next=cur.next.next;
        return head;
        
    }
}
