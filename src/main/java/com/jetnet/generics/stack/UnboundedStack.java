package com.jetnet.generics.stack;

public class UnboundedStackImpl<E> implements UnboundedStack<E> {
    @Override
    public void push(E element) {
        System.out.println(element + " pushed");
    }

    @Override
    public void pushAll(Iterable<E> elements) {
        for (E e : elements) {
            push(e);
        }
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
