import java.util.*;
/**
 * 两个单链表相加生成相加链表
 */
public class AddList{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    //借助栈实现
    public Node addList1(Node head1, Node head2){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        while(head1!=null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while(head2!=null){
            stack2.push(head2);
            head2 = head2.next;
        }
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        int add = 0;//进位
        Node pre = null;
        Node cur = null;
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            n1 = stack1.isEmpty()?0:stack1.pop().val;
            n2 = stack2.isEmpty()?0:stack2.pop().val;
            n = n1 + n2 + add;
            pre = cur;
            cur = new Node(n%10);
            cur.next = pre;
            add = n/10;
        }
        if(add==1){
            pre = cur;
            cur = new Node(1);
            cur.next = pre;
        }
        return cur;
    }
    //不借助栈，自身反转链表
    public Node addList2(Node head1, Node head2){
        Node reverseHead1 = reverse(head1);
        Node reverseHead2 = reverse(head2);
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        int add = 0;
        Node pre = null;
        Node cur = null;
        head1 = reverseHead1;//保存节点，后面将链表恢复
        head2 = reverseHead2;
        while(reverseHead1!=null||reverseHead2!=null){
            n1 = reverseHead1==null?0:reverseHead1.val;
            n2 = reverseHead2==null?0:reverseHead2.val;
            n = n1 + n2 + add;
            pre = cur;
            cur = new Node(n%10);
            cur.next = pre;
            add = n / 10;
            reverseHead1 = reverseHead1.next;
            reverseHead2 = reverseHead2.next;
        }
        if(add==1){
            pre = cur;
            cur = new Node(1);
            cur.next = pre;
        }
        head1 = reverse(head1);
        head2 = reverse(head2);
        return cur;
    }
    //反转链表
    public Node reverse(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}