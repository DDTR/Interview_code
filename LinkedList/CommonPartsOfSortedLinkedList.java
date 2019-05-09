import java.util.*;
/*
给定两个有序链表头指针，打印两个链表的公共部分
*/
public class CommonPartsOfSortedLinkedList{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public void printCommonPart(Node head1, Node head2){
        System.out.println("Common Parts: ");
        if(head1==null||head2==null){
            System.out.println("NULL");
            return;
        }
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                head1 = head1.next;
            }else if(head1.val>head2.val){
                head2 = head2.next;
            }else{
                System.out.print(haed1.val+" ");//两个链表可能只是中间部分值相同，如1->2->5->7->8和2->7->8
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}