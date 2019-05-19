import java.util.*;
/**
 * 去掉字符串中连续K个0的子串
 */
public class RemoveKZeros{
    public static String removeKZeros(String str, int k){
        if(str==null||k<1){
            return str;
        }
        int start = -1;
        int count = 0;
        char[] chs = str.toCharArray();
        for(int i=0;i<chs.length;i++){
            if(chs[i]=='0'){
                count++;
                start = start==-1?i:start;
            }else{
                if(count==k){
                    while(count--!=0){
                        chs[start++] = '@'; // String.valueOf(str)会消除
                        //System.out.println(String.valueOf(chs));
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if(count==k){
            while(count--!=0){
                chs[start++] = '@';
            }
        }
        return String.valueOf(chs).replaceAll("@", "");
    }
    public static void main(String[] args){
        String str = "A0000BB000";
        int k = 3;
        System.out.println(removeKZeros(str, k));
    }
}