package com.olegshishkin.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class App {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main( String[] args ) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(9090)
                .addService(new SimpleServiceImpl())
                .build();

        server.start();
        LOGGER.warn("Server started at port {}", server.getPort());
        server.awaitTermination();
    }
}
