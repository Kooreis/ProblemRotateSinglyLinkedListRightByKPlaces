class LinkedList {
    Node head;

    void rotate(int k) {
        if (k == 0) return;

        Node current = head;

        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) return;

        Node kthNode = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = head;

        head = kthNode.next;

        kthNode.next = null;
    }
}