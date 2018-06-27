package array;

import java.util.*;

public class Solution {
    int Max = 0;
    public int FindGreatestSumOfSubArray(int[] array) {
        Fonction(array);

        return Max;
    }


    public int Fonction(int[] array) {
        if (array.length <= 0) return 0;
        if (array.length == 1) return array[0];
        int Fn_1_Max = Fonction(subArray(array)) + array[array.length - 1];
        int arrayN = array[array.length - 1];
        int max = Math.max(Fn_1_Max, arrayN);
        if (max > Max) {
            Max = max;
        }
        return max;
    }

    // 截取数组  末尾减一个
    public int[] subArray(int[] origin) {
        int[] newArray = new int[origin.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = origin[i];
        }
        return newArray;
    }

    //  找数组中出现次数超过一半的数
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer>  ncMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer countKey = ncMap.get(array[i]);
            int count = countKey == null ? 1 :countKey+1;
            ncMap.put(array[i],count);

            if(count > array.length/2){
                return array[i];
            }
        }
        return 0;
    }

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        Map<Integer,Integer>  ncMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer countKey = ncMap.get(array[i]);
            int count = countKey == null ? 1 :countKey+1;
            ncMap.put(array[i],count);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : ncMap.entrySet()){
            if(entry.getValue() ==1){
                list.add(entry.getKey());
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }



    class NumPo  {
        int  num;
        int  position;

        public NumPo(int num,int position){
            this.num = num;
            this.position = position;
        }

        @Override
        public boolean equals(Object obj) {
            NumPo  numPo = (NumPo) obj;
            return this.num == numPo.num && this.position != numPo.position;
        }
    }

    //两数和问题
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        ArrayList<Integer> result = new ArrayList<>();

        if(array.length <2){
            return result;
        }
        HashMap<Integer,ArrayList<Integer>>  map = new HashMap<>();

         for (int i = 0; i < array.length; i++) {
           if(map.get(array[i])==null){
               ArrayList<Integer>  list = new ArrayList<>();
               list.add(i);
               map.put(array[i],list);
           }else{
               ArrayList<Integer>  list = map.get(array[i]);
               list.add(i);
               map.put(array[i],list);
           }
        }

        for (int i = 0; i < array.length; i++) {
            int num2 = sum - array[i];
            if(map.containsKey(num2)){
                ArrayList<Integer>  list = map.get(num2);
                if(list.size() ==1 && list.get(0)== i){
                    continue;
                }
                result.add(array[i]);
                result.add(num2);
                break;
            }
        }
        return result;
    }



    // 旋转数组中最小的那个
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;

        return RotateArray(array,0,array.length-1);
    }


    //   // 旋转数组中最小的那个  构造递归循环
    public int RotateArray(int[] array ,int low,int high){
        int middle = (low+high)/2;

        if (array[middle] < array[low]) return RotateArray(array,low,middle);
        else  if(array[middle] > array[low]) return RotateArray(array,middle,high);
        else   return array[high];
    }

    // 求次方
    public double Power(double base, int exponent) {

        if(exponent==0) return 1;

        boolean sign = exponent >0 ? true: false;
        double origin = base;
        int ex = exponent >0 ? exponent: -exponent;
        for (int i = 0; i < ex-1; i++) {
            base*=origin;
            System.out.println("====循环一次"+base);
        }

        return sign? base : 1/base;
    }


 /*   public static void main(String[] args) {
        int[] array = {4, -3, 5, -2, -1, 2, 6, -2};
        Solution las = new Solution();

        System.out.println(las.FindGreatestSumOfSubArray(array));
    }*/

    // 划分数组，奇前偶后
    public void reOrderArray(int [] array) {

//        int left_index = -1;
//        // 遍历数组
//        for (int i = 0; i < array.length ; i++) {
//            if(array[i]%2 != 0){
//                // 交换 left_index+1 和 i
//                if(array[left_index+1]!= array[i]){
//                    array[left_index+1] = array[left_index+1]^ array[i];
//                    array[i] = array[left_index+1]^ array[i];
//                    array[left_index+1] = array[left_index+1]^ array[i];
//                }
//
//                left_index++;
//            }
//        }


        int i= 0;

        while (i<array.length){
            while (i < array.length && array[i]%2 !=0) i++;

            int first_ou = i;

            while (i <array.length && array[i]%2 == 0) i++;

            int first_ji = i;

            if(first_ji == array.length || first_ou == array.length) continue;

            // 第一个奇数和第一个偶数交换位置
            if(array[first_ou]!= array[first_ji]){
                System.out.println("first_ji :"+array[first_ji] +" first_ou:"+array[first_ou]);
                array[first_ou] = array[first_ou]^ array[first_ji];
                array[first_ji] = array[first_ou]^ array[first_ji];
                array[first_ou] = array[first_ou]^ array[first_ji];
                i++;
            }
        }


        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j]+ " ");
        }
    }


    /**
     *  统计一个数字在排序数组中出现的次数
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        //  首先在数组中 二分查找k
        int position =  BinarySearch(array,k,0,array.length-1);
        if(position == -1 ) return 0; // 没找到

        int low = position;
        int high = position;

        // 通过高低指针移位并计数
        while (low>=0 &&  array[low]== k) low--;
        while (high < array.length && array[high] == k) high++;

        return high-low-1;
    }


    public int BinarySearch(int [] array , int k ,int left,int right) {
        if(left > right)  return  -1;
       // if(left == right)  return left;

        int middle =  (left+right) /2;

        if(array[middle] == k ) return middle;

        if(array[middle] > k)  return BinarySearch(array,k,left,middle-1);
        else return BinarySearch(array,k,middle+1,right);
    }



    public static void main(String[] args) {
        int[] array = {3,3,3,3,4,5};

        Solution solution = new Solution();

       // System.out.println(solution.minNumberInRotateArray(array));
       // solution.reOrderArray(array);
       // System.out.println(solution.BinarySearch(array,3,0,array.length-1));
        System.out.println(solution.GetNumberOfK(array,3));

    }
}
