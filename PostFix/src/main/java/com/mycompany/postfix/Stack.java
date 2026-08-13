package com.mycompany.postfix;
import java.util.Arrays;
public class Stack {

    private int t = -1;
    private int arr[];

    public Stack() {
        this(10);
    }

    public Stack(int size) {
        this.arr = new int[size];
    }
    
    public void push (int item){
        if(isFull()){
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
    }
    
    public int pop(){
        return 0;
    }
    
    public boolean isFull(){
        return  size() == arr.length;
    }
    
    public boolean isEmpty(){
        return t < 0;
    }
    
    public int size(){
        return t+1;
    }
}
