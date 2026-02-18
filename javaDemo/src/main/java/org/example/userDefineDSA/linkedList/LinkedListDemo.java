package org.example.userDefineDSA.linkedList;

public class LinkedListDemo {
    static void main(String[] args) {
//        SingleLinkedList l = new SingleLinkedList();
//        l.addNodeAtFront(3);
//        l.addNodeAtFront(31);
//        l.addNodeAtFront(32);
//        l.addNodeAtFront(33);
//        l.addNodeAtFront(34);
//        l.addNodeAtFront(35);
//        l.addNodeAtFront(36);
//        l.addNodeAtFront(37);
//        l.addNodeAtLast(5);
//        l.printLinkedList();
//        System.out.println();
//        System.out.println("size: "+l.getSize());
//        l.addNode(7,7);
//        l.printLinkedList();
//        l.deleteLast();
//        System.out.println();
//        l.printLinkedList();
//        l.delete(2);
//        System.out.println();
//        l.printLinkedList();

        DoublyLinkedList ll = new DoublyLinkedList();
        ll.addAtLast(10);
        ll.addAtLast(11);
        ll.addAtLast(12);
        ll.addAtLast(13);
        ll.addAtLast(14);
        ll.addAtLast(15);
        ll.addAtFront(9);
        ll.addAtLast(16);
        ll.addAtLast(18);
        System.out.println("size:"+ ll.getSize());
        ll.addAtIndex(19,8);
        ll.addAtIndex(17,7);
        ll.printLinkedList();
        System.out.println();
        ll.deleteAtFront();
        ll.deleteAtLast();
        ll.delete(2);
        ll.printLinkedList();

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addAtFront(1);
        dll.addAtLast(2);
        dll.addAtLast(3);
        dll.addAtLast(4);
    }

}
