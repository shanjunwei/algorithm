package tree;

import java.util.*;

public class TreeChildSolution {

    int count = 0;


    // 判断a 树是否为 b树的字结构
    public boolean isAChildTreeOfB(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }
        TreeSolution solution = new TreeSolution();
        // 先序遍历 a
        LinkedList<Integer> preList = solution.foreachBinaryTree(a);

        // 中序遍历 a
        LinkedList<Integer> inList = solution.foreachBinaryTree(a);


        // 先序遍历 母树
        TreeNode root = a;
        int count = 0;
        if (root != null) {
            Stack<TreeNode> stack = new Stack();
            stack.push(root);
            while (!stack.empty()) {
                TreeNode top = stack.pop();   // 出栈顶元素
                System.out.print("-->" + top.val);

                if (top.val == preList.get(count)) {
                    count++;
                    if (top.right != null) stack.push(top.right);      // 入栈右节点
                    if (top.left != null) stack.push(top.left);       // 入栈左节点
                }
            }
        }


        return false;
    }

    // 层次遍历 二叉树
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();

            result.add(head.val);

            if (head.left != null) {
                queue.add(head.left);
            }

            if (head.right != null) {
                queue.add(head.right);
            }

        }
        return result;
    }


    public int TreeDepth2(TreeNode root) {
        int floor_count = 0;
        if (root == null) {
            return floor_count;
        }
        // 记录一下上一层的所有节点
        LinkedList<TreeNode> oldFloor = new LinkedList();
        LinkedList<TreeNode> newFloor = new LinkedList();   // 当前节点

        oldFloor.add(root);

        while (!oldFloor.isEmpty()) {
            //  Iterator<TreeNode> iterator = oldFloor.iterator();

//            while (iterator.hasNext()) {
//                TreeNode treeNode = iterator.next();
//
//                if (treeNode.right != null) {
//                    newFloor.add(treeNode.right);
//                }
//
//                if (treeNode.left != null) {
//                    newFloor.add(treeNode.left);
//                }
//            }
            oldFloor.forEach(node -> {
                if (node.right != null) {
                    newFloor.add(node.right);
                }

                if (node.left != null) {
                    newFloor.add(node.left);
                }
            });

            oldFloor = newFloor;
            floor_count++;
        }
        return floor_count;
    }

    // 后序遍历 二叉树
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length < 1) return false;
        if (sequence.length == 1) return true;

        int last = sequence[sequence.length - 1];

        int max = firstPositionOfBiggerThanLast(sequence);

        TreeSolution solution = new TreeSolution();
        //截取  左子树
        int[] left = solution.subArray(sequence, 0, max - 1);
        // 截取 右子树
        int[] right = solution.subArray(sequence, max, sequence.length - 2);

        if (!checkTheRightPart(right, last)) {
            return false;
        }

        boolean checkLeftSeq = left.length == 0 ? true : VerifySquenceOfBST(left);
        boolean checkRightSeq = left.length == 0 ? true : VerifySquenceOfBST(right);

        if (checkLeftSeq && checkRightSeq) {
            return true;
        } else {
            return false;
        }
    }


    // 返回第一个 比最后一个数字大的
    public int firstPositionOfBiggerThanLast(int[] seq) {
        int last = seq[seq.length - 1];

        if (seq.length <= 1) {
            return -1;
        }
        for (int i = 0; i < seq.length - 1; i++) {
            if (seq[i] > last) {
                return i;
            }
        }
        return seq.length - 1;
    }

    // 检查 右子树 是否比最后一个数 都大
    public boolean checkTheRightPart(int[] rightSeq, int last) {
        for (int i = 0; i < rightSeq.length; i++) {
            if (rightSeq[i] < last) {
                return false;
            }
        }
        return true;
    }


    // 树的深度
    public int TreeDepth(TreeNode root) {

        getTreeDepth(root, 0);

        return count;
    }

    // 获取树的深度  先序遍历二叉树
    private void getTreeDepth(TreeNode root, int depth) {
        count = Math.max(depth,count);

        if (root.left != null) {
            getTreeDepth(root.left, depth + 1);
        }

        if (root.right != null) {
            getTreeDepth(root.right, depth + 1);
        }
    }

    public static void main(String[] args) {
        // 测试 序列是否为后序遍历 二叉树序列
        int[] seq = {4, 8, 6, 12, 16, 14, 10};

        int[] seq2 = {4, 6, 7, 5};

        int[] seq3 = {5};
        TreeSolution ts = new TreeSolution();
        TreeChildSolution solution = new TreeChildSolution();

        //  System.out.println(solution.VerifySquenceOfBST(seq3));

        System.out.println(solution.TreeDepth(ts.initBinaryTree()));


    }
}
