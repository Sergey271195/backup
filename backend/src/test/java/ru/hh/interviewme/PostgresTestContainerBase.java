package ru.hh.interviewme;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public class PostgresTestContainerBase extends PostgreSQLContainer<PostgresTestContainerBase> {
    
    private static final String IMAGE_VERSION = "postgres:10.7-alpine";
    @Container
    private static PostgresTestContainerBase container;

    private PostgresTestContainerBase() {
        super(IMAGE_VERSION);
    }

    public static PostgresTestContainerBase getInstance() {
        if (container == null) {
            container = new PostgresTestContainerBase();
        }
        return container;
    }

    @Override
    public void start() {
        System.out.println("STARTTING");
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
        System.out.println(container.getJdbcUrl());
    }

    @Override
    public void stop() {

    }

}
