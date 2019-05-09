import java.util.*;
/**
 * 将单链表按某值划分成左边小，中间相等，右边大的形式
 */
public class ListPartition{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    //相对顺序变化，时间复杂度O(N),空间复杂度O(N)
    public Node listPartition1(Node head, int pivot){
        if(head==null||head.next==null) return head;
        int len = 0;
        Node curNode = head;
        while(curNode!=null){
            len++;
            curNode = curNode.next;
        }
        Node[] arr = new Node[len];//保存所有节点
        curNode = head;
        for(int i=0;i<len;i++){
            arr[i] = curNode;
            curNode = curNode.next;
        }
        partition(arr, pivot);
        for(int i=0;i<len-1;i++){
            arr[i].next = arr[i+1];
        }
        arr[len-1].next = null;
        return arr[0];

    }
    //相对顺序不变，时间复杂度O(N),空间复杂度O(1)
    public Node listParttion2(Node head, int pivot){
        if(head==null||head.next==null) return pivot;
        Node sH = null;//small head
        Node sT = null;//small tail
        Node eH = null;//equal head
        Node eT = null;//equal tail
        Node bH = null;//equal head
        Node bT = null;//equal tail
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = null;//需要将node 割裂开
            if(head.val<pivot){
                if(sH==null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = sT.next;
                }
            }else if(head.val==pivot){
                if(eH==null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = eT.next;
                }
            }else{
                if(bH==null){
                    bH = head;
                    bT = head;
                }else{
                    bT.next = head;
                    bT = bT.next;
                }
            }
            head = next;
        }
        if(sT!=null){ 
            sT.next = eH;
            eT = eT==null?sT:eT;//秀的不行
        }
        if(eT!=null){
            eT.next = bH;
        }
        return sH!=null?sH:eH!=null?eH:bH;

    }
    public void partition(Node[] arr, int pivot){
        int small = -1;
        int big = arr.length;
        int index = 0;
        while(index!=big){
            if(arr[index].val<pivot){
                swap(arr, ++small, index++);
            }else if(arr[index].val==pivot){
                index++;
            }else{
                swap(arr, --big, index);
            }
        }
    }
    public void swap(Node[] arr, int i, int j){
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}