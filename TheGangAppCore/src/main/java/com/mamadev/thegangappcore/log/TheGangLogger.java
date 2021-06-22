package com.mamadev.thegangappcore.log;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// TODO - Make this class run on a thread of its own

public class TheGangLogger {

    private static TheGangLogger instance;

    private final StringBuilder sb = new StringBuilder();

    private final File zippedLogFile;

    TheGangLogger(File path) {
        String now = LocalDateTime.now().toString().replaceAll(":", ".");
        if (!path.exists())
            path.mkdirs();
        this.zippedLogFile = new File(path, now+".log.zip");
    }

    public void log(String log, Level level, String thread) {
        log = format(log, level, thread);
        System.out.println(log);
        sb.append(log).append("\n");
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

    private String format(String log, Level level, String thread) {
        LocalDateTime now = LocalDateTime.now();
        String currentTime = now.getMonthValue() + "/" + now.getDayOfMonth() + " " + now.getHour() + ":" + now.getMinute() + ":" +  now.getSecond();
        return "[" + currentTime + "]" + " [" + thread + "/" + level + "]: " + log;
    }


}
