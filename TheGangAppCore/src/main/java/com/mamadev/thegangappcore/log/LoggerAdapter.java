package com.mamadev.thegangappcore.log;

import com.mamadev.thegangappcore.packet.Packet;
import me.border.utilities.communication.tcp.core.base.TCPConnection;

import java.util.logging.Level;

public class LoggerAdapter {

    public static void logReceived(Packet packet, TCPConnection connection, Level level){
        TheGangLogger.getInstance().logReceived(packet, connection, level);
    }

    public static void logSent(Packet packet, TCPConnection connection, Level level) {
        TheGangLogger.getInstance().logSent(packet, connection, level);
    }

    public static void log(String log, Level level){
        TheGangLogger.getInstance().log(log, level);
    }
    public static void logSevere(String log){
        TheGangLogger.getInstance().log(log, Level.SEVERE);
    }

    public static void save() {
        TheGangLogger.getInstance().save();
    }
}
