package com.kyfstore.mcvrplugintemplate;

import com.kyfstore.mcversionrenamer.async.logger.AsyncLogger;
import com.kyfstore.mcversionrenamer.plugin.api.PluginMain;
import com.kyfstore.mcversionrenamer.plugin.api.logger.LoggerAPI;

public class PluginTemplateMain extends PluginMain {

    @Override
    public void onMainCall() {
        LoggerAPI loggerAPI = new LoggerAPI();
        loggerAPI.onEnable();

        AsyncLogger logger = loggerAPI.getLogger();

        logger.info("This is a message from the Plugin Template!");
    }
}
