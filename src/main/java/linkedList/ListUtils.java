package linkedList;

import java.util.ArrayList;

public class ListUtils {

    //  链表初始化
    public static void initlist(ListNode list) {
        if (list == null) {
            list = new ListNode();
        }

        for (int i = 1; i < 9; i++) {
            ListNode node = new ListNode(i);
            headInsert(list, node);
        }
    }


    // 头插入法
    public static void headInsert(ListNode list, ListNode node) {
        node.next = list.next;
        list.next = node;
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
        if (list != null) {
            System.out.print(list.val);
            while (list.next != null) {
                list = list.next;
                System.out.print("->" + list.val);
            }
            System.out.println();
        }
    }
}
