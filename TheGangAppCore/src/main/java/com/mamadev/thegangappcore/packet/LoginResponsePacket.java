package com.mamadev.thegangappcore.packet;

import com.mamadev.thegangappcore.profile.User;

import javax.annotation.Nullable;

/**
 * A packet sent by the server in response to a {@link LoginRequestPacket}.
 * This packet is a {@link BooleanPacket} so it holds a true/false answer.
 * If {@code false} the client login credentials are wrong and the client will be unable to enter the app.
 * If {@code true} the client login credentials are right and the client will be able to log in and the server will also send the client the {@link User} data.
 */
public class LoginResponsePacket extends BooleanPacket {

    private final User user;

    LoginResponsePacket(boolean response, @Nullable User user) {
        super(PacketType.LOGIN_RESPONSE, response);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
