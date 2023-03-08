package tree;

import com.alibaba.fastjson.JSON;
import A_entity.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @author yanqing.zou
 * @date 2022-09-22 17:43
 * Description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class A4_mergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                deque.addFirst(list2.val);
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                deque.addFirst(list1.val);
                list1 = list1.next;
                continue;
            }
            if (list1.val > list2.val) {
                deque.addFirst(list2.val);
                list2 = list2.next;
            } else {
                deque.addFirst(list1.val);
                list1 = list1.next;
            }
        }
        ListNode root = new ListNode(deque.removeLast());
        ListNode other = root;
        while(!deque.isEmpty()){
            ListNode temp = new ListNode(deque.removeLast());
            other.next =temp;
            other = other.next;
        }


        return root;
    }
    public static void test(){
            ListNode listNode = new ListNode(1);
            listNode.next = new ListNode(2);
            listNode.next.next = new ListNode(3);
            listNode.next.next.next = new ListNode(4);
            ListNode newListNode = listNode;
            newListNode = newListNode.next;
            newListNode.next = newListNode.next.next;
            System.out.println(JSON.toJSONString(newListNode));
            System.out.println(JSON.toJSONString(listNode));
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(list1, list2);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
