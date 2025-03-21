package com.kyfstore.mcvrplugintemplate;

import com.kyfstore.mcversionrenamer.libapi.core.plugin.api.PluginMain;
import com.kyfstore.mcversionrenamer.libapi.core.plugin.api.logger.LoggerAPI;
import org.slf4j.Logger;

public class PluginTemplateMain extends PluginMain {

    @Override
    public void onMainCall() {
        LoggerAPI loggerAPI = new LoggerAPI();
        loggerAPI.onEnable();

        Logger logger = loggerAPI.getLogger();

        logger.info("This is a message from the Plugin Template!");
    }
}
