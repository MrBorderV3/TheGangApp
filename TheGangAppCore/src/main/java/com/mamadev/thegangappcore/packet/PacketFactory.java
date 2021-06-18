package com.mamadev.thegangappcore.packet;

import com.mamadev.thegangappcore.log.LoggerAdapter;
import com.mamadev.thegangappcore.log.TheGangLogger;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Factory class for easy {@link Packet} creation.
 */
public class PacketFactory {

    /**
     * Create a packet of the given type with the given arguments in its constructor.
     *
     * The method will search for a constructor with the given parameter types in the given packet
     * if its finds one it will init the constructor with the given arguments.
     *
     * If the method fails to create the packet in any way it will log it in the {@link TheGangLogger} and return {@code null}.
     *
     * @param type The type of packet to create
     * @param args The args to init it with
     *
     * @return The corresponding {@link Packet}
     */
    public static Packet createPacket(PacketType type, Object... args) {
        Class<?>[] parameterTypes = new Class<?>[args.length];
        Arrays.stream(args).collect(Collectors.toList()).forEach(new Consumer<>() {
            private int counter = 0;

            @Override
            public void accept(Object o) {
                parameterTypes[counter] = o.getClass();
                counter++;
            }
        });

        try {
            return PacketType.packetDictionary.get(type).getDeclaredConstructor(parameterTypes).newInstance(args);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            LoggerAdapter.logSevere("Failed to create a packet!\n" +
                    "Parameter types: " + Arrays.toString(parameterTypes) + "\n" +
                    "Arguments: " + Arrays.toString(args) + "\n" +
                    "Stacktrace: " + ExceptionUtils.getStackTrace(e));
            return null;
        }
    }
}
