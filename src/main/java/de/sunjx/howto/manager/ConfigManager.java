package de.sunjx.howto.manager;

import de.sunjx.howto.HowTo;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author reaL on 05.04.2020 at 03:04
 * All rights reserved to @author reaL or Shortlog.
 * @project HowTo
 **/
public class ConfigManager {

    private File file;
    private YamlConfiguration configuration;

    private final String PATH = HowTo.getInstance().getDataFolder().getPath();

    public ConfigManager(String yamlFile) {
        file = new File(PATH, yamlFile);
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public ConfigManager(String path, String yamlFile) {
        file = new File(path, yamlFile);
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfiguration() {
        return configuration;
    }

    public void set(String where, Object value) {
        getConfiguration().set(where, value);
        saveFiles();
    }

    public String getString(String where) {
        return getConfiguration().getString(where);
    }

    private void saveFiles() {
        try {
            getConfiguration().save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPATH() {
        return PATH;
    }
}
