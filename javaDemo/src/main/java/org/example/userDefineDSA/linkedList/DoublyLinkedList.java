package org.example.userDefineDSA.linkedList;

public class DoublyLinkedList {
    private class Node{
        private int val;
        private Node prev;
        private Node next;
        public Node(int val){
            this.val = val;
        }
    }
    private int size;
    private Node head;
    private Node tail;
    public DoublyLinkedList(){
        this.size =0;
    }
    public void addAtFront(int val){
        if(head==null){
            Node node = new Node(val);
            head = node;
            tail = node;
        }else{
            Node node = new Node(val);
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }
    public void printLinkedList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.val+"<-->");
            temp=temp.next;
        }
    }
    public void addAtLast(int value){
        if(head==null){
            Node a = new Node(value);
            head = a;
            tail = a;
        }else{
            Node a = new Node(value);
            tail.next = a;
            a.prev = tail;
            tail = a;
        }
        size++;
    }
    public void addAtIndex(int val,int index){
        if(size<=index){
            System.out.println("invalid value");
        }else if(index==size-1){
            addAtLast(val);size++;
        }else if(index==0){
            addAtFront(val);size++;
        }else{
            Node newNode = new Node(val);
            Node reference = getNode(index);
            Node refNext = reference.next;
            reference.next = newNode;
            newNode.prev = reference;
            newNode.next = refNext;
            refNext.prev = newNode;
            size++;
        }
    }
    public void deleteAtFront(){
        if(head==null) return;
        head = head.next;
        head.prev = null;
        size--;
    }
    public void deleteAtLast(){
        if(tail==null) return;
        Node secondLast = tail.prev;
        tail = secondLast;
        secondLast.next = null;
        size--;
    }
    public Node getNode(int index){
        if(index>=size){
            System.out.println("invalid");
            return null;
        }else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp;
        }
    }
    public void delete(int index){
        if(size<=index) return;
        if(index==0){
            deleteAtFront();
        }else if(index==size-1){
            deleteAtLast();
        }else {
            Node reference = getNode(index);
            Node prevRef = reference.prev;
            Node nextRef = reference.next;
            prevRef.next = nextRef;
            nextRef.prev = prevRef;
            size--;
        }
    }
    public int getSize(){
        return size;
    }
}
