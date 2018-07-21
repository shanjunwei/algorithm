package array;

/**
 * Created by bruce_shan on 2018/7/21 10:08.
 * Description :  快排 荷兰国旗问题
 */
public class QuickSort {
    // 对外统一快排调用 入口
    public void quickSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        QS(arr, 0, arr.length - 1);
    }

    // 利用荷兰国旗问题优化的快排
    public void QS(int[] arr, int l, int r) {
        if (l > r) return;

        int M = 10;   // 切换至插入排序的阈值 5到15之间比较合理
        if (l + M >= r) insertSort(arr, l, r);
        // Math.random() * N  取得是 [0 N) 之间的小数
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);  // 随机
        int[] p = partition(arr, l, r);
        QS(arr, l, p[0] - 1);
        QS(arr, p[1] + 1, r);
    }

    // 荷兰国旗问题改进的快排的划分
    public int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[]{less + 1, more - 1};   // 返回大于小于的边界
    }

    // 荷兰国旗问题
    public int[] partition(int[] arr, int l, int r, int p) {
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
        return new int[]{less + 1, more - 1};   // 返回大于小于的边界
    }

    // 插入排序  常数项占优势
    public void insertSort(int[] arr, int l, int r) {
        if (arr == null || arr.length == 1) return;

        for (int i = l + 1; i <= r; i++) {
            int j = i - 1;
            while (j >= l && arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                j--;
            }
        }
        return;
    }


    //  通过异或交换两值
    public void swap(int[] arr, int i, int j) {
        if (arr[i] != arr[j]) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

    // 数组打印
    public void arrayPrint(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] array = {2, 3, 5, 6, 2, 9, 3, 7};

        solution.QS(array, 0, array.length - 1);
        solution.arrayPrint(array);
    }


}
