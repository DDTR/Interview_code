import java.util.*;
/**
 * 单词逆序调整
 * 补充题目
 * 还给定一个整数size，把大小为size的左半区整体移到右半区
 */
public class RotationWord{
    public static void rotateWord(char[] chs){
        if(chs==null||chs.length==0){
            return;
        }
        reverse(chs, 0, chs.length-1);
        int l = -1;
        int r = -1;
        for(int i=0;i<chs.length;i++){
            if(chs[i]!=' '){
                l = i==0||chs[i-1]==' '?i:l;
                r = i==chs.length-1||chs[i+1]==' '?i:r;
            }
            if(l!=-1&&r!=-1){
                reverse(chs, l, r);
                l = -1;
                r = -1;
            }
        }
    }
    public static void reverse(char[] chs, int l, int r){
        char temp;
        while(l<r){
            temp = chs[r];
            chs[r] = chs[l];
            chs[l] = temp;
            l++;
            r--;
        }
    }
    //补充问题
    public static void rotation1(char[] chs, int size){
        if(chs==null||chs.length==0||size<=0||size>=chs.length){
            return;
        }
        reverse(chs, 0, size-1);
        reverse(chs, size, chs.length-1);
        reverse(chs, 0, chs.length-1);
    }
    public static void rotation2(char[] chs, int size){
        if(chs==null||chs.length==0||size<=0||size>=chs.length){
            return;
        }
        int start = 0;
        int end = chs.length-1;
        int lpart = size;
        int rpart = chs.length - size;
        int min = Math.min(lpart, rpart);
        int s = lpart - rpart;
        while(true){
            exchange(chs, start, end, min);
            if(s==0){
                break;
            }else if(s>0){
                start+=min;
                lpart = s;
            }else{
                end-=min;
                rpart = -s;
            }
            min = Math.min(lpart, rpart);
            s = lpart - rpart;
        }
    }
    public static void exchange(char[] chs, int start, int end, int size){
        int index = end - size + 1;
        char temp = 0;
        while(index<=end){
            temp = chs[index];
            chs[index] = chs[start];
            chs[start] = temp;
            start++;
            index++;
        }
    }
    public static void main(String[] args){
        String str1 = "dog loves pig";
        String str2 = "ABCDE";
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        rotateWord(chs1);
        rotation2(chs2, 3);
        System.out.println(String.valueOf(chs1));
        System.out.println(String.valueOf(chs2));
    }
}