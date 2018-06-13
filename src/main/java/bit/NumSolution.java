package bit;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bruce_shan on 2018/6/13 15:44.
 * Description :  各种数的求解算法
 */
public class NumSolution {


    public int GetUglyNumber_Solution(int index) {

        if(index<1) return 0;
        if(index==1) return 1;

        Queue<Integer>  queue2  = new LinkedList<>();  // 2质数因子序列
        Queue<Integer>   queue3  = new LinkedList<>();  // 3质数因子序列
        Queue<Integer>   queue5  = new LinkedList<>();   // 5质数因子序列

        int count = 1;
        int current =1;   // 丑数种子

        while (count<index){
            // 种子生成新的丑数
            queue2.add(current*2);
            queue3.add(current*3);
            queue5.add(current*5);

            // 只需要比较 三个序列中最小的值即可，而最小的值就是最先放进去的值
            current = Math.min(Math.min(queue2.peek(),queue3.peek()),queue5.peek());

            if(queue2.peek() == current ) queue2.poll();
            if(queue3.peek() == current ) queue3.poll();
            if(queue5.peek() == current ) queue5.poll();


            count++;
        }
        return current;
    }


    public static void main(String[] args) {
        NumSolution solution = new NumSolution();
        System.out.println(solution.GetUglyNumber_Solution(10));
    }

}
