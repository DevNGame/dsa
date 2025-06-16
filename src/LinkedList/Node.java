package LinkedList;

import java.awt.desktop.SystemSleepEvent;

public class Node {
    Node next;
    int value;

    public Node(int value){
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public static int getLength(Node head){
        int count = 0;
        while(head.next!=null){
            count ++;
            head = head.next;
        }
        return count;
    }

    public static void print(Node head){
        while(head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }

}
