package com.mamadev.thegangappcore.packet;

/**
 * A {@link Packet} sent from either the server or the client to each other to signify it is ceasing communication.
 * A client sends this packet when closing the app.
 * the server sends this packet when shutting down for whatever reason forcing all connected clients to close the app.
 */
public class CeasePacket extends Packet {

    CeasePacket() {
        super(PacketType.CEASE);
    }
}
