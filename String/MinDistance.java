import java.util.*;
/**
 * 给定字符串数组strs,再给定两个字符串str1和str2，返回
 * strs中str1和str2的最小距离，如果str1或者str2为null
 * 或者不在strs中，返回-1
 */
public class MinDistance{
    public static int minDistance(String[] strs, String str1, String str2){
        if(str1==null||str2==null||strs==null||strs.length==0){
            return -1;
        }
        if(str1.equals(str2)){
            return 0;
        }
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals(str1)){
                min = index2==-1?min:i-index2;
                index1 = i;
            }else if(strs[i].equals(str2)){
                min = index1==-1?min:i-index1;
                index2 = i;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
    public static void main(String[] args){
        String[] strs = new String[]{"1", "3", "3", "3", "2", "3", "1"};
        String str1 = "1";
        String str2 = "-1";
        System.out.println(minDistance(strs, str1, str2));
    }
}