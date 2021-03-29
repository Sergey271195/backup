package ru.hh.interviewme;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class TestContainerBase {

    @Container
    static final PostgreSQLContainer<?> container = PostgresTestContainerBase.getInstance();

    static {
        System.out.println("ABSTRACT");
        container.withInitScript("init.sql").start();
    }

}
