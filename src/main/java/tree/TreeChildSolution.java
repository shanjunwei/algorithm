package tree;

import java.util.*;

public class TreeChildSolution {

    int count = 0;

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

    // 递归判断 判断一颗树是否是平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        if(!IsBalancedOfLR(root)) return false;

        if(root.left !=null) return IsBalanced_Solution(root.left);
        if(root.right!=null) return IsBalanced_Solution(root.right);
        else return true;
    }

    // 判断左右子树是否平衡
    public boolean IsBalancedOfLR(TreeNode root) {
        if(root == null) return true;

        int leftDepth  =  root.left == null? 0: TreeDepth(root.left);
        count = 0;
        int rightDepth  =  root.right == null? 0: TreeDepth(root.right);

        System.out.println("leftDepth:" + leftDepth+" rightDepth: "+rightDepth) ;
        System.out.println((((leftDepth - rightDepth)*(leftDepth - rightDepth)) < 2));
        return (((leftDepth - rightDepth)*(leftDepth - rightDepth)) < 2);
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

    //  二叉查找树的第k大节点   中序遍历第k 个节点
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(k ==0)  return null;
        int count = 0;
        if (pRoot != null) {
            Stack<TreeNode> stack = new Stack();
            while (pRoot!=null ||   !stack.empty()) {
                if(pRoot!=null){
                    stack.push(pRoot);
                    pRoot = pRoot.left;
                }else{
                    TreeNode  node = stack.pop();
                    System.out.println(node.val+"-->");

                    count++;
                    if(count == k){
                        return node;
                    }

                    pRoot = node.right;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // 测试 序列是否为后序遍历 二叉树序列
        int[] seq = {4, 8, 6, 12, 16, 14, 10};

        int[] seq2 = {4, 6, 7, 5};

        int[] seq3 = {5};
        TreeSolution ts = new TreeSolution();
        TreeChildSolution solution = new TreeChildSolution();

        //  System.out.println(solution.VerifySquenceOfBST(seq3));

        System.out.println(solution.IsBalanced_Solution(ts.initBinaryTree2()));


    }
}
