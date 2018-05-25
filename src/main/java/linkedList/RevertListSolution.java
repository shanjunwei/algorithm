package linkedList;

import java.util.ArrayList;

public class RevertListSolution {

    public ListNode ReverseList(ListNode head) {

        ListUtils.printList(revertInplace(head));
        
        

        return  revertInplace(head);
    }


    // 原地反转
    public ListNode  revertInplace(ListNode head){
        ListNode  pRev = null;
        ListNode  pTemp = head;
        ListNode  pNext  = pTemp;
        while (pNext!=null){
            pNext = pTemp.next;     //  指向待反转节点的下一节点
            pTemp.next = pRev;
            pRev = pTemp;    // 指向已反转部分的链表
            pTemp = pNext;   // 指向待反转节点
        }
        return pRev;
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        listNode = revertInplace(listNode);

        ArrayList<Integer>  dataList = new ArrayList<>();
        if (listNode != null) {
            //dataList = new ArrayList<>();
            dataList.add(listNode.val);
            while (listNode.next != null) {
                listNode = listNode.next;
                dataList.add(listNode.val);
            }
        }
        return dataList;
    }


    public static void main(String[] args) {
        ListNode list  = new ListNode(-1);
        ListUtils.initlist(list);

        ListUtils.printList(list);

        RevertListSolution solution  = new RevertListSolution();
        solution.printListFromTailToHead(list);
    }


}
