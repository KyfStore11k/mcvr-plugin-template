package com.kyfstore.mcvrplugintemplate;

import com.kyfstore.mcversionrenamer.async.logger.AsyncLogger;
import com.kyfstore.mcversionrenamer.plugin.api.PluginMain;
import com.kyfstore.mcversionrenamer.plugin.api.logger.LoggerAPI;
import com.kyfstore.mcversionrenamer.plugin.api.minecraft.client.ClientAPI;
import com.kyfstore.mcversionrenamer.plugin.main.control.PluginAPI;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

import java.util.Random;

public class PluginTemplateMain extends PluginMain {

    private final PluginAPI api;
    private final Random random = new Random();

    public PluginTemplateMain(PluginAPI api) {
        this.api = api;
    }

    @Override
    public void onMainCall() {
        LoggerAPI loggerAPI = new LoggerAPI();
        loggerAPI.onEnable();
        AsyncLogger logger = loggerAPI.getLogger();

        logger.info("This is a message sent from MCVRPluginTemplate!");

        double randomValue = random.nextDouble() * 100.0;
        PluginTemplateEvent eventToSend = new PluginTemplateEvent("Hello from a random event!", randomValue);

        api.subscribe(PluginTemplateEvent.class, (eventObj) -> {
            PluginTemplateEvent ev = (PluginTemplateEvent) eventObj;
            logger.info("Caught event! Random Number: " + ev.getRandomNumber() + ", message is: " + ev.getMessage());
            return kotlin.Unit.INSTANCE;
        });

        api.sendEvent(eventToSend);

        ClientAPI clientAPI = new ClientAPI();
        clientAPI.onEnable();

        Thread checkWindowThread = new Thread(() -> {
            try {
                Object unwrappedHandle = clientAPI.chain().invokeMethod("getWindow").invokeMethod("handle").unwrap();

                while (unwrappedHandle instanceof Long && (Long) unwrappedHandle != 0L || clientAPI.invokeClientMethod("getWindow") == null) {
                    Thread.sleep(50);
                }

                long handle = Minecraft.getInstance().getWindow().handle();
                logger.info("Window handle is: " + handle);
                logger.info("Window title is: " + GLFW.glfwGetWindowTitle(handle));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        checkWindowThread.setDaemon(true);
        checkWindowThread.setName("Window-Handle-Checker");
        checkWindowThread.start();
    }
}