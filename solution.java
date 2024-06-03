Here is a Java console application that solves the problem:

```java
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

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

    void push(int newData) {
        Node newNode = new Node(newData);

        newNode.next = head;

        head = newNode;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String args[]) {
        LinkedList list = new LinkedList();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.push(scanner.nextInt());
        }
        System.out.println("Enter the number of places to rotate:");
        int k = scanner.nextInt();

        System.out.println("Given linked list");
        list.printList();

        list.rotate(k);

        System.out.println("\nRotated Linked list");
        list.printList();
    }
}
```

This program first creates a linked list with the user's input. Then it rotates the list to the right by k places, where k is also provided by the user. The rotated list is then printed to the console.