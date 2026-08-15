package com.mycompany.postfix;
import java.util.Arrays;
public class Stack {

    private int t = -1 , temp = 0;
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
        arr[t+1] = item;
        t++;
    }
    
    public int pop(){
        if(isEmpty()){
            temp = -1;
        }
        else{
            temp = arr[t];
            t--;
        }
        return temp;
    }
    
    public int top(){
        if(isEmpty()){
            temp = -1;
        }
        else{
            temp = arr[t];
        }
        return temp;
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
