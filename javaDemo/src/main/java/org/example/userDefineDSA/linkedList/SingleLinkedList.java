package org.example.userDefineDSA.linkedList;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        private int val;
        private Node next;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node node){
            this.val=val;
            this.next = node;
        }
    }
    public SingleLinkedList(){
        this.size=0;
    }
    public int getSize(){
        return size;
    }
    public void addNodeAtFront(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size++;
    }
    public void printLinkedList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
    }
    public void addNodeAtLast(int val){
        Node node = new Node(val);
        if(tail==null){
            head=node;
            tail=node;
        }
        tail.next = node;
        tail=node;
        size++;
    }
    public void deleteFirst(){
        if(head == null){
            System.out.println("Empty Linked List");
        }else if(size==1){
            head = null;
            tail = null;
            size--;
        }else{
            head =head.next;
            size--;
        }
    }
    public void deleteLast(){
        if(head== null){
            System.out.println("Empty Linked List");
        }else if(size ==1){
            head=null;
            tail=null;
            size--;
        }else{
            Node referenceNode = getNode(size-1);
            referenceNode.next = null;
            size--;
        }
    }
    public void delete(int index){
        if(size<index){
            System.out.println("invalid value");
        }else if(index==size-1){
            deleteLast();
        }else if(index==0){
            deleteFirst();
        }else{
            Node reference = getNode(index-1);
            if(reference != null){
                reference.next=reference.next.next;
            }
        }
    }
    public Node getNode(int index){
        Node node = head;
        for(int i=0;i<index;i++){
            node = node.next;
        }
        return node;
    }
    public void addNode(int val,int pos){
        if(pos<size){
            if(pos==1){
                addNodeAtFront(val);
            }else if(pos==size){
                addNodeAtLast(val);
            }else {
                int currPos = 1;
                Node newNode = new Node(val);
                Node temp = head;
                while (currPos < size) {
                    if (pos == currPos) {
                        Node deleteNext = temp.next;
                        temp.next = newNode;
                        newNode.next = deleteNext;
                    }else{
                        temp = temp.next;
                    }
                    currPos++;
                }
            }
        }else{
            System.out.println("Invalid Position");
        }
    }
    public Node reverseList(Node head){
        if(head == null || head.next == head){
            return head;
        }
        Node prev=null;
        Node curr = head;
        while (curr != null){
            Node temp = curr.next ;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
