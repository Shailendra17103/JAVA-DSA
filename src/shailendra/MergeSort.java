package shailendra;

public class MergeSort {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    // Merges two sorted linked lists
    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    // Splits the linked list into two halves
    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    // Reverses the linked list recursively
    private void reverse(ListNode node, ListNode[] nodes) {
        if (node.next == null) {
            nodes[0] = nodes[1] = node;
            return;
        }
        reverse(node.next, nodes);
        nodes[1].next = node;
        nodes[1] = node;
        node.next = null;
    }

    // Linked list class for testing
    static class LL {
        ListNode head;

        public void insertLast(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                ListNode temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        public void printList() {
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        //in place reversal of linked list


        public static void main(String[] args) {
            MergeSort mergeSort = new MergeSort();
            LL list = new LL();
            list.insertLast(4);
            list.insertLast(2);
            list.insertLast(1);
            list.insertLast(3);

            System.out.println("Original List:");
            list.printList();
            list.head = mergeSort.sortList(list.head);

            System.out.println("Sorted List:");
            list.printList();
            ListNode[] nodes = new ListNode[2];
            mergeSort.reverse(list.head, nodes);
            list.head = nodes[0];

            System.out.println("Reversed List:");
            list.printList();
        }
    }
}
