package com.mamadev.thegangappcore.packet;

/**
 * A {@link Packet} sent by the client when attempting to log in.
 * this packet holds the encrypted credentials sent by the user which the server will decrypt and compare against the DB.
 * The server will respond with the {@link LoginResponsePacket} to this packet.
 */
public class LoginRequestPacket extends Packet {

    LoginRequestPacket() {
        super(PacketType.LOGIN_REQUEST);
    }
}
