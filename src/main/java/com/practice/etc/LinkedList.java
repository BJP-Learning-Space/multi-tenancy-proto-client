package com.practice.etc;

public class LinkedList {
    Node head;
    Node tail;
    int size = 0;

    Node search(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }

        Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    void preOrder() {
        Node node = head;

        for (int i = 0; i < size; i++) {
            System.out.println(node);
            node = node.next;
        }
    }

    void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (size == 0) {
            tail = head;
        }

        size++;
    }

    void insert(int data) {
        if (size == 0) {
            insertFirst(data);
            return;
        }

        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException();
        }

        if (index == 0) {
            insertFirst(data);
            return;
        }

        if (index == size) {
            insert(data);
            return;
        }

        Node newNode = new Node(data);
        Node prevNode = search(index - 1);
        Node nextNode = prevNode.next;
        prevNode.next = newNode;
        newNode.next = nextNode;
        size++;
    }

    Node reverseList() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            if (prev == null) {
                tail = curr;
            }

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void deleteNode(Node node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }

    public Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return second.next;
    }

    void reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        System.out.println(prev);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    class Node {
        int value;
        Node next;

        public Node(final int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
//        list.reverse();
        list.reverse(list.head);
//        System.out.println("\n");
//        list.preOrder();
//        System.out.println(list.tail);
//        System.out.println(list.head);
    }
}
