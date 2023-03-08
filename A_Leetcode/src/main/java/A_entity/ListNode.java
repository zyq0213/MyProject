package A_entity;

/**
 * @author yanqing.zou
 * @date 2022-09-22 17:44
 * Description
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
