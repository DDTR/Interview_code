import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;
/**
 * 返回str的统计字符串
 */
public class GetCountString{
    public static String getCountString(String str){
        if(str==null||str.equals("")){
            return "";
        }
        char[] chs = str.toCharArray();
        String res = String.valueOf(chs[0]);
        int count = 1;
        char cur = chs[0];
        for(int i=1;i<chs.length;i++){
            if(cur!=chs[i]){
                res = res + "_" + count + "_" + chs[i];
                count = 1;
                cur = chs[i];
            }else{
                count++;
            }
        }
        res = res + "_" + count;
        return res;
    }
    public static char getCharAt(String cstr, int index){
        if(cstr==null||cstr.equals("")||index<0){
            return 0;
        }
        boolean flag = true;
        int sum = 0;
        int count = 0;
        char[] chs = cstr.toCharArray();
        char cur = chs[0];
        for(int i=1;i<chs.length;i++){
            if(chs[i]=='_'){
                flag = !flag;
            }else if(flag){
                sum +=count;
                if(sum>index){
                    return cur;
                }
                cur = chs[i];
                count = 0;
            }else{
                count = count*10 + chs[i] - '0';
            }
        }
        return sum+count>index?cur:0;
    }
    public static void main(String[] args){
        String str = "aaabbadddffc";
        String cstr = getCountString(str);
        int index = -1;
        char theChar = getCharAt(cstr, index);
        System.out.println(cstr);
        System.out.println(theChar);
    }
}