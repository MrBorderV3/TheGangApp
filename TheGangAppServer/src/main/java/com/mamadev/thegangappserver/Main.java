package com.mamadev.thegangappserver;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mamadev.thegangappcore.log.TheGangLogger;
import com.mamadev.thegangappserver.constants.Constants;
import com.mamadev.thegangappserver.storage.MySQLDB;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    private static MySQLDB db;

    public static void main(String[] args) {
        startDB();
    }

    public static void startDB() {
        try {
            JsonObject jsonObj = (JsonObject) JsonParser.parseReader(new FileReader(Constants.DB_CREDENTIALS_FILE));

            String host = jsonObj.get("host").getAsString();
            String database = jsonObj.get("database").getAsString();
            String username = jsonObj.get("username").getAsString();
            String password = jsonObj.get("password").getAsString();
            int port = jsonObj.get("port").getAsInt();

            db = new MySQLDB(host, database, username, password, port);
        } catch (FileNotFoundException e) {
            TheGangLogger.logError("File not found! Path: \"" + Constants.DB_CREDENTIALS_FILE + "\"\n" +
                    "Stacktrace: " + ExceptionUtils.getStackTrace(e));
            System.exit(0);
            return;
        }

        db.createCredentialsTable();
    }
}
