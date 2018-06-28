package array;

import java.util.*;

/**
 * Created by bruce_shan on 2018/6/5 10:50.
 * Description :  数字次数的题  题解
 */
public class NumCountSolution {


    //一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        Set<Integer> ncSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!ncSet.contains(array[i])){
                ncSet.add(array[i]);
            }else{
                ncSet.remove(array[i]);
            }
        }
        Object[] list = ncSet.toArray();
        num1[0] = (int) list[0];
        num2[0] = (int) list[1];
    }


    //一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    // 位移解法
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        int num = array[0];
        for (int i = 1; i <array.length ; i++) {
            num ^= array[i];
        }

        int position = getTheFirstOnePosition(num);

        // 划分数组
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
           // System.out.println("====="+num);
            if( (array[i] & position) != 0){
                list1.add(array[i]);
            }else{
                list2.add(array[i]);
            }
        }

        // 全部异或list1,得到num1
        for (int i = 0; i < list1.size(); i++) {
            num1[0] ^= list1.get(i);
        }
        for (int i = 0; i < list2.size(); i++) {
            num2[0] ^= list2.get(i);
        }
    }



    public int getTheFirstOnePosition(int num){
        for (int i = 0; i < 32; i++) {
            if((num & (1<<i))!=0){
                return 1<<i;
            }
        }
        return 0;
    }

   // 数组中重复的数字
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if ( numbers==null ) return false;

        HashMap<Integer,Integer>  map = new HashMap();
        for (int num : numbers){
            if(map.get(num)==null){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > 1){
                duplication[0] = entry.getKey();
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        NumCountSolution solution = new NumCountSolution();
       // System.out.println( solution.getTheFirstOnePosition(12));
        int[] array = {1,3,3,4,4,5,5,2};
        int[] num1 = {0};
        int[] num2 = {0};
        int[] nums = {};
      //  solution.FindNumsAppearOnce2(array,num1,num2);
       // System.out.println("===num1:"+num1[0]+"===num2:"+num2[0]);

        solution.duplicate(nums,0,nums);
    }
}
