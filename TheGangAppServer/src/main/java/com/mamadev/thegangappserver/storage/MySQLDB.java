package com.mamadev.thegangappserver.storage;

import com.mamadev.thegangappcore.log.LoggerAdapter;
import com.mamadev.thegangappcore.log.TheGangLogger;
import me.border.utilities.database.sql.IMySQLDB;

import java.util.logging.Level;

/**
 * Class representing the server's MySQL Database. The class is not a singletone by pattern but should only be initialized once.
 */
public class MySQLDB extends IMySQLDB {

    public MySQLDB(String host, String database, String username, String password, int port) {
        super(host, database, username, password, port);
        if (!isClosed()) {
            LoggerAdapter.log("Successfully connected to MySQL DB at " + "jdbc:mysql://" + host + ":" + port + "/" + database, Level.INFO);
        }
    }

    public void createCredentialsTable(){
        execute("CREATE TABLE IF NOT EXISTS credentials(username VARCHAR(16) NOT NULL, password VARCHAR(16) NOT NULL, private_key BLOB DEFAULT NULL, PRIMARY KEY(username))");
    }
}
