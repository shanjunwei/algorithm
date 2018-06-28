package bit;

import java.util.LinkedList;

/**
 * Created by bruce_shan on 2018/6/7 16:14.
 * Description :  位运算
 */
public class bitSolution {

   // 统计数字中1的个数
    public int NumberOf1(int n) {
        int bitcount = 0;

        for (int i = 0; i < 32; i++) {
            if((n & (1<<i))!=0){
                bitcount ++;
            }
        }
        return bitcount;
    }

   // 跳台阶问题
    public int JumpFloor(int target) {
        if(target <1)  return 0;

        if (target == 1) return 1;
        if (target == 2) return 2;

        else  return JumpFloor(target-1) + JumpFloor(target-2);
    }

    // 斐波那契数列
    public int Fibonacci(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        LinkedList<Integer>  queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int count = 3;
        while (count < n){
            queue.pollFirst();
            queue.add(queue.get(0)+queue.get(1));
            count ++;
        }
        return queue.get(2);
    }

    public static void main(String[] args) {
        bitSolution solution = new bitSolution();
        System.out.println(solution.Fibonacci(4));
    }
}
