package com.java.logger;

import java.awt.datatransfer.FlavorEvent;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(Level level) {
        this.configuredLevel = level;
    }

    public void write(String message) {
        System.out.println(message);
    }
}
