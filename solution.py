Here is a Python console application that solves the problem:

```python
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        if not self.head:
            self.head = Node(data)
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = Node(data)

    def __len__(self):
        current = self.head
        count = 0
        while current:
            count += 1
            current = current.next
        return count

    def rotate(self, k):
        if self.head and self.head.next:
            k = k % len(self)
            if k:
                fast = self.head
                slow = self.head
                for _ in range(k):
                    fast = fast.next
                while fast.next:
                    slow = slow.next
                    fast = fast.next
                temp = self.head
                self.head = slow.next
                slow.next = None
                fast.next = temp

    def print_list(self):
        current = self.head
        while current:
            print(current.data, end=' ')
            current = current.next
        print()

def main():
    llist = LinkedList()
    for i in range(1, 6):
        llist.append(i)
    print("Original List:")
    llist.print_list()
    llist.rotate(2)
    print("Rotated List:")
    llist.print_list()

if __name__ == "__main__":
    main()
```

This Python console application creates a singly linked list and provides a method to rotate the list to the right by k places. The `main` function creates a linked list with values from 1 to 5, prints the original list, rotates the list by 2 places, and then prints the rotated list.