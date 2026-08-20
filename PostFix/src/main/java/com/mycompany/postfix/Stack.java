package com.mycompany.postfix;

public class Stack {
    private Node topNode; 
    private int size;     

    public Stack() {
        this.topNode = null;
        this.size = 0;
    }

    public Stack(int size) {
        this.topNode = null;
        this.size = 0;
    }

    public void push(int item) {
        Node newNode = new Node(item);
        newNode.next = topNode;
        topNode = newNode;      
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int poppedData = topNode.data;
        topNode = topNode.next; 
        size--;
        return poppedData;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return topNode.data;
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    public boolean isFull() {
     
        return false;
    }

    public int size() {
        return size;
    }
}