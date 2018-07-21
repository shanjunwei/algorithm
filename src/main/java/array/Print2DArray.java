package array;

import java.util.ArrayList;

/**
 * Created by bruce_shan on 2018/6/28 17:31.
 * Description :  顺时针打印数组
 */
public class Print2DArray {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int tr = 0, tc = 0;
        int dr = matrix.length - 1   // 行长
                , dc = matrix[0].length - 1;   // 列长

        ArrayList<Integer> list = new ArrayList<>();

        while (tr <= dr && tc <= dc) {
            printMatrixBoard(tr, tc, dr, dc, list, matrix);
            tr++;
            tc++;
            dr--;
            dc--;
        }
        return list;
    }

    /**
     *  打印一个矩形边框
     * @param (TR,TC)  左上角坐标
     * @param (DR,DC)  右下角坐标
     * @return
     */
    public void printMatrixBoard(int TR,int TC ,int DR,int DC,ArrayList<Integer> ret,int[][] matrix){
        // --> 运动  TR不变 TC跟着变化  TC --> DC
        for (int i = TC; i <= DC; i++) {
            System.out.print(" "+matrix[TR][i]);
            ret.add(matrix[TR][i]);
        }
        // 箭头朝下运动 DC 不变 TR->DR
        for (int i = TR+1; i <= DR ; i++) {
            System.out.print(" "+matrix[i][DC]);
            ret.add(matrix[i][DC]);
        }
        //  <--- 运动 DR不变  DC-->TC
        for (int i = DC -1; TR!=DR && i >= TC ; i--) {
            System.out.print(" "+matrix[DR][i]);
            ret.add(matrix[DR][i]);
        }
        // 向上运动 TC 纵坐标不变 横坐标递减 DR--> TR
            for (int i = DR-1; TC!=DC && i  > TR; i--) {
                System.out.print(" "+matrix[i][TC]);
                ret.add(matrix[i][TC]);
            }

        System.out.println();
    }


    public static void main(String[] args) {
        int[][] array = {{1}};

        Print2DArray  print2DArray = new Print2DArray();
        ArrayList<Integer> list =  print2DArray.printMatrix(array);
        for(Integer item: list){
            System.out.print(" "+item);
        }
    }

}
