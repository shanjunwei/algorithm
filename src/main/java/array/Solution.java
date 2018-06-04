package array;

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


 /*   public static void main(String[] args) {
        int[] array = {4, -3, 5, -2, -1, 2, 6, -2};
        Solution las = new Solution();

        System.out.println(las.FindGreatestSumOfSubArray(array));
    }*/


    public static void main(String[] args) {
        System.out.println("dkcnkc");
    }
}
