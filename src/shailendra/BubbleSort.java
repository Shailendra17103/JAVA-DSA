package shailendra;

public class BubbleSort {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    // Linked List class
    static class LL {
        Node head;
        int size;
        public void insertLast(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }
        public void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
        public void bubbleSort() {
            if (head == null || head.next == null) {
                return;
            }
            boolean swapped;
            do {
                swapped = false;
                Node current = head;
                Node prev = null;
                while (current != null && current.next != null) {
                    if (current.value > current.next.value) {
                        // Swap current and current.next
                        Node next = current.next;
                        current.next = next.next;
                        next.next = current;

                        if (prev == null) {
                            head = next;
                        } else {
                            prev.next = next;
                        }
                        swapped = true;
                    }
                    prev = (swapped && prev == null) ? head : current;
                    current = current.next;
                }
            } while (swapped);
        }
    }
    public static void main(String[] args) {
        LL list = new LL();
        for (int i = 7; i > 0; i--) {
            list.insertLast(i);
        }
        System.out.println("Before sorting:");
        list.display();
        list.bubbleSort();
        System.out.println("After sorting:");
        list.display();
    }
}
