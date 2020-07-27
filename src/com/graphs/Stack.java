package com.graphs;

public class Stack {

    Integer[] stack;
    int top;

    public Stack(Integer lenghStack) {
        stack = new Integer[lenghStack];
        top = -1;
    }

    public void pushElement(Integer element) {
        if (!isFull()) {
            top++;
            stack[top] = element;
        } else {
            throw new RuntimeException("full stack");
        }
    }

    public Integer popElement() {
        if (!isEmpty()) {
            Integer element = stack[top];
            top--;
            return element;
        } else {
            throw new RuntimeException("empty stack");
        }
    }

    public boolean isFull(){
        if (top == stack.length)
            return true;
        return false;
    }

    public boolean isEmpty(){
        if (top == -1)
            return true;
        return false;
    }

}
