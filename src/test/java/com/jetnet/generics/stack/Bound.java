package com.jetnet.generics.stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class Bound {
    private final BoundedStack<Number> boundedNumbersStack = new BoundedStack<>();
    private final BoundedStack<Integer> boundedIntegerStack = new BoundedStack<>();

    @Test
    public void covariance_from_bounds() {
        Iterable<Integer> ints = new ArrayList<>();
        boundedNumbersStack.push(ints.iterator().next());
        boundedNumbersStack.pushAll(ints);
    }

    @Test
    public void contravariance_from_bounds() {
        Number number = boundedIntegerStack.pop();
        Collection<Number> popAll = new ArrayList<>();
        boundedIntegerStack.popAllInto(popAll);
    }
}
