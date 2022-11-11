package com.practice.etc;

public class Stack {
    int[] stack;
    int top = -1;

    public Stack(int size) {
        stack = new int[size];
    }

    public void push(int data) {
        if (top == stack.length - 1) {
            throw new RuntimeException();
        }

        stack[++top] = data;
    }

    public int pop() {
        if (top == -1) {
            throw new RuntimeException();
        }

        return stack[top--];
    }

    public int peek() {
        if (top == -1) {
            throw new RuntimeException();
        }

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }
}
