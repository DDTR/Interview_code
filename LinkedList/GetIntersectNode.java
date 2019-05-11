import java.util.*;
/**
 * 给定两个单链表的头节点head1和head2，该两个链表可能有环，可能相交也可能不相交，如果相交返回相交的第一个节点
 * 否则返回null
 */
public class GetIntersectNode{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    //返回链表入环节点，如果没有环返回null
    public Node getLoopNode(Node head){
        if(head==null||head.next==null||head.next.next==null) return null;
        Node slow = head.next;
        Node fast = head.next.next;
        while(slow!=fast){
            if(fast.next==null||fast.next.next==null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //判断没有环的两个单链表是否相交
    public Node getIntersectNodeWithNoLoop(Node head1, Node head2){
        if(head1==null||head2==null) return null;
        Node node1 = head1;
        Node node2 = head2;
        int n = 0;
        while(node1.next!=null){
            n++;
            node1 = node1.next;
        }
        Node end1 = node1;
        while(node2.next!=null){
            n--;
            node2 = node2.next;
        }
        Node end2 = node2;
        if(end1!=end2){
            return null;
        }
        //node1 复值给较长的那个链表头节点
        node1 = n>0?head1:head2;
        node2 = n>0?head2:head1;
        n = Math.abs(n);
        while(n!=0){
            n--;
            node1 = node1.next;
        }
        while(node1!=node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
    //判断有环的两个单链表是否相交
    public Node getIntersectNodeWithLoop(Node head1, Node head2, Node loopNode1, Node loopNode2){
        if(head1==null||head2==null) return null;
        Node node1 = null;
        Node node2 = null;
        if(loopNode1==loopNode2){
            node1 = head1;
            node2 = head2;
            int n = 0;
            while(node1!=loopNode1){
                n++;
                node1 = node1.next;
            }
            while(node2!=loopNode2){
                n--;
                node2 = node2.next;
            }
            node1 = n>0?head1:head2;
            node2 = n>0?head2:head1;
            n = Math.abs(n);
            while(n!=0){
                n--;
                node1 = node1.next;
            }
            while(node1!=node2){
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        }else{
            node1 = loopNode1.next;
            node2 = loopNode2;
            while(node1!=loopNode1){
                if(node1==node2){
                    return node1;
                }
                node1 = node1.next;
            }
            return null;
        }
    }

    public Node getIntersectNode(Node head1, Node head2){
        if(head1==null||head2==null){
            return null;
        }
        Node loopNode1 = getLoopNode(head1);
        Node loopNode2 = getLoopNode(head2);
        if(loopNode1==null&&loopNode1==null){
            return getIntersectNodeWithNoLoop(head1, head2);
        }else if(loopNode1!=null&&loopNode2!=null){
            return getIntersectNodeWithLoop(head1, head2, loopNode1, loopNode2);
        }else{
            return null;
        }
    }
}