Here is a C# console application that rotates a singly linked list to the right by k places.

```C#
using System;

public class Node
{
    public int Value;
    public Node Next;
}

public class LinkedList
{
    Node head;

    public void Add(int data)
    {
        Node newNode = new Node() { Value = data };
        if (head == null)
            head = newNode;
        else
        {
            Node current = head;
            while (current.Next != null)
            {
                current = current.Next;
            }
            current.Next = newNode;
        }
    }

    public void Rotate(int k)
    {
        if (k <= 0)
        {
            return;
        }

        Node current = head;
        int count = 1;
        while (count < k && current != null)
        {
            current = current.Next;
            count++;
        }

        if (current == null)
        {
            return;
        }

        Node kthNode = current;
        while (current.Next != null)
        {
            current = current.Next;
        }

        current.Next = head;
        head = kthNode.Next;
        kthNode.Next = null;
    }

    public void Print()
    {
        Node current = head;
        while (current != null)
        {
            Console.Write(current.Value + " ");
            current = current.Next;
        }
    }
}

class Program
{
    static void Main(string[] args)
    {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 7; i++)
        {
            linkedList.Add(i);
        }

        Console.WriteLine("Original linked list:");
        linkedList.Print();

        linkedList.Rotate(4);
        Console.WriteLine("\nLinked list after rotation:");
        linkedList.Print();

        Console.ReadKey();
    }
}
```