package com.jetnet.generics;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HtcTests {

    @Test
    public void demonstrate_Htc() {
        HeterogeneousTypesafeContainer container = new HeterogeneousTypesafeContainer();
        container.put(String.class, "Feeling great");
        container.put(Integer.class, 0xcafebabe);
        container.put(Class.class, HeterogeneousTypesafeContainer.class);

        List<?> things = Arrays.asList(
            container.get(String.class),
            container.get(Integer.class),
            container.get(Class.class));

        things.forEach(System.out::println);
    }
}
