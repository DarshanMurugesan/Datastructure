public class SinglyCircularLinkedList {
    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head, tail;
    private int size;

    // Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    // Insert at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    // Insert at specific position
    public void insertAtPosition(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid position");
            return;
        }
        if (index == 0) {
            insertAtHead(data);
        } else if (index == size) {
            insertAtTail(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // Delete at head
    public void deleteAtHead() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
    }

    // Delete at tail
    public void deleteAtTail() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = head;
            tail = current;
        }
        size--;
    }

    // Delete at position
    public void deleteAtPosition(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid position");
            return;
        }
        if (index == 0) {
            deleteAtHead();
        } else if (index == size - 1) {
            deleteAtTail();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    // Search for value and return index
    public int search(int key) {
        if (head == null) return -1;

        Node current = head;
        int index = 0;
        do {
            if (current.data == key) return index;
            current = current.next;
            index++;
        } while (current != head);

        return -1;
    }

    // Update value at a specific position
    public void updateAtPosition(int index, int newValue) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid position");
            return;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        int oldValue = current.data;
        current.data = newValue;
        System.out.println("Updated position " + index + " from " + oldValue + " to " + newValue);
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        System.out.print("List: ");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    // Get list size
    public int getSize() {
        return size;
    }

    // Main method for testing
    public static void main(String[] args) {
        SinglyCircularLinkedList list = new SinglyCircularLinkedList();

        list.insertAtHead(10);
        list.insertAtTail(20);
        list.insertAtPosition(1, 15);
        list.display();  // 10 -> 15 -> 20 -> (back to head)

        list.deleteAtHead();
        list.display();  // 15 -> 20 -> (back to head)

        list.deleteAtTail();
        list.display();  // 15 -> (back to head)

        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtPosition(1, 25);
        list.display();  // 15 -> 25 -> 30 -> 40 -> (back to head)

        int pos = list.search(25);
        System.out.println("Position of 25: " + (pos != -1 ? pos : "Not found"));

        list.updateAtPosition(1, 100);
        list.display(); // 15 -> 100 -> 30 -> 40 -> (back to head)

        list.updateAtPosition(0, 9);   // Update head
        list.updateAtPosition(3, 99);  // Update tail
        list.display(); // 9 -> 100 -> 30 -> 99 -> (back to head)

        list.updateAtPosition(10, 500); // Invalid
    }
}
