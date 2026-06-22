package com.billing.cdrparser;

import com.telecom.postgrescore.Database;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.jooq.DSLContext;

public class DatabaseAdaptor {
    public static DSLContext connect() throws FileNotFoundException, IOException  {
        Properties props = new Properties();
        props.load(new FileInputStream("db.properties"));
        
        Database database = new Database(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> database.close()));
        
        return database.getDSLContext();
    }
}
