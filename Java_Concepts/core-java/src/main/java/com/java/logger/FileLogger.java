package com.java.logger;

import java.io.File;

public class FileLogger extends AbstractLogger {

    public FileLogger(Level level) {
        this.configuredLevel = level;
    }

    @Override
    public void write(String msg) {
        System.out.println("File::Logger: " + msg);
    }

}
