package me.dio.junit;

import java.util.logging.Logger;

public class DatabaseConnectorManager {

    private static final Logger LOGGER = Logger.getLogger(DatabaseConnectorManager.class.getName());

    public static void startConnection(){
        LOGGER.info("Iniciou conexão");
    }

    public static void endConnection(){
        LOGGER.info("Finalizou conexão");
    }

    public static void createData(Person person){
        LOGGER.info("inserido dados");
    }
}
