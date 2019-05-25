import java.util.*;
/**
 * 给定一个字符串str,判断是不是整体有效的括号字符串
 * 补充问题：
 * 返回最长的有效括号字串长度
 */
public class IsValid{
    public static boolean isValid(String str){
        if(str==null||str.length()==0){
            return false;
        }
        char[] chs = str.toCharArray();
        int flag = 0;
        for(int i=0;i<chs.length;i++){
            if(chs[i]!='('&&chs[i]!=')'){
                return false;
            }else if(chs[i]==')'&&--flag<0){
                return false;
            }
            if(chs[i]=='('){
                flag++;
            }
        }
        return flag==0;
    }
    //进阶问题
    public static int maxLen(String str){
        if(str==null||str.equals("")){
            return 0;
        }
        char[] chs = str.toCharArray();
        int[] dp = new int[chs.length];
        int pre = 0;
        int res = 0;
        for(int i=1;i<chs.length;i++){
            if(chs[i]==')'){
                pre = i - dp[i-1] - 1;
                if(pre>=0&&chs[pre]=='('){
                    dp[i] = dp[i-1] + 2 + (pre>0?dp[pre-1]:0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public static void main(String[] args){
        String str = "(()())";
        System.out.println(isValid(str));
        System.out.println(maxLen(str));

    }
}