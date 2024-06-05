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