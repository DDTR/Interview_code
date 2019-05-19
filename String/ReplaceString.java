import java.util.*;
/**
 * 给定字符串str, from和to, 已知from字符串中无重复字符，把str中所有的from字串替换成to字串，对于连续
 * 出现from部分只要替换成一个to字符串
 */
public class ReplaceString{
    public static String replace(String str, String from, String to){
        if(str==null||str.equals("")||from==null||from.equals("")){
            return str;
        }
        char[] chs = str.toCharArray();
        char[] chf = from.toCharArray();
        int match = 0;
        for(int i=0;i<chs.length;i++){
            if(chs[i]==chf[match++]){
                if(match==chf.length){
                    clear(chs, i, chf.length);
                    match = 0;
                }
            }else{
                if(chs[i]==chf[0]){
                    i--;
                }
                match = 0;
            }
        }
        String res = "";
        String cur = "";
        for(int i=0;i<chs.length;i++){
            if(chs[i]!=0){
                cur = cur + String.valueOf(chs[i]);
            }
            if(chs[i]==0&&(i==0||chs[i-1]!=0)){
                res = res + cur + to;
                cur = "";
            }
        }
        if(!cur.equals("")){
            res = res + cur;
        }
        return res;
    }
    public static void clear(char[] chs, int index, int len){
        while(len--!=0){
            chs[index--] = 0;
        }
    }
    public static void main(String[] args){
        String str = "123abdabd1";
        String from = "a";
        String to = "4567";
        System.out.println(replace(str, from, to));
    }
}