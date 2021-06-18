package com.mamadev.thegangappcore.log;

import com.mamadev.thegangappcore.packet.Packet;
import me.border.utilities.communication.base.Connection;
import me.border.utilities.communication.tcp.core.base.TCPConnection;
import me.border.utilities.scheduler.AsyncTasker;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// TODO - Make this class run on a thread of its own

public class TheGangLogger {

    private static TheGangLogger instance;

    private final StringBuilder sb = new StringBuilder();

    private final File zippedLogFile;

    private TheGangLogger(File path){
        String now = LocalDateTime.now().toString().replaceAll(":", ".");
        this.zippedLogFile = new File(path, now+".log.zip");
    }

    public void logReceived(Packet packet, TCPConnection connection, Level level){
        String log = format("Packet of type " + packet.getType() + " received from " + connection.getSocket().toString() + " with", level);
        if (packet.hasMessage()){
            log = log + " the message " + packet.getMessage();
            System.out.println(log);
        } else {
            log = log + "out a message";
        }
        appendLog(log);
    }

    public void logSent(Packet packet, TCPConnection connection, Level level) {
        String log = format("Packet of type " + packet.getType() + " sent at " + connection.getSocket().toString() + " with", level);
        if (packet.hasMessage()){
            log = log + " the message " + packet.getMessage();
            System.out.println(log);
        } else {
            log = log + "out a message";
        }
        appendLog(log);
    }

    public void log(String log, Level level){
        log = format(log, level);
        System.out.println(log);
        appendLog(log);
    }


    public void save() {
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zippedLogFile));
            ZipEntry e = new ZipEntry(zippedLogFile.getName().replace(".zip", ""));

            zos.putNextEntry(e);
            zos.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            zos.flush();

            zos.closeEntry();
            zos.close();
            sb.setLength(0);
            System.out.println("Successfully saved logs!\n" +
                    "Path: " + zippedLogFile.getAbsolutePath());
        } catch (IOException e) {
            LoggerAdapter.logSevere("Failed to save logs!\n" +
                    "Path: " + zippedLogFile.getAbsolutePath() + "\n" +
                    "Stacktrace: " + ExceptionUtils.getStackTrace(e));
        }
    }

    private void appendLog(String log){
        sb.append(log).append("\n");
    }

    private String format(String log, Level level){
        LocalDateTime now = LocalDateTime.now();
        String currentTime = now.getMonthValue() + "/" + now.getDayOfMonth() + " " + now.getHour() + ":" + now.getMinute() + ":" +  now.getSecond();
        return "[" + currentTime + "]" + " [" + Thread.currentThread().getName() + "/" + level + "]: " + log;
    }

    public static void init(File logFolder) {
        if (instance == null)
            instance = new TheGangLogger(logFolder);
    }

    public static TheGangLogger getInstance(){
        return instance;
    }
}
