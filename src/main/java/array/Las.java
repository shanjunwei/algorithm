package array;

public class Las {
    int Max = -1000000000;

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
           Max = max > Max ? max : Max;
           System.out.println("=====" + max);
           System.out.println("=====Max" + Max);
        return max;
    }


    // 递归不考虑跨界情况
    public int getMaxWithoutCross(int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }
        int middle = (0 + array.length - 1) / 2;
        int[] leftArray = subArray(array, 0, middle);                          //  划分左子数组
        int[] rightArray = subArray(array, middle + 1, array.length - 1); //  划分右子数组
        int leftMax = getMaxWithoutCross(leftArray);
        int rightMax = getMaxWithoutCross(rightArray);
        return Math.max(leftMax, rightMax);
    }

    //  递归体
    public int getCrossMinddleMax(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int middle = (0 + array.length - 1) / 2;
        int rightIndex = middle + 1;
        int leftIndex = middle;
        int sum = 0;
        int crossMiddleMax = 0;
        while (rightIndex <= array.length - 1 && leftIndex >= 0) {
            sum += array[rightIndex] + array[leftIndex];
            crossMiddleMax = sum > crossMiddleMax ? sum : crossMiddleMax;
            leftIndex--;
            rightIndex++;
        }
        return crossMiddleMax;
    }


    public void printArray(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


    // 截取数组
    public int[] subArray(int[] origin, int left, int right) {

        int[] newArray = new int[right - left + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = origin[i + left];
        }
        return newArray;
    }

    // 截取数组  末尾减一个
    public int[] subArray(int[] origin) {
        int[] newArray = new int[origin.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = origin[i];
        }
        return newArray;
    }


    public static void main(String[] args) {
        //  int[] array = {4, -3, 5, -2, -1, 2, 6, -2};

        int[] array = {-2, -8, -1, -5, -9};
        Las las = new Las();

        System.out.println(las.FindGreatestSumOfSubArray(array));
    }
}
