package org.example.userDefineDSA.linkedList;

public class DoubleCircularLinkedList {
    private class Node{
        private int val;
        private Node next;
        private Node prev;
        public Node(int val){
            this.val = val;
        }
    }
    private int size;
    private Node head;
    private Node tail;
    public DoubleCircularLinkedList(){
        this.size =0;
    }
    public void addAtFront(int val){
        if(head==null){
            Node a = new Node(val);
            head = a;
            tail = a;
            head.prev = tail;
            tail.next = head;
        }else{
            Node newNode = new Node(val);
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void addAtLast(int val){
        if(head==null){
            addAtFront(val);
        }else {
            Node a = new Node(val);
            tail.next = a;
            a.prev = tail;
            a.next = head;
            tail = a;
        }
        size++;
    }
    public void addAtIndex(int val,int index){
        if(index>=size) return;
        else if(index==0){
            addAtFront(val);
        }else if(index==size-1){
            addAtLast(val);
        }else {
            Node newNode = new Node(val);
            Node reference = getNode(index);
            Node nextRef = reference.next;
            reference.next = newNode;
            newNode.prev = reference;
            newNode.next = nextRef;
            size++;
        }
    }
    public Node getNode(int index){
        if(index>=size) return null;
        if(index==0) return head;
        else if(index==size-1) return tail;
        else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            return temp;
        }
    }
    public int getSize(){return size;}
}
