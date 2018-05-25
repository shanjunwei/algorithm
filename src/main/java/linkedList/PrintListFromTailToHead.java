package linkedList;

import java.util.ArrayList;

public class PrintListFromTailToHead {


    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList arrayList = new ArrayList<Integer>();
        if (listNode == null) {
            return arrayList;
        }

        ListNode newList = new ListNode(listNode.val);
        //  遍历原链表 头插法生成新链表
        while (listNode.next != null) {
            listNode = listNode.next;
            ListNode node = new ListNode(listNode.val);
            headInsert(newList, node);
        }
        return convertToArray(newList);
    }

    // 头插入法
    public static void headInsert(ListNode list, ListNode node) {
        node.next = list.next;
        list.next = node;

//        node.next =list;
//        list = node;
    }

    // 遍历输出
    public static ArrayList convertToArray(ListNode list) {
        ArrayList arrayList = new ArrayList<Integer>();
        while (list.next != null) {
           // System.out.println(list.data);
            arrayList.add(list.val);
            list = list.next;
        }
        return arrayList;
    }

    // 遍历输出
    public static void printList(ListNode list) {
        while (list.next != null) {
            list = list.next;
            System.out.print("->" + list.val);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ListNode linkedList = new ListNode(-1);

        for (int i = 1; i < 9; i++) {
            ListNode node = new ListNode(i);
            headInsert(linkedList, node);
        }

        printList(linkedList);

        printListFromTailToHead(linkedList);


    }
}
