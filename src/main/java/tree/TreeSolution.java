package tree;

import java.util.LinkedList;
import java.util.Stack;

public class TreeSolution {


    private static class RootArray {
        TreeNode root;
        int[] arrayPre;
        int[] arrayIn;

        public RootArray() {
        }

        public RootArray(TreeNode root, int[] arrayPre, int[] arrayIn) {
            this.root = root;
            this.arrayPre = arrayPre;
            this.arrayIn = arrayIn;
        }

        public RootArray(int root, int[] arrayPre, int[] arrayIn) {
            this.root = new TreeNode(root);
            this.arrayPre = arrayPre;
            this.arrayIn = arrayIn;
        }
    }

    // 递归  先序遍历 二叉树
    public void recursiveForeachBinaryTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "-->");   // 先访问根节点

            if (root.left != null) {
                recursiveForeachBinaryTree(root.left);
            }
            if (root.right != null) {
                recursiveForeachBinaryTree(root.right);
            }
        }
    }


    // 非递归 先序遍历 二叉树
    public void nonRecursiveForeachBinaryTree(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack();

            stack.push(root);
            while (!stack.empty()) {
                TreeNode top = stack.pop();   // 出栈顶元素
                System.out.print("-->" + top.val);
                // 入栈右节点
                if (top.right != null) stack.push(top.right);

                // 入栈左节点
                if (top.left != null) stack.push(top.left);
            }
        }
    }


    // 非递归 先序遍历 二叉树
    public LinkedList<Integer> foreachBinaryTree(TreeNode root) {
        LinkedList list = new LinkedList();
        if (root != null) {
            Stack<TreeNode> stack = new Stack();
            stack.push(root);
            while (!stack.empty()) {
                TreeNode top = stack.pop();   // 出栈顶元素
                System.out.print("-->" + top.val);
                list.add(top.val);
                // 入栈右节点
                if (top.right != null) stack.push(top.right);

                // 入栈左节点
                if (top.left != null) stack.push(top.left);
            }
        }
        return list;
    }


    // 通过先序中序还原 二叉树
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || pre.length != in.length) {
            return null;
        }
        Stack<RootArray> stack = new Stack<>();

        TreeNode rootTree = new TreeNode(pre[0]);  // 树的根节点
        RootArray rootItem = new RootArray(rootTree, pre, in);
        stack.push(rootItem);

        while (!stack.empty()) {
            RootArray rootArray = stack.pop();
            TreeNode root = rootArray.root;
            // System.out.print(root.val + "-->");

            int[] pre2 = rootArray.arrayPre;
            int[] in2 = rootArray.arrayIn;

            // 中序分左右子树
            int leftLength = getLeftArraySize(root.val, rootArray.arrayIn);
            //  得到左节点
            if (pre2.length >= 2 && leftLength != 0) {
                root.left = new TreeNode(pre2[1]);
            }

            if (1 + leftLength < pre2.length) {
                root.right = new TreeNode(pre2[1 + leftLength]);
            }

            if (root.right != null) {
                // 右节点入栈
                stack.push(new RootArray(root.right, subArray(pre2, leftLength + 1, pre2.length - 1), subArray(in2, leftLength + 1, in2.length - 1)));
            }
            if (root.left != null) {
                // 左节点 入栈
                stack.push(new RootArray(root.left, subArray(pre2, 1, leftLength), subArray(in2, 0, leftLength - 1)));
            }
        }
        // System.out.println();
        return rootTree;
    }

    /**
     * @param middle 根节点
     * @param in     中序数组
     * @return
     */
    public int getLeftArraySize(int middle, int[] in) {
        if (in.length == 0) {
            return 0;
        }
        int index = 0;
        while (index < in.length && in[index] != middle) {
            index++;
        }
        return index;
    }

    // 二分查找
    public int binarySearch(int[] array, int left, int right, int target) {
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

    // 二分查找
    public static int FindBySecond(int[] array, int left, int right, int key, int time) {
        if (left > right) {
            if (time == 1) return right;
            else return -1;
        }
        int middle = left + (right - left) / 2;
        if (key < array[middle]) return FindBySecond(array, left, middle - 1, key, time);
        if (key == array[middle]) {
            return middle;
        } else return FindBySecond(array, middle + 1, right, key, time);
    }

    // 截取数组
    public int[] subArray(int[] origin, int left, int right) {

        int[] newArray = new int[right - left + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = origin[i + left];
        }
        return newArray;
    }


    // 左 子数组  得到左右节点
    public int getLeftAndRightTreeNode(int[] leftOrRightArray, int[] pre) {
        int position = pre.length;
        for (int i = 0; i < leftOrRightArray.length; i++) {
            int temp = binarySearch(pre, 0, pre.length - 1, leftOrRightArray[i]);
            if (temp < position) position = temp;
        }
        return pre[position];
    }

//    // 右 子数组  得到右节点
//    public int getRightTreeNode(int[] leftArray, int[] pre) {
//        int position = pre.length;
//        for (int i = 0; i < leftArray.length; i++) {
//            int temp = binarySearch(pre, 0, pre.length - 1, leftArray[i]);
//            if (temp < position) position = temp;
//        }
//        return pre[position];
//    }


    // 构造一颗树
    public TreeNode initBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(8);

        return root;
    }


    public static void main(String[] args) {
        TreeSolution solution = new TreeSolution();

//        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
//
//        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        int[] pre = {1, 2};

        int[] in = {2, 1};

        // () -> pre

        TreeNode root = solution.reConstructBinaryTree(pre, in);

        solution.nonRecursiveForeachBinaryTree(root);
    }
}
