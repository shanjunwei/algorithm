package tree;

import java.util.*;

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
    public void recursiveFirstForeachBinaryTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "-->");   // 先访问根节点

            if (root.left != null) {
                recursiveFirstForeachBinaryTree(root.left);
            }
            if (root.right != null) {
                recursiveFirstForeachBinaryTree(root.right);
            }
        }
    }


    // 递归  中序遍历 二叉树
    public void recursiveMiddleForeachBinaryTree(TreeNode root) {
        if(root.left != null){//使用递归遍历左孩子
            recursiveMiddleForeachBinaryTree(root.left);
        }

        System.out.print(root.val + "-->");   // 访问根节点

        if(root.right != null){//使用递归遍历右孩子
            recursiveMiddleForeachBinaryTree(root.right);
        }
    }


    // 递归  后序遍历 二叉树
    public void recursiveAfterForeachBinaryTree(TreeNode root) {
        if(root.left != null){//使用递归遍历左孩子
            recursiveAfterForeachBinaryTree(root.left);
        }

        if(root.right != null){//使用递归遍历右孩子
            recursiveAfterForeachBinaryTree(root.right);
        }
        System.out.print(root.val + "-->");   // 访问根节点
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
    // 非递归 中序遍历 二叉树
    public void nonRecursiveMiddleForeachBinaryTree(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack();
            while (root!=null ||   !stack.empty()) {
                if(root!=null){
                    stack.push(root);
                    root = root.left;
                }else{
                    TreeNode  node = stack.pop();
                    System.out.println(node.val+"-->");
                    root = node.right;
                }
            }
        }
    }


    // 非递归 后序遍历 二叉树
    public void nonRecursiveAfterForeachBinaryTree(TreeNode root) {
        Stack<TreeNode> stackRes = new Stack<>();
        Stack<TreeNode> stackTmp = new Stack<>();
        stackTmp.push(root);
        TreeNode curNode;

        while (!stackTmp.isEmpty()) {
            curNode = stackTmp.pop();
            stackRes.push(curNode);
            if (curNode.left != null) {
                stackTmp.add(curNode.left);
            }
            if (curNode.right != null) {
                stackTmp.add(curNode.right);
            }
        }

        while (!stackRes.isEmpty()) {
            System.out.print(stackRes.pop().val+"-->");
        }
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


    // 二叉搜索树的第k大的节点
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        // 中序遍历二叉树
        if (pRoot != null) {
            Stack<TreeNode> stack = new Stack();

            stack.push(pRoot);
            while (!stack.empty()) {
                TreeNode top = stack.pop();   // 出栈顶元素
                System.out.print("-->" + top.val);
                // 入栈右节点
                if (top.right != null) stack.push(top.right);

                // 入栈左节点
                if (top.left != null) stack.push(top.left);
            }
        }


        return null;
    }

    // 二叉树按层打印
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>  list = new ArrayList();
        if(pRoot == null){
            return list;
        }

        Map<Integer,ArrayList<Integer>>  map = new LinkedHashMap<>();

        DepthForEachTree(pRoot,0,map);

        for (Map.Entry<Integer,ArrayList<Integer>> entry: map.entrySet()){
                list.add(entry.getValue());
        }
        return list;
    }

    // 递归层序遍历二叉树
    public void DepthForEachTree(TreeNode root,int depth,Map<Integer,ArrayList<Integer>> map){
        if(map.get(depth) == null){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(depth,list);
        }else {
            ArrayList<Integer> list = map.get(depth);
            list.add(root.val);
            map.put(depth,list);
        }

        if(root.left !=null) DepthForEachTree(root.left,depth+1,map);
        if(root.right !=null) DepthForEachTree(root.right,depth+1,map);
    }






    public static void main(String[] args) {
        TreeSolution solution = new TreeSolution();

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};

        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

       // int[] pre = {1, 2};

     //   int[] in = {2, 1};

        // () -> pre

      //  TreeNode root = solution.reConstructBinaryTree(pre, in);

        TreeNode root = solution.initBinaryTree();

       // solution.nonRecursiveMiddleForeachBinaryTree(root);
        solution.Print(root);
    }
}
