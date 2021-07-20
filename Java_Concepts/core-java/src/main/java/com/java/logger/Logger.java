package com.java.logger;

public interface Logger {

    void log(Level level, String message);

    boolean isDebugEnabled();

}
