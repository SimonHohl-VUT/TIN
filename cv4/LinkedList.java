package cv4;

public class LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            System.out.println("Inserted: " + data + " as the first node.");
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        System.out.println("Inserted: " + data + " at the end of the list.");
    }

    public void display() {
        Node current = head;
        
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void removeFromStart() {
        if (head == null) {
            System.out.println("List is empty. Nothing to remove.");
            return;
        }

        int removedData = head.data;
        head = head.next;
        System.out.println("Removed: " + removedData + " from the start of the list.");
    }

    public void removeFromEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to remove.");
            return;
        }

        if (head.next == null) {
            int removedData = head.data;
            head = null;
            System.out.println("Removed: " + removedData + " from the end of the list.");
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        int removedData = current.next.data;
        current.next = null;
        System.out.println("Removed: " + removedData + " from the end of the list.");
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        System.out.println("Building list...");
        
        myList.insert(10);
        myList.insert(20);
        myList.insert(30);

        System.out.print("Current List: ");
        myList.display();

        System.out.println("\nRemoving from start...");
        myList.removeFromStart();
        System.out.print("Current List: ");
        myList.display();

        System.out.println("\nRemoving from end...");
        myList.removeFromEnd();
        System.out.print("Current List: ");
        myList.display();
    }

}