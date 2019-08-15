package com.jetnet.generics;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Examples {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void arraysAreCovariant_genericTypesAreNot() {
        String[] stringArray = new String[0];
        Object[] objectArray = stringArray;

        List<String> stringList = new ArrayList<>();
        //incompatible types
        //List<Object> objectList = stringList;
    }

    @Test
    public void genericsWithVarargs() {
        List<String> one = Arrays.asList("one", "two");
        List<String> two = Arrays.asList("three", "four");
        List<List<String>> result = faultyVarargs(one, two);

        expectedException.expect(ClassCastException.class);
        String notAString = result.get(1).get(0);
    }

    private List<List<String>> faultyVarargs(List<String>... stringLists) {
        Object[] objectArray = stringLists;
        objectArray[1] = Collections.singletonList(42);
        return Arrays.asList(stringLists);
    }

    @Test
    public void genericWildCardHasCovariance() {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        List<List<?>> genericCommonParent = Arrays.asList(stringList, integerList);
        List<?> someList = genericCommonParent.get(0);
        //incompatible types
        //someList.add(42);
        someList.add(null);
    }
}
