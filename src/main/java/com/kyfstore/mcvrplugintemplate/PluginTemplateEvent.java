package com.kyfstore.mcvrplugintemplate;

public class PluginTemplateEvent {
    private final String message;
    private final double randomNumber;

    public PluginTemplateEvent(String message, double randomNumber) {
        this.message = message;
        this.randomNumber = randomNumber;
    }

    public String getMessage() {
        return message;
    }

    public double getRandomNumber() {
        return randomNumber;
    }
}