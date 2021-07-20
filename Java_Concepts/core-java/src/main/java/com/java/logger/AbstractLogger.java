package com.java.logger;

public abstract class AbstractLogger implements Logger {

    protected Level configuredLevel;
    protected AbstractLogger nextLogger;

    public void setNext(AbstractLogger next) {
        this.nextLogger = next;
    }

    public boolean isDebugEnabled() {
        return Level.DEBUG == this.configuredLevel;
    }

    public void log(Level level, String msg) {
        if(Level.canLogAtThisLevel(configuredLevel, level)) {
            write(msg);
        }
        if(nextLogger != null) {
            nextLogger.log(level, msg);
        }
    }

    abstract protected void write(String msg);
}
