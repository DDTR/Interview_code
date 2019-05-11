import java.util.*;
/**
 * 给定单链表头节点head,使得每K个节点之间逆序，如果最后不够K个节点，则不调整最后几个节点
 */
class ReverseKNodes{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    //借助栈
    public Node reverseKNode1(Node head, int k){
        if(k<2){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node next = null;
        Node cur = head;
        Node pre = null;
        Node newHead = null;
        while(cur!=null){
            next = cur.next;
            stack.push(cur);
            if(stack.size()==k){
                pre = reverse1(stack, pre, next);
                //pre.next = cur;
                newHead = newHead==null?cur:newHead;
            }
            cur = next;
        }
        return newHead;
    }
    public Node reverse1(Stack<Node> stack, Node left, Node right){
        Node cur = stack.pop();
        if(left!=null){
            left.next = cur;
        }
        Node next = null;
        while(!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }
    //不借助栈
    public reverseKNode(Node head, int k){
        if(k<2){
            return head;
        }
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        Node newHead = null;
        int cnt = 1;
        while(cur!=null){
            next = cur.next;
            cnt++;
            if(cnt==k){
                start = pre==null?head:pre.next;
                head = pre==null?cur:head;
                reverse2(pre, start, cur, next);
                pre = start;
            }
            cur = next;
        }
        return newHead;
    }
    //未弄懂
    public void reverse2(Node left, Node start, Node end, Node right){
        Node pre = left;
        Node cur = start.next;
        Node next = null;
        while(cur!=right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(left!=null){
            left.next = end;
        }
        start.next = right;
    }
}