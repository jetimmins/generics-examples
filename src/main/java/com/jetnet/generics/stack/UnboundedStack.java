package com.jetnet.generics.stack;

import java.util.Collection;

public class UnboundedStack<E> {
    public void push(E element) {
        System.out.println(element + " pushed");
    }

    public void pushAll(Iterable<E> elements) {
        for (E e : elements) {
            push(e);
        }
    }

    public E pop() {
        return null;
    }

    public void popAllInto(Collection<E> destination) {
        while(!isEmpty()) {
            destination.add(pop());
        }
    }

    public boolean isEmpty() {
        return false;
    }
}
