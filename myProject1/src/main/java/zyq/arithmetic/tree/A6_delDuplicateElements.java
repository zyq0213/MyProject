package zyq.arithmetic.tree;

import zyq.arithmetic.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yanqing.zou
 * @date 2023-01-05 16:07
 * Description 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 */
public class A6_delDuplicateElements {
    //不按升序排列
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode beginNode = head;
        ListNode preNode = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        head = head.next;
        while (head != null){
            if (set.contains(head.val)) {
                preNode.next = head.next;
                head = head.next;
                continue;
            }

            preNode = head;
            set.add(head.val);
            head = head.next;
        }

        return beginNode;
    }

    //按升序排列
    //1.正常删除
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode node = head;
        ListNode preNode = null;
        while (head != null){
           if(preNode != null && head.val == preNode.val){
               preNode.next = head.next;
               head = head.next;
               continue;
           }
           preNode = head;
           head = head.next;
        }
        return node;
    }

    //按升序排列
    //1.递归
    public static ListNode deleteDuplicates2(ListNode head) {
        if(head.next == null){
            return head;
        }
        head.next = deleteDuplicates2(head.next);
        if(head.val == head.next.val){
            head.next = head.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode  listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = deleteDuplicates2(listNode);
        while (listNode1 != null){
            System.out.print(listNode1.val +"->");
            listNode1 = listNode1.next;
        }
    }
}
