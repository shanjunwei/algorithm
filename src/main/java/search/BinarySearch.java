package search;

public class BinarySearch {


    // 二分查找
    public static int binarySearch(int[] array, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;//int middle = left + (right + left) >>> 1;

        if (target < array[middle]) {
            return binarySearch(array, left, middle - 1, target);
        } else if (left == right) {
            return middle;
        } else {
            return binarySearch(array, middle + 1, right, target);
        }
    }

    public static void main(String[] args) {
        // 测试二分查找
        int[] array = {1, 2, 4, 7, 3, 5, 6, 8};

       /// binarySearch(array,0,array.length-1,)
    }
}
