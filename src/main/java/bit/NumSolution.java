package bit;

import array.NumCountSolution;

/**
 * Created by bruce_shan on 2018/6/13 15:44.
 * Description :  各种数的求解算法
 */
public class NumSolution {


    public int GetUglyNumber_Solution(int index) {

        if(index<1) return 0;

        if(index ==1) return 1;

        int UglyNumCount =1;
        int count =1;

        while (UglyNumCount <index){
            count++;
            if(isUglyNum(count)){
                UglyNumCount++;
               // System.out.println(String.format("第 %s 个丑数 %s",UglyNumCount,count));
            }
        }
        return count;
    }



    // 判断一个数是否为丑数
    public boolean  isUglyNum(int num){

        while (num!=1){
            if(num%2!=0 &&num%3!=0 && num%5!=0 )  break;

            if(num%2==0)  num = num/2; // 对2整除
            if(num%3==0)  num = num/3;  // 对3整除
            if(num%5==0)  num = num/5;  // 对5整除
        }

        return num ==1;
    }


    public static void main(String[] args) {
        NumSolution solution = new NumSolution();
        System.out.println(solution.GetUglyNumber_Solution(10));
    }

}
