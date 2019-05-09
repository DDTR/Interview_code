import java.util.*;
/**
 * 判断一个链表是否为回文结构
 */
public class IsPalindrome{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    //解法1，链表全部放入stack中
    public boolean isPalindrome1(Node head){
        if(head==null||head.next==null) return true;
        Stack<Node> stack = new Stack<>();
        Node curNode = head;
        while(curNode!=null){
            stack.push(curNode);
            curNode = curNode.next;
        }
        while(!stack.isEmpty()){
            if(head.val!=stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    //解法2，一半链表放入stack中
    public boolean isPalindrome2(Node head){
        if(head==null||head.next==null) return true;
        Stack<Node> stack = new Stack<>();
        Node rightNode = head;
        Node curNode = head;
        while(curNode.next!=null||curNode.next.next!=null){
            rightNode = rightNode.next;
            curNode = curNode.next.next;
        }
        rightNode = rightNode.next;//需要注意
        while(rightNode!=null){
            stack.push(rightNode);
        }
        while(!stack.isEmpty()){
            if(head.val!=stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    //解法3，右半部分链表反转，666
    public boolean isPalindrome3(Node head){
        if(head==null||head.next==null) return true;
        //Stack<Node> stack = new Stack<>();
        Node n1 = head;//slow
        Node n2 = head;//fast
        while(n2.next!=null&&n2.next.next!=null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        Node n3 = n1.next;//右半部分节点的开始节点
        n1.next = null;
        //反转右半部分节点
        while(n3!=null){
            n2 = n3.next;
            n3.next = n1;
            n1 = n3;
            n3 = n2;
        }
        boolean res = true;
        n3 = head;
        n2 = n1;//保留最后一个节点
        while(n1!=null&&n3!=null){
            if(n1.val!=n3.val){
                res = false;
                break;
            }
            n1 = n1.next;
            n3 = n3.next;
        }
        //恢复链表
        n1 = null;
        while(n2!=null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        return res;
    }
}