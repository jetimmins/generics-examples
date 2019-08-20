package com.jetnet.generics;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ArrayExamples {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void raw_vs_generics() {
        List badList = new ArrayList();
        badList.add("garbage");
        badList.add(0xcafebabe);

        expectedException.expect(ClassCastException.class);
        String horrendous = (String)badList.get(1);

        List<String> wonderful = new ArrayList<>();
        wonderful.add("glorious");
        String glorious = wonderful.get(0);
    }

    @Test
    public void arrays_are_covariant() {
        String[] stringArray = new String[2];
        Object[] objectArray = stringArray;
        objectArray[0] = "";
        objectArray[1] = 1;
    }

    @Test
    public void generic_collections_are_invariant() {
        List<String> stringList = new ArrayList<>();
//        //incompatible types
//        List<Object> objectList = stringList;
//        objectList.add("whatever");
    }

    public void horrible(List<?> args) {
        System.out.println(args);
    }

    public void callHorrible() {
        String disgusting = "disgusting";
        List<String> strings = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        strings.add(disgusting);
        objects.add(disgusting);

        horrible(objects);
        //horrible(strings);
    }

    @Test
    public void generic_wildcard_has_covariance() {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        List<List<?>> genericCommonParent = Arrays.asList(stringList, integerList);
        List<?> someList = genericCommonParent.get(0);
//       someList.add(42);
//       someList.add(null);
    }

    @Test
    public void and_never_the_two_shall_meet() {
//        List<String>[] genericArr = new List<String>[0];
    }

    @Test
    public void generic_Varargs_Can_Cause_Heap_Pollution() {
        List<String> one = java.util.Arrays.asList("one", "two");
        List<String> two = java.util.Arrays.asList("three", "four");
        List<List<String>> result = faultyVarargs(one, two);

        expectedException.expect(ClassCastException.class);
        String notAString = result.get(1).get(0);
    }

    private final List<List<String>> faultyVarargs(List<String>... stringLists) {
        Object[] objectArray = stringLists;
        objectArray[1] = Collections.singletonList(42);
        return Arrays.asList(stringLists);
    }


}
