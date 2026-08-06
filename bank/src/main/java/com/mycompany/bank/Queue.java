package com.mycompany.bank;

public class Queue {

    private int arr[];
    private int front, rear, count;
    private int countQueue = 1;

    public Queue() {
        this(0);
    }

    public Queue(int size) {
        this.arr = new int[size];
        this.count = 0;
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int item) {
        if (!isFull()) {
            if (isEmpty()) {
                this.front = 0;
                this.rear = 0;
                arr[rear] = item;
                countQueue++;
                count++;
            } else {
                rear = (rear + 1) % arr.length;
                arr[rear] = item;
                countQueue++;
                count++;
            }
        } else {
            System.out.println("Queue is full");
        }
    }

    public int dequeue() {
        int data = -1;
        if (!isEmpty()) {
            data = arr[this.front];
            if (front == rear) {
                this.front = -1;
                this.rear = -1;
            } else {
                front = (front + 1) % arr.length;
            }
            count--;
        } else {
            System.out.print("empty");
        }
        return data;
    }

    public boolean isEmpty() {
        return this.front == -1 && this.rear == -1;
    }

    boolean isFull() {
        return count == size();
    }

    int size() {
        return this.arr.length;
    }

   
    public void showActive() {
        System.out.print("active(" + count + ") =");
        for (int i = 0; i < count; i++) {
            System.out.print(" " + arr[(front + i) % arr.length]);
        }
        System.out.println();
    }

    public int getCountqueue() {
        return countQueue;
    }
}
