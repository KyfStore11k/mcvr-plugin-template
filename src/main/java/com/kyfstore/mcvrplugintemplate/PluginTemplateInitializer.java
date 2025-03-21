package com.kyfstore.mcvrplugintemplate;

import com.kyfstore.mcversionrenamer.libapi.core.plugin.api.PluginInitializer;
import com.kyfstore.mcversionrenamer.libapi.core.plugin.api.PluginObject;
import com.kyfstore.mcversionrenamer.libapi.core.plugin.core.main.data.PublicPluginRegistry;

import java.io.File;

public class PluginTemplateInitializer extends PluginInitializer {
    @Override
    public void onInitialize() {
        File pluginPath = new File(PublicPluginRegistry.getPluginDirectory() + "MCVRPluginTemplate-all.jar");
        setPluginMain(new PluginObject("PluginTemplate", new PluginTemplateMain(), pluginPath.getAbsolutePath(), true));
    }
}
