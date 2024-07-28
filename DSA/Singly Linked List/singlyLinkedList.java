import java.util.List;

public class singlyLinkedList {

    private ListNode head;

    private static class ListNode {

        private int data; // generic type
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("NULL");
    }

    public int countLength() {
        int count = 0;
        if (head == null) {
            return 0;
        }
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertBeg(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtPosi(int data, int position) {
        ListNode node = new ListNode(data);
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            node.next = current;
            previous.next = node;

        }

    }

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteEnd() {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode temp = head;
        ListNode current = null;
        while (temp.next != null) {
            current = temp;
            temp = temp.next;
        }
        current.next = null;
        return temp;
    }

    public ListNode deleteAtPos(int position) {
        if (position == 1) {
            return head;
        }
        int count = 1;
        ListNode previous = head;
        ListNode temp = null;
        while (count < position - 1) {
            previous = previous.next;
            count++;
        }
        temp = previous.next;
        previous.next = temp.next;
        return temp;
    }

    public boolean findNode(ListNode head,int key) {
        if (head == null) {
            return false;
        }
        ListNode currNode = head;
        while (currNode != null) {
            if (currNode.data == key) {
                return true;
            }
            currNode=currNode.next;
        }
        return false;
    }
    
    public ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }

        ListNode currNode=head;
        ListNode previous=null;
        ListNode next=null;

        while (currNode!=null) {
            next=currNode.next;
            currNode.next=previous;
            previous=currNode;
            currNode=next;
        }
        return previous;

    }

    public static void main(String[] args) {
        singlyLinkedList sll = new singlyLinkedList();
        ListNode head = new ListNode(10);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(5);
        ListNode fourth = new ListNode(9);

        head.next = second;
        second.next = third;
        third.next = fourth;

        // print data in singly linked list in java
        // sll.display();

        // count the elements in singly linked list
        // int length = sll.countLength();
        // System.out.println("Count of Element is : "+length);

        // I N S E R T I O N I N S I N G L Y L I K E D L I S T

        // insert node at the beginning of a singly linked list
        // sll.insertBeg(8);
        // sll.display();

        // insert node at the end of a singly linked list
        // sll.insertEnd(44);
        // sll.insertEnd(45);
        // sll.insertEnd(46);
        // sll.display();

        // insert node at the given position in singly linked list
        // sll.insertAtPosi(20, 3);
        // sll.insertAtPosi(20, 1);
        // sll.insertAtPosi(20, 5);
        // sll.insertAtPosi(22, 6);
        // sll.insertAtPosi(22, 9);
        // sll.display();

        // D E L E T I O N I N S I N G L Y L I K E D L I S T

        // delete first node of a singly linked list

        // System.out.println();
        // int deletedElement=sll.deleteFirst().data;
        // sll.display();
        // System.out.println();
        // System.out.println("Deleted element is : "+deletedElement);

        // delete end node of a singly linked list

        // sll.display();
        // System.out.println();
        // int deletedElement=sll.deleteEnd().data;
        // System.out.println(deletedElement);
        // sll.display();

        // dlete node at the given position

        // sll.display();
        // System.out.println();
        // int deletedElement = sll.deleteAtPos(2).data;
        // System.out.println(deletedElement);
        // sll.display();

        // E L E M E N T E X I S T O R N O T

        // if (sll.findNode(head,9)) {
        //     System.out.println("Node exist");
        // } else {
        //     System.out.println("Node dosn't exist");
        // }

        // R E V E R S E   L I N K E D    L I S T

        sll.display(head);
        ListNode reverseListHead= sll.reverse(head);
        sll.display(reverseListHead);
    }
}
