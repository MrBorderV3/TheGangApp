package com.mamadev.thegangappcore.log;

import java.util.logging.Level;
import java.util.logging.Logger;
//TODO - Both server and client will use this class to initiate their own logger that writes to a log file of its own and to the console
// (each initialization has a different log file) the log files are to be stored as a zip to avoid using too much space
public class TheGangLogger {

    public static void log(String log, Level level){

    }

    public static void logError(String log){
        log(log, Level.SEVERE);
    }
}
