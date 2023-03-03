package zyq.arithmetic.tree;

import zyq.arithmetic.ListNode;


/**
 * @author yanqing.zou
 * @date 2022-09-23 11:13
 * Description
 */
public class A5_mergeTwoLists_1 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode res = list1.val < list2.val ? list1 : list2;
        res.next = mergeTwoLists(res.next, list1.val >= list2.val ? list1 : list2);
        return res;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(6);
        ListNode listNode = mergeTwoLists(list1, list2);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
