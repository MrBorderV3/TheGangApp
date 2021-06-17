package com.mamadev.thegangappcore.packet;

import com.google.common.collect.ImmutableMap;

public abstract class Packet {

    private final PacketType type;

    Packet(PacketType type){
        this.type = type;
    }
}
