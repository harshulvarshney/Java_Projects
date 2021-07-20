package com.java.logger;

public enum Level {

    DEBUG(0),
    INFO(10),
    WARN(20),
    ERROR(30);

    int priority;

    Level(int p) {
        this.priority = p;
    }

    static boolean canLogAtThisLevel(Level configuredLevel, Level passedLevel) {
        return configuredLevel.priority <= passedLevel.priority;
    }

}
