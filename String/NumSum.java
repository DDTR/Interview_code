import java.util.*;
/**
 * 字符串数字子串求和
 */
public class NumSum{
    public static int numSum(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        int res = 0;
        int cur = 0;
        int num = 0;
        int flag = 1;
        char[] chs = str.toCharArray();
        for(int i=0;i<chs.length;i++){
            cur = chs[i] - '0';
            if(cur>=0&&cur<=9){
                num = num*10+flag*cur;
            }else{
                res = res + num;
                num = 0;
                if(i>1&&chs[i-1]=='-'){
                    flag = -flag;
                }else{
                    flag = -1;
                }
            }
        }
        res = res + num;
        return res;
    }
    public static void main(String[] args){
        String str = "-12";
        System.out.println(numSum(str));
    }
}