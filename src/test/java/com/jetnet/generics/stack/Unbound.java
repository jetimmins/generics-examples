package com.jetnet.generics.stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class Unbound {
    private final UnboundedStack<Number> unboundedNumbersStack = new UnboundedStack<>();
    private final UnboundedStack<Integer> unboundedIntegerStack = new UnboundedStack<>();

    @Test
    public void no_covariance() {
        Iterable<Integer> ints = new ArrayList<>();
        unboundedNumbersStack.push(ints.iterator().next());
        //unboundedNumbersStack.pushAll(ints);
    }

    @Test
    public void no_contravariance() {
        Number number = unboundedIntegerStack.pop();
        Collection<Number> popAll = new ArrayList<>();
        //unboundedIntegerStack.popAllInto(popAll);
    }
}
