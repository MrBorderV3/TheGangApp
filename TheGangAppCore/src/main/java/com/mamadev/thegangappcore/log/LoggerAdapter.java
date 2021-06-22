package com.mamadev.thegangappcore.log;

import com.mamadev.thegangappcore.packet.Packet;
import me.border.utilities.communication.tcp.core.base.TCPConnection;

import java.io.File;
import java.util.logging.Level;

public class LoggerAdapter {

    private static TheGangLogger logger;

    public static void logReceived(Packet packet, TCPConnection connection, Level level, String thread) {
        String log = "Packet of type " + packet.getType() + " received from " + connection.getSocket().toString() + " with";
        if (packet.hasMessage()){
            log = log + " the message " + packet.getMessage();
        } else {
            log = log + "out a message";
        }

        log(log, level);
    }

    public static void logSent(Packet packet, TCPConnection connection, Level level, String thread) {
        String log = "Packet of type " + packet.getType() + " sent at " + connection.getSocket().toString() + " with";
        if (packet.hasMessage()){
            log = log + " the message " + packet.getMessage();
        } else {
            log = log + "out a message";
        }

        log(log, level);
    }

    public static void logSevere(String log){
        logger.log(log, Level.SEVERE, Thread.currentThread().getName());
    }

    public static void log(String log, Level level){
        logger.log(log, level, Thread.currentThread().getName());
    }

    public static void save() {
        logger.save();
    }

    public static void init(File logFolder) {
        if (logger == null)
            logger = new TheGangLogger(logFolder);
    }
}
