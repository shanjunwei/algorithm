package array;

/**
 * Created by bruce_shan on 2018/7/21 10:08.
 * Description :  快排 荷兰国旗问题
 */
public class QuickSort {
    // 利用荷兰国旗问题优化的快排
    public void QS(int[] arr,int l,int r){
        if(l >r) return;

        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
       // int[] p = partition(arr,)
    }
    // 荷兰国旗问题
    public  int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < p) {
                swap(arr, ++less, l++);
            } else if (arr[l] > p) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[] { less + 1, more - 1 };   // 返回大于小于的边界
    }

    public void  swap(int[] arry, int i ,int j){
        if(arry[i]!=arry[j]){
            arry[i] = arry[i]^arry[j];
            arry[j] = arry[i]^arry[j];
            arry[i] = arry[i]^arry[j];
        }
    }

    // 数组打印
    public void arrayPrint(int[]  array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[]  array = {2,3,5,6,2,1,3,7};
        //solution.DutchFlag(array);
        solution.partition(array,0,array.length-1,3);

        solution.arrayPrint(array);
    }


}
