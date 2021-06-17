package com.mamadev.thegangappcore.packet;

import java.security.PublicKey;

public class CommunicationStartPacket extends Packet{

    private final PublicKey publicKey;

    CommunicationStartPacket(PublicKey publicKey) {
        super(PacketType.COMMUNICATION_START);
        this.publicKey = publicKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
