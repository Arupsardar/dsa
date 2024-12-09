package Solution;

import strucher.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1=l1;
        ListNode c2=l2;
        ListNode head =new ListNode(0);
        int crry =0;
        ListNode crr=head;
        while(c1 !=null && c2 !=null){
            int sum =c1.val+c2.val+crry;
            ListNode cr =new ListNode(sum%10);
            if(sum>9){
                crry =sum/10;
            }else{
               crry =0; 
            }
            crr.next=cr;
            crr=crr.next;
            c1=c1.next;
            c2=c2.next;
        }
        while(c1 !=null){
            int sum =c1.val+crry;
            ListNode cr =new ListNode(sum%10);
            if(sum>9){
                crry =sum/10;
            }else{
                crry=0;
            }
            crr.next=cr;
            crr=crr.next;
            c1=c1.next;
            
        }
        while(c2 !=null){
            int sum =c2.val+crry;
            ListNode cr =new ListNode(sum%10);
            if(sum>9){
                crry =sum/10;
            }else{
               crry =0; 
            }
            crr.next=cr;
            crr=crr.next;
            c2=c2.next;
        }
        if(crry !=0){
           ListNode cr =new ListNode(crry);
           crr.next=cr;
            crr=crr.next; 
        }

        return head.next;
    }
}
