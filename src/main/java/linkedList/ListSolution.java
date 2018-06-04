package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bruce_shan on 2018/6/4 13:53.
 * Description :  表问题的解决
 */
public class ListSolution {
    /**
     *  找到两链表的第一个公共节点
     * @param pHead1
     * @param pHead2
     * @return 一个遍历加哈希查找
     *  哈希查找时间复杂度O(1) 散列比较好的情况下
     *  最坏时间复杂度 O(n) 遍历到链尾才找到公共节点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        Set set  = new HashSet<>();

        while (pHead2 != null){
            set.add(pHead2.val);
            pHead2 = pHead2.next;
        }

        // 遍历链表1
        while (pHead1 != null){
            if(set.contains(pHead1.val)){
                return pHead1;
            }
            pHead1 = pHead1.next;
        }

        return null;
    }


    // 测试用例
    public static void main(String[] args) {
        // 构造两个链表
        ListNode pHead1  =   new ListNode(1);
        ListUtils.initlist(pHead1);
        ListNode pHead2  =   new ListNode(5);
        ListUtils.initlist(pHead2);


        // 打印两个链表
        ListUtils.printList(pHead1);
        System.out.println();
        ListUtils.printList(pHead2);

        ListSolution solution = new ListSolution();
        System.out.println(solution.FindFirstCommonNode(pHead1,pHead2).val);
    }
}
