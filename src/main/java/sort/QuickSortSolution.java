package sort;

import java.util.ArrayList;

/**
 * Created by bruce_shan on 2018/6/4 15:24.
 * Description :  快排的应用  返回前K小的数
 */
public class QuickSortSolution {


    public void quickSort(int[] array, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int middle = partition(array, left, right);

        if (middle < k) {
            quickSort(array, middle + 1, right, k);
        }
        quickSort(array, left, middle - 1, k);

    }

    // 一次划分过程
    private int partition(int[] array, int left, int right) {
        int middle = left;
        int middleKey = array[middle];
        while (left < right) {
            // 高指针先走
            while (left < right && array[right] > middleKey) {   // 高指针找到 <= 中轴的数停下
                right--;
            }
            while (left < right && array[left] <= middleKey) {  // 低指针找到 > 中轴的数停下
                left++;
            }
            // 交换高低指针的值
            if (left < right) {
                array[left] = array[left] ^ array[right];
                array[right] = array[left] ^ array[right];
                array[left] = array[left] ^ array[right];
            }
        }
        // 将中轴的值放置到中轴位置
        if (right > middle) {
            array[middle] = array[middle] ^ array[right];
            array[right] = array[middle] ^ array[right];
            array[middle] = array[middle] ^ array[right];
        }
        return right;
    }

    // 快排的应用: 最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if(k > input.length){
            return list;
        }

        quickSort(input, 0, input.length - 1, k);

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }

        return list;
    }
}
