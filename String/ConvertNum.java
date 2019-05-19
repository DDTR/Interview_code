import java.util.*;
/**
 * 将整数字符串转成整数值
 */
public class ConvertNum{
    public static boolean isValid(char[] chs){
        if(chs[0]!='-'&&(chs[0]>'9'||chs[0]<'0')){
            return false;
        }
        if(chs[0]=='-'&&(chs.length==1||chs[1]=='0')){
            return false;
        }
        if(chs[0]=='0'&&chs.length>1){
            return false;
        }
        for(int i=1;i<chs.length;i++){
            if(chs[i]<'0'||chs[i]>'9'){
                return false;
            }
        }
        return true;
    }
    public static int convert(String str){
        if(str==null||str.equals("")){
            return 0;
        }
        char[] chs = str.toCharArray();
        if(!isValid(chs)){
            return 0;
        }
        int cur = 0;
        int res = 0;
        int minq = Integer.MIN_VALUE/10;
        int minr = Integer.MIN_VALUE%10;
        boolean flag = chs[0]=='-'?false:true;//正为true
        for(int i=flag?0:1;i<chs.length;i++){
            cur = '0' - chs[i];
            if(res<minq){
                return 0;
            }
            if(res==minq&&cur<minr){
                return 0;
            }
            res = res*10+cur;
            //System.out.println(res);
        }
        if(flag&&res==Integer.MIN_VALUE){
            return 0;
        }
        return flag?-res:res;
    }
    public static void main(String[] args){
        String str = "2147483649";
        System.out.println(convert(str));
    }
}