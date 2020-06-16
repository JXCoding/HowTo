package de.sunjx.howto.utils;

import de.sunjx.howto.HowTo;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author reaL on 05.04.2020 at 17:33
 * All rights reserved to @author reaL or Shortlog.
 * @project HowTo
 **/
public enum Language {

    GERMAN(new File("plugins//HowTwo//locals", "german.yml")),
    ENGLISH(new File("plugins//HowTwo//locals", "english.yml"));

    private File filePath;
    private final File localsFolderPath = new File("plugins//HowTwo//locals");

    private static ArrayList<String> supportedLangauges = new ArrayList<String>();

    Language(File filePath) {
        this.filePath = filePath;
        if(!localsFolderPath.exists()) {
            init();
        }
    }

    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }

    public File getFilePath() {
        return filePath;
    }

    public void init() {
        //folder here.
        if(!localsFolderPath.exists()) {
            localsFolderPath.mkdirs();
            System.out.println("Created Folder");
        }

        //German here
        setFilePath(new File("plugins//HowTwo//locals", "german.yml"));
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(getFilePath());
        if(!getFilePath().exists()) {
            try {
                getFilePath().createNewFile();
                //Defaults here
                cfg.set("NoPermissions", "&cDu hast nicht die Berechtigung, den Befehl auszuführen.");
                cfg.set("NoPlayer", "&cDu musst ein Spieler sein!");
                cfg.set("JoinMessage", "&7Hallo &b@%player%&7, wenn du das Tutorial starten willst, führe &9/course" + " §7aus. %n%Dort wirst du weitere Hilfe bekommen.");
                cfg.set("AlreadyInCourse", "&7Du bist bereits im Kurs eingetragen. %n%Wenn du fortfahren möchtest, benutze &9/course continue &7.");

                cfg.save(getFilePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //English here
        setFilePath(new File("plugins//HowTwo//locals", "english.yml"));
        cfg = YamlConfiguration.loadConfiguration(getFilePath());
        if(!getFilePath().exists()) {
            try {
                getFilePath().createNewFile();
                //Defaults here
                cfg.set("NoPermissions", "&cYou dont have the permissions, to perform that command.");
                cfg.set("NoPlayer", "&cYou need to be a player!");
                cfg.set("JoinMessage", "&7Hey &b@%player%&7, if you want to start the Tutorial, do &9/course" + " §7aus. %n%There you will get more informations.");
                cfg.set("AlreadyInCourse", "&7You are already in the course. %n%If you wan't to continue, use &9/course continue &7.");

                cfg.save(getFilePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getLang() {
        String langLong = HowTo.getLangString();
        if(langLong.contains("de")) {
            return "Deutsch";
        } else {
            return "English";
        }
    }

    public static void setLanguage(String lang) {
        HowTo.getInstance().getConfigManager().set("Settings.Language", lang);
    }

    public static ArrayList<String> getSupportedLangauges() {
        return supportedLangauges;
    }
}
