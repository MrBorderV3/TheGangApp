package com.mamadev.thegangappcore.packet;

/**
 * An abstract type of {@link Packet} that always has a boolean answer, either {@code true} or {@code false}.
 */
public abstract class BooleanPacket extends Packet {
    private final boolean response;

    BooleanPacket(PacketType type, String message, boolean response) {
        super(type, message);
        this.response = response;
    }

    BooleanPacket(PacketType type, boolean response) {
        super(type);
        this.response = response;
    }

    public boolean getResponse() {
        return response;
    }
}
