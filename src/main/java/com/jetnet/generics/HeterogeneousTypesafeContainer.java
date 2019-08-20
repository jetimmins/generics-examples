package com.jetnet.generics;

import java.util.HashMap;
import java.util.Map;

public class HeterogeneousTypeContainer {
    private final Map<Class<?>, Object> map = new HashMap<>();

    public <T> void put(Class<T> type, T arg) {
        map.put(type, arg);
    }

    public <T> T get(Class<T> type) {
        return type.cast(map.get(type));
    }
}
