import java.util.*;
/**
 * 如果str1和str2出现的字符种类一样并且每种字符出现的次数也一样，那么str1和str2互为变形词
 */
public class IsDeformation{
    public static boolean isDeformation(String str1, String str2){
        if(str1==null||str2==null||str1.length()!=str2.length()){
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[] map = new int[256];
        for(int i=0;i<ch1.length;i++){
            map[ch1[i]]++;
            System.out.println(ch1[i]);
        }
        for(int i=0;i<ch2.length;i++){
            if(map[ch2[i]]--==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String str1 = "123a";
        String str2 = "2313";
        System.out.println(isDeformation(str1, str2));
    }
}