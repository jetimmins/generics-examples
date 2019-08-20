package com.jetnet.generics.stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StackTest {
    UnboundedStack<Number> unboundedStack = new UnboundedStackImpl<>();

    @Test
    public void fail() {
        Iterable<Integer> ints = new ArrayList<>();
        unboundedStack.push(ints.iterator().next());
        //invalid type
        //unboundedStack.pushAll(ints);
    }
}
