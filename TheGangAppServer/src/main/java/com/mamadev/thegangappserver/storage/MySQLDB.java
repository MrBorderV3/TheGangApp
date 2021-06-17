package com.mamadev.thegangappserver.storage;

import com.mamadev.thegangappcore.log.TheGangLogger;
import me.border.utilities.database.sql.IMySQLDB;

import java.util.logging.Level;

public class MySQLDB extends IMySQLDB {

    public MySQLDB(String host, String database, String username, String password, int port) {
        super(host, database, username, password, port);
        if (!isClosed()) {
            TheGangLogger.log("Successfully connected to MySQL DB at " + "jdbc:mysql://" + host + ":" + port + "/" + database, Level.INFO);
            System.out.println("Successfully connected to MySQL DB at " + "jdbc:mysql://" + host + ":" + port + "/" + database);
        }
    }

    public void createCredentialsTable(){
        execute("CREATE TABLE IF NOT EXISTS credentials(username VARCHAR(16) NOT NULL, password VARCHAR(16) NOT NULL, private_key BLOB DEFAULT NULL, PRIMARY KEY(username))");
    }
}
