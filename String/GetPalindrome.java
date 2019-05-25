import java.util.*;
/**
 * 给定字符串str，可以在字符串的任意位置添加字符，请返回
 * 在添加字符最少情况下，让str是回文字符的一种结果
 * 进阶问题:
 * 还给定str的最长回文子序列字符串strlps，请返回在添加
 * 字符最少的情况下，让str是回文字符串的一种结果
 */
public class GetPalindrome{
    public static int[][] getDp(char[] chs){
        int[][] dp = new int[chs.length][chs.length];
        for(int i=1;i<chs.length;i++){
            dp[i-1][i] = chs[i-1]==chs[i]?0:1;
            for(int j=i-2;j>=0;j--){
                if(chs[i]==chs[j]){
                    dp[j][i] = dp[j+1][i-1];
                }else{
                    dp[j][i] = Math.min(dp[j+1][i], dp[j][i-1]) + 1;
                }        
            }
        }
        return dp;
    }
    public static String getPalindrome1(String str){
        if(str==null||str.length()<2){
            return str;
        }
        char[] chs = str.toCharArray();
        int[][] dp = getDp(chs);
        char[] res = new char[str.length()+dp[0][str.length()-1]];
        //System.out.println(res.length);
        int chsLeft = 0;
        int chsRight = chs.length - 1;
        int resLeft = 0;
        int resRight = res.length - 1;
        while(chsLeft<=chsRight){
            if(chs[chsLeft]==chs[chsRight]){
                res[resLeft++] = chs[chsLeft++];
                res[resRight--] = chs[chsRight--];
            }else if(dp[chsLeft+1][chsRight]<dp[chsLeft][chsRight-1]){
                res[resLeft++] = chs[chsLeft];
                res[resRight--] = chs[chsLeft++];
            }else{
                res[resLeft++] = chs[chsRight];
                res[resRight--] = chs[chsRight--];
            }
        }
        return String.valueOf(res);
    }
    //进阶问题
    public static String getPalindrome2(String str, String strlps){
        if(str==null||strlps==null){
            return "";
        }
        char[] chs = str.toCharArray();
        char[] chslps = strlps.toCharArray();
        char[] res = new char[2*chs.length - chslps.length];
        int chsLeft = 0;
        int chsRight = chs.length - 1;
        int chslpsLeft = 0;
        int chslpsRight = chslps.length - 1;
        int resLeft = 0;
        int resRight = res.length - 1;
        int tempLeft = 0;
        int tempRight = 0;
        while(chslpsLeft<=chslpsRight){
            tempLeft = chsLeft;
            tempRight = chsRight;
            while(chs[chsLeft]!=chslps[chslpsLeft]){
                chsLeft++;
            }
            while(chs[chsRight]!=chslps[chslpsRight]){
                chsRight--;
            }
            set(res, resLeft, resRight, chs, tempLeft, chsLeft, chsRight, tempRight);
            resLeft += chsLeft - tempLeft + tempRight - chsRight;
            resRight -= chsLeft - tempLeft + tempRight - chsRight;
            res[resLeft++] = chs[chsLeft++];
            res[resRight--] = chs[chsRight--];
            chslpsLeft++;
            chslpsRight--;
        }
        return String.valueOf(res);
    }
    public static void set(char[] res, int resLeft, int resRight, char[] chs, int tempLeft, int chsLeft, int chsRight, int tempRight){
        for(int i=tempLeft;i<chsLeft;i++){
            res[resLeft++] = chs[i];
            res[resRight--] = chs[i];
        }
        for(int i=tempRight;i>chsRight;i--){
            res[resLeft++] = chs[i];
            res[resRight--] = chs[i];
        }
    }
    public static void main(String[] args){
        String str = "A1B21C";
        String strlps = "121";
        System.out.println(getPalindrome1(str));
        System.out.println(getPalindrome2(str, strlps));
    }
}