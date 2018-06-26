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


    /**
     *  合并两个有序链表
     */

    public ListNode Merge(ListNode list1,ListNode list2) {

        //  比较两个链表的第一个节点
    //    while (list1 != null && list2!=null) {
        // 记录节点头
        ListNode  head1 = list1;
        ListNode  head2 = list2;

        if(list1==null) return list2;

        if(list2==null) return list1;

            if(list1.val  < list2.val){
                while (list1 !=null && list2 !=null){
                    while ( list1.next!=null && list1.next.val <= list2.val){
                        list1 = list1.next;
                    }
                    ListNode insertNode = new ListNode(list2.val);
                    insertNode.next = list1.next;
                    list1.next = insertNode;
                    list2 = list2.next;
                    list1 = list1.next;
                }
                return head1;
            }else {
                while (list1!=null && list2!=null){
                    while (list2.next !=null && list2.next.val <= list1.val){
                        list2 = list2.next;
                    }
                    // 在 list2 节点和next 之间插入 list1
                    ListNode insertNode = new ListNode(list1.val);
                    insertNode.next = list2.next;
                    list2.next = insertNode;
                    list1 = list1.next;
                    list2 = list2.next;
                }
                return head2;
            }
       // }
    }

    // 链表中包含环，请找出环的入口节点
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead ==null || pHead.next == null){
            return null;
        }
        HashSet  hashSet  =  new HashSet();
        ListNode pLow = pHead;

        while(!hashSet.contains(pLow.val)){
            hashSet.add(pLow.val);
            pLow   =  pLow.next;
        }
        return pLow;
    }

    //  删除链表中重复的节点
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead.next == null || pHead== null){
            return pHead;
        }
        // 初始化
        ListNode  pRev  = new ListNode(-1);
        ListNode  result  = pRev;
        pRev.next = pHead;
        ListNode  pNext = pHead.next;

        while (pNext!=null){

            while (pNext!=null && pRev.next!=null && pNext.val != pRev.next.val){  // pRev.next为 pFirst
              //  System.out.println( "=====pRev:"+pRev.next.val+"====pNext:"+pNext.val);
                pNext = pNext.next;
                pRev = pRev.next;
            }
            if(pNext==null){
                continue;
            }
            // 找到重复元素
            while (pNext.next!=null && pNext.next.val == pNext.val){
                pNext = pNext.next;
            }

            pNext = pNext.next;
            // 删除重复元素
            pRev.next = pNext;
          //  pRev = pRev.next;
            pNext = pNext==null?pNext.next:pNext;
        }
        return result.next;
    }

    // 链表的倒数第k个节点  思维一定要缜密
    public ListNode FindKthToTail(ListNode head,int k) {
        int count = 0;
        ListNode  list = head;

        while (head!=null){
            System.out.print("  node:"+head.val);
            count++;
            head = head.next;
        }
        // 验证 K的合法性 k 不能大于 count
        if(k > count)  return null;
        // 倒数第k 个节点也就是 正数 第 count - k +1 个节点

        int index = 0;
        while (index < count -k ){
            index++;
            list =list.next;
        }
        return list;
    }


    // 测试用例
    public static void main(String[] args) {
        // 构造两个链表
        ListNode pHead1 = new ListNode(1);
        ListUtils.initlist(pHead1);
        ListUtils.printList(pHead1);


        ListSolution solution = new ListSolution();
       // ListUtils.printList(solution.deleteDuplication(pHead1));
        ListUtils.printList(solution.FindKthToTail(pHead1,1));
    }
}
