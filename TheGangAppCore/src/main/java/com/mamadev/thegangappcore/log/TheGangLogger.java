package com.mamadev.thegangappcore.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TheGangLogger {

    public static void log(String log, Level level){

    }

    public static void logError(String log){
        log(log, Level.SEVERE);
    }
}
