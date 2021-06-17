package com.mamadev.thegangappcore.util;

import com.google.common.collect.ImmutableMap;

public class Utils {

    /**
     * Create an {@link ImmutableMap} with the given objects.
     * Every odd index in the array is a key of a {@link java.util.Map.Entry} and every even index is the value of the key that came before it.
     *
     * @param objects The objects to pass onto the map
     * @return An {@link ImmutableMap} with all the objects in it.
     * @throws IndexOutOfBoundsException if the amount of objects is odd and therefore cannot be in a map.
     */
    public static ImmutableMap<?, ?> createImmutableMap(Object... objects) throws IndexOutOfBoundsException{
        int length = objects.length;
        if (length % 2 != 0){
            throw new IndexOutOfBoundsException();
        }

        ImmutableMap.Builder<Object, Object> builder = ImmutableMap.builder();
        for (int i = 0; i < length; i += 2){
            builder.put(objects[i], objects[i+1]);
        }

        return builder.build();
    }
}
