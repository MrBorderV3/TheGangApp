package com.mamadev.thegangappcore.packet;

/**
 * Packet is an abstract class to transfer information, data or any sort of communication between the server and the client.
 * A packet can contain a message and contains a {@link PacketType}.
 * Any extension of the Packet can also contain more arguments.
 */
public abstract class Packet {

    private final PacketType type;
    private final String message;

    Packet(PacketType type, String message){
        this.type = type;
        this.message = message;
    }


    Packet(PacketType type){
        this(type, "");
    }

    public PacketType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public boolean hasMessage(){
        return !message.equals("");
    }
}
