package LinkedList;

public class LinkedListReverse {

    public static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next ;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean loopDetectAndPosition(Node head) {
        Node turtle = head;
        Node hare = head;
        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare)
                return true;
        }
        return false;
    }

    public static void main(String a[]){
        //1->3->5->7->9
        Node l = new Node(5, new Node(7, new Node(9)));
        Node m = new Node(3, l);
        Node n = new Node(1, m);
        l.next = m;
        boolean isLoop = loopDetectAndPosition(n);
        System.out.print(isLoop);
    }
}
