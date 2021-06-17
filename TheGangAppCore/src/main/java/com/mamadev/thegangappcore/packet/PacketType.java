package com.mamadev.thegangappcore.packet;

import com.google.common.collect.ImmutableMap;
import com.mamadev.thegangappcore.util.Utils;

/**
 * Enum class of {@link Packet} types.
 */
public enum PacketType {

    CEASE, COMMUNICATION_START, LOGIN_REQUEST, LOGIN_RESPONSE;

    @SuppressWarnings("unchecked")
    static final ImmutableMap<PacketType, Class<? extends Packet>> packetDictionary = (ImmutableMap<PacketType, Class<? extends Packet>>) Utils.createImmutableMap(
            COMMUNICATION_START, CommunicationStartPacket.class,
            LOGIN_REQUEST, LoginRequestPacket.class,
            LOGIN_RESPONSE, LoginResponsePacket.class,
            CEASE, CeasePacket.class);
}
