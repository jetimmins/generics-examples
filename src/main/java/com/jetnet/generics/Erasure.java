package com.jetnet.generics;

public class Erasure {

    public class Node<T> {

        private T element;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() { return element; }
    }

    public class $Node {

        private Object element;
        private Node next;

        public $Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Object getElement() { return element; }
    }


}
