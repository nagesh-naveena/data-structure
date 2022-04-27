package data.structure.simple;


import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedListExample list = new LinkedListExample();
        list.init(Arrays.asList(1,2,3,4,5,6,7));

    }

    private Node head = null;

    public LinkedListExample() {

    }

    private void init(List<Integer> asList) {
        Assert.assertNotNull("Invalid value passed for list.", asList);
        Node head = null;
        asList.forEach( i -> {
            addNode(i);
        });

        print();
        deleteNode(7);
        print();
        deleteNode(3);
        print();
        deleteNode(1);
        print();
        addNode(15);
        print();
        addNode(16);
        print();
        deleteNode(2);
        print();
    }

    class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public void addNode(int value) {
        if(head == null) {
            head = new Node(value);
        } else {
            Node newNode = new Node(value);
            Node n = head;
            while(n.next != null) {
                n = n.next;
            }
            n.next = newNode;
        }

    }

    public void deleteNode(int position) {
        if (head == null || position < 1) {
            throw new IllegalArgumentException("Invalid argument");
        }
        if(position == 1) {
            head = head.next;
            return;
        }

        Node n = head;
        int i =1;

        for(;i<position-1 && n!=null; i++) {
            n = n.next;
        }
        if(n == null || n.next == null) {
            throw new IndexOutOfBoundsException("Position out of range");
        } else {
            n.next = n.next.next;
        }
    }

    public void print() {
        if(head == null) {
            System.out.println("Null");
        } else {
            Node n = head;
            while(n != null) {
                System.out.print(n.value + " ");
                n = n.next;
            }
            System.out.println();
        }
    }

}
