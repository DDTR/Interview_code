import java.util.*;
/**
 * 在有序但是含有空的数组中查找字符串，多次出现返回最左边的位置，未查找到返回-1
 */
public class GetIndex{
    public static int getIndex(String[] strs, String str){
        if(strs==null||strs.length==0||str==null){
            return -1;
        }
        int res = -1;
        int left = 0;
        int mid = 0;
        int  i = 0;
        int right = strs.length-1;
        while(left<=right){
            mid = (right+left) / 2;
            if(strs[mid]!=null&&strs[mid].equals(str)){
                res = mid;
                right = mid - 1;
            }else if(strs[mid]!=null){
                if(strs[mid].compareTo(str)<0){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                i = mid;
                while(strs[i]==null&&--i>=left);
                if(i<left||strs[i].compareTo(str)<0){
                    left = mid + 1;
                }else{
                    res = strs.equals(str)?i:res;
                    right = i - 1;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        String[] strs = new String[]{null, "a", null, "a", null, "b", null, "c"};
        String str = "d";
        System.out.println(getIndex(strs, str));
    }
}
