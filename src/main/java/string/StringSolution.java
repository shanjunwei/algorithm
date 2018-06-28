package string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bruce_shan on 2018/6/9 9:28.
 * Description :
 */
public class StringSolution {


    // 旋转字符串
    public String LeftRotateString(String str,int n) {
        StringBuilder result = new StringBuilder();
        if(str == null || str.equals("")){
            return result.toString();
        }
        if ( n <= 0)  return str;
        Queue  queue  = new LinkedList<>();
        for (char  s   :str.toCharArray()){
            queue.add(s);
        }
        for (int i = 0; i < n; i++) {
           char out = (char) queue.poll();
            queue.add(out);
        }

       for(Object s :   queue.toArray()){
           result.append(s.toString());
       }
        return result.toString();
    }


    public static void main(String[] args) {
        StringSolution solution = new StringSolution();

        System.out.println(solution.LeftRotateString("abcdef",4));
    }
}
