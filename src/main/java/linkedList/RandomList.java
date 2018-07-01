package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bruce_shan on 2018/7/1 9:28.
 * Description :  复杂链表的复制
 */
public class RandomList {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }


    // 复杂链表的复制
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null )  return null;
        RandomListNode  list  = pHead;

        Map<RandomListNode,RandomListNode>  map = new HashMap<>();
        while (pHead !=null){
            RandomListNode  cloneNode  = new RandomListNode(pHead.label);
            map.put(pHead,cloneNode);
           // cloneNode.next = pHead.next;
            pHead = pHead.next;
        }
        RandomListNode  node = list;
        while (node!=null){
            RandomListNode  p = map.get(node);
            p.next  = map.get(node.next);
            p.random  =  map.get(node.random);
            node = node.next;
        }
        return map.get(list);
    }


    // 构造一颗复杂链表
    public RandomListNode InitList(){
        RandomListNode head = new RandomListNode(1);
        RandomListNode node1 =  new RandomListNode(2);
        RandomListNode node2 =  new RandomListNode(3);

        head.next  = node1;
        node1.next = node2;
        node2.next  = null;

        head.random = node2;
        node1.random= head;
        node2.random = null;

        return head;
    }

    public static void main(String[] args) {
        // 构造一颗复杂链表
        RandomList  solution = new RandomList();
        RandomListNode listNode = solution.InitList();

        solution.Clone(listNode);
    }
}
