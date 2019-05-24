import java.util.*;
/**
 * 给定字符类型数组chs[], 判断chs照片是否所有的字符只出现过一次，根据以下不同的两种要求
 * 实现两个函数
 * 要求1：时间复杂度O(N)
 * 要求2：空间复杂度O(1),时间复杂度尽量低
 */
public class IsUnique{
    public static boolean isUnique1(char[] chs){
        if(chs==null||chs.length==0){
            return true;
        }
        boolean[] map = new boolean[256];
        for(int i=0;i<chs.length;i++){
            if(map[chs[i]]){
                return false;
            }
            map[chs[i]] = true;
        }
        return true;
    }
    public static boolean isUnique(char[] chs){
        if(chs==null||chs.length==0){
            return true;
        }
        heapSort(chs);
        for(int i=1;i<chs.length;i++){
            if(chs[i]==chs[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void heapSort(char[] chs){
        for(int i=0;i<chs.length;i++){
            heapInsert(chs, i);
        }
        for(int i=chs.length-1;i>=0;i--){
            swap(chs, 0, i);
            heapfiy(chs, 0, i);
        }
    }
    public static void heapInsert(char[] chs, int i){
        int parent = 0;
        while(i!=0){
            parent = (i-1) / 2;
            if(chs[parent]<chs[i]){
                swap(chs, parent, i);
                i = parent;
            }else{
                break;
            }
        }
    }
    public static void swap(char[] chs, int i, int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
    public static void heapfiy(char[] chs, int i, int size){
        int left = i*2+1;
        int right = i*2+2;
        int large = i;
        while(left<size){
            if(chs[left]>chs[i]){
                //swap(chs, left, i);
                large = left;
            }
            if(right<size&&chs[right]>chs[large]){
                //swap(chs, large, right);
                large = right;
            }
            if(large!=i){
                swap(chs, large, i);
            }else{
                break;
            }
            i = large;
            left = i*2+1;
            right = i*2+2;
        }
    }
    public static void main(String[] args){
        char[] chs = new char[]{
            'a', 'b', 'c', 'a'
        };
        System.out.println(isUnique1(chs));
        System.out.println(isUnique1(chs));
    }
}
