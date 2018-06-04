package sort;

/**
 * Created by bruce_shan on 2018/6/4 14:29.
 * Description : 快速排序 以及它的变体
 */
public class QuickSort {

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = partition(array, left, right);
        quickSort(array, left, middle - 1);
        quickSort(array, middle + 1, right);
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
            if(left <right){
                array[left] = array[left] ^ array[right];
                array[right] = array[left] ^ array[right];
                array[left] = array[left] ^ array[right];
            }
        }
        // 将中轴的值放置到中轴位置
        if(right > middle){
            array[middle] = array[middle] ^ array[right];
            array[right] = array[middle] ^ array[right];
            array[middle] = array[middle] ^ array[right];
        }

        return right;
    }




    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};


        // 测试下自己写的快排，不知道这是第几次写了
        QuickSort  quickSort = new QuickSort();
        quickSort.quickSort(array,0,array.length-1);

        for(int num : array){
            System.out.print("  "+num);
        }
    }
}
