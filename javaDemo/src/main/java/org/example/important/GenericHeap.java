package org.example.important;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class GenericHeap<T extends Comparable<T>> {
    private Object[] heap;
    private int size;
    private boolean isMinHeap;
    private static final int DEFAULT_CAPACITY = 10;

    public GenericHeap(boolean isMinHeap) {
        this.heap = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.isMinHeap = isMinHeap;
    }
    public GenericHeap() {
        this(true); // default to min heap
    }

    // add
    public void add(T value) {
        ensureCapacity();
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    // peek
    public T peek() {
        if (size == 0) throw new NoSuchElementException();
        return elementAt(0);
    }

    // poll
    public T poll() {
        if (size == 0) throw new NoSuchElementException();
        T root = elementAt(0);
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    // print level wise element
    public void printLevelWise() {
        int level = 0;
        int i = 0;
        while (i < size) {
            int totalEleInLevel = (int) Math.pow(2, level);
            System.out.print("Level " + level + ": ");
            for (int j = 0; j < totalEleInLevel && i < size; j++) {
                System.out.print(heap[i] + " ");i++;
            }
            System.out.println();
            level++;
        }
    }

    public void heapifyDown(int idx) {
        while (true) {
            int leftIdx = 2 * idx + 1;
            int rightIdx = 2 * idx + 2;
            int parentIdx = idx;
            if (leftIdx < size && compare(leftIdx, parentIdx)) {
                parentIdx = leftIdx;
            }
            if (rightIdx < size && compare(rightIdx, parentIdx)) {
                parentIdx = rightIdx;
            }
            if (parentIdx != idx) {
                swap(idx, parentIdx);
                idx = parentIdx;
            } else {
                break;
            }
        }
    }

    public void heapifyUp(int idx) {
        int parentIdx = (idx - 1) / 2;
        while (parentIdx > 0) {
            if (compare(idx, parentIdx)) {
                swap(idx, parentIdx);
                idx = parentIdx;
            } else {
                break;
            }
        }
    }

    public void swap(int i, int j) {
        T temp = elementAt(i);
        heap[i] = elementAt(j);
        heap[j] = temp;
    }

    public boolean compare(int currIdx, int parenIdx) {
        T curr = elementAt(currIdx);
        T parent = elementAt(parenIdx);
        if (isMinHeap) {
            return curr.compareTo(parent) < 0; // return 1 curr>parent
        } else {
            return curr.compareTo(parent) > 0;
        }
    }

    @SuppressWarnings("unchecked")
    public T elementAt(int i) {
        return (T) heap[i];
    }

    public void ensureCapacity() {
        if (size == heap.length) {
            Object[] newHeap = new Object[heap.length * 2];
            for (int i = 0; i < heap.length; i++) {
                newHeap[i] = heap[i];
            }
            heap = newHeap;
        }
    }

    public void revision() {
        System.out.println("build heap(Integer only):");
        Scanner sc = new Scanner(System.in);
        boolean wantToContinue = true;
        while (wantToContinue) {
            boolean changeHeap = true;
            while (changeHeap) {
                System.out.println("select heapType: press 1 (min)/ press 2(max)");
                int heapType = sc.nextInt();
                GenericHeap<Integer> genericHeap = new GenericHeap<>(1==heapType);
                while (true) {
                    System.out.println("select Operations 1.(add), 2(poll),3(peak),4(printlevel),5(end)");
                    int operation = sc.nextInt();
                    switch (operation) {
                        case 1:
                            System.out.print("enter ele: (break: press other than integer)");
                            while (true){
                                String str = sc.next();
                                try {
                                    genericHeap.add(Integer.parseInt(str));
                                } catch (NumberFormatException e) {
                                    break;
                                }
                            }
                        case 2:
                            System.out.println(genericHeap.poll());
                        case 3:
                            try {
                                System.out.println(genericHeap.peek());
                            }catch (NoSuchElementException e){
                                System.out.println("empty heap:");
                            }
                        case 4:
                            genericHeap.printLevelWise();
                        default:
                            genericHeap.printLevelWise();
                    }
                    System.out.println("continue same heap ? press y");
                    String continueInSameHeap = sc.next();
                    if (!continueInSameHeap.equals("y")) {
                        break;
                    }
                }
            }
            System.out.println("want to buildNew Heap ? press y");
            String buildNewHeap = sc.next();
            if (!buildNewHeap.equals("y")) {
                break;
            }
        }
    }
}
