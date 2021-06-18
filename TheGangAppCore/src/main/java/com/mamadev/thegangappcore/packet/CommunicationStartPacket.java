package com.mamadev.thegangappcore.packet;

import java.security.PublicKey;

/**
 * A {@link Packet} sent from both the server and the client when the communication starts to send each other their public keys.
 */
public class CommunicationStartPacket extends Packet {

    private final PublicKey publicKey;

    CommunicationStartPacket(PublicKey publicKey) {
        super(PacketType.COMMUNICATION_START);
        this.publicKey = publicKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
