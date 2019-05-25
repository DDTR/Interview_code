import java.util.*;
/**
 * 给定一个字符类型的数组chs[],chs右半区全是空字符，左半区不含空字符，
 * 现在将左半区中的所有空格字符替换成“%20”
 * 要求
 * 时间复杂度：O(N),空间复杂度O(1)
 * 补充题目：
 * chs只含有数字字符和“*”字符，现在想把所有的“*”字符挪到chs的左边，数字
 * 字符挪到chs的右边
 */
public class Modify{
    //问题1
    public static void modify1(char[] chs){
        if(chs==null||chs.length==0){
            return;
        }
        int len = 0;
        int num = 0;
        for(;len<chs.length&&chs[len]!=0;len++){
            if(chs[len]==' '){
                num++;
            }
        }
        int j = len + 2*num - 1;
        for(int i=len-1;i>=0;i--){
            if(chs[i]!=' '){
                chs[j--] = chs[i];
            }else{
                chs[j--] = '0';
                chs[j--] = '2';
                chs[j--] = '%';
            }
        }
    }
    //问题2
    public static void modify2(char[] chs){
        if(chs==null||chs.length==0){
            return;
        }
        int index = chs.length - 1;
        for(int i=chs.length-1;i>=0;i--){
            if(chs[i]!='*'){
                chs[index--] = chs[i];
            }
        }
        for(;index>=0;index--){
            chs[index] = '*';
        }
    }
    public static void main(String[] args){
        char[] chs1 = new char[]{'a', ' ', 'b', ' ', 'c', 0, 0, 0, 0, 0};
        String str = "12**34*3";
        char[] chs2 = str.toCharArray();
        modify1(chs1);
        modify2(chs2);
        System.out.println(chs1);
        System.out.println();
        System.out.println(chs2);

    }
}