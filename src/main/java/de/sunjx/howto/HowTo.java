package de.sunjx.howto;

import de.sunjx.howto.commands.CourseCommand;
import de.sunjx.howto.commands.HowTwoCommand;
import de.sunjx.howto.listener.PlayerJoinEventListener;
import de.sunjx.howto.manager.ConfigManager;
import de.sunjx.howto.manager.CourseManager;
import de.sunjx.howto.manager.OSManager;
import de.sunjx.howto.manager.ScoreboardManager;
import de.sunjx.howto.utils.Data;
import de.sunjx.howto.utils.Language;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author reaL on 05.04.2020 at 02:23
 * All rights reserved to @author reaL, SunsetGFX or Shortlog.
 * @project HowTo
 **/
public class HowTo extends JavaPlugin {

    private static HowTo instance;
    private static PluginManager pm;
    private static Language language;
    private static ConfigManager cm;
    private static Data data;
    private static CourseManager courseManager;
    private static OSManager osManager;
    private static ScoreboardManager scoreboardManager;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        cm = new ConfigManager("config.yml");

        if(cm.getString("Settings.Language").equalsIgnoreCase("de")) {
            language = Language.GERMAN;
            language.setFilePath(new File("plugins//HowTwo//locals", "german.yml"));
        } else if(cm.getString("Settings.Language").equalsIgnoreCase("en")){
            language = Language.ENGLISH;
            language.setFilePath(new File("plugins//HowTwo//locals", "english.yml"));
        } else {
            System.out.println("No Language found. Using English one..");
            language = Language.ENGLISH;
            language.setFilePath(new File("plugins//HowTwo//locals", "english.yml"));
        }

        data = new Data();

        ////////////////////////////////

        pm = getServer().getPluginManager();
        courseManager = new CourseManager();
        osManager = new OSManager();
        scoreboardManager = new ScoreboardManager();

        getCommand("howto").setExecutor(new HowTwoCommand());
        getCommand("course").setExecutor(new CourseCommand());

        logConsole(getData().getPrefix() + "§8OS Found: §e" + osManager.getOS());

        pm.registerEvents(new PlayerJoinEventListener(), this);

        Language.getSupportedLangauges().add("de");
        Language.getSupportedLangauges().add("en");

    }
    public void onDisable() {

    }

    private void logConsole(String message) {
        getServer().getConsoleSender().sendMessage(message);
    }

    public ConfigManager getConfigManager() {
        return cm;
    }

    public static HowTo getInstance() {
        return instance;
    }

    public static String getLangString() {
        return cm.getString("Settings.Language");
    }

    public Language getLanguage() {
        return language;
    }

    public Data getData() {
        return data;
    }

    public CourseManager getCourseManager() {
        return courseManager;
    }

    public OSManager getOsManager() {
        return osManager;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }
}
