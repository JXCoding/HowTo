package de.sunjx.howto.utils;

import de.sunjx.howto.HowTo;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * @author reaL on 05.04.2020 at 02:46
 * All rights reserved to @author reaL or Shortlog.
 * @project HowTo
 **/
public class Data {

    private YamlConfiguration cfg = YamlConfiguration.loadConfiguration(HowTo.getInstance().getLanguage().getFilePath());

    private String prefix = "§9● §eHowT(w)o? §9● ",
            noPermissions = cfg.getString("NoPermissions"),
            noPlayer = cfg.getString("NoPlayer"),
            prefixSpacer = "                  ",
            tabSpace = "    ";


    private ArrayList<String> subCommands = new ArrayList<String>();

    public Data() {

    }

    public ArrayList<String> getSubCommands() {
        return subCommands;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoPermissions() {
        return prefix + noPermissions;
    }

    public String getNoPlayer() {
        return prefix + noPlayer;
    }

    public String getPrefixSpacer() {
        return prefixSpacer;
    }

    public String getTabSpace() {
        return tabSpace;
    }

    public void sendHowToHelpMessages(Player p) {
        for(int i = 0; i < 100; i++) { p.sendMessage(" "); } //clearer
        if(HowTo.getLangString().equalsIgnoreCase("de")) {
            p.sendMessage(prefix + "§7Benutze folgende Befehle:");
            p.sendMessage(prefixSpacer + "§7» §e/howto help §7- §9Zeige die Hilfeseite an.");
        } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
            p.sendMessage(prefix + "§7Use the following commands:");
            p.sendMessage(prefixSpacer + "§7» §e/howto help §7- §9Show the help.");
        } else {
            p.sendMessage(prefix + "§7Use the following commands:");
            p.sendMessage(prefixSpacer + "§7» §e/howto help §7- §9Show the help.");
        }

    }

    public void sendCourseHelpCommands(Player p) {
        for(int i = 0; i < 100; i++) { p.sendMessage(" "); } //clearer
        if(HowTo.getLangString().equalsIgnoreCase("de")) {
            p.sendMessage(prefix + "§7Benutze folgende Befehle:");
            p.sendMessage(prefixSpacer + "§7» §e/course help §7- §9Zeige die Hilfeseite an.");
            p.sendMessage(prefixSpacer + "§7» §e/course start §7- §9Beginne deine Reise in's Java Universum.");
            p.sendMessage(prefixSpacer + "§7» §e/course contents §7- §9Zeige dir das Inhaltsverzeichnis an");
            p.sendMessage(prefixSpacer + "§7» §e/course language §7- §9Ändere deine Sprache.");
            p.sendMessage(prefixSpacer + "§7» §e/course state §7- §9Frage deinen aktuellen Status im Kurs ab.");
            p.sendMessage(prefixSpacer + "§7» §e/course reset §7- §9Setze deinen Fortschritt zurück.");
        } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
            p.sendMessage(prefix + "§7Use the following commands:");
            p.sendMessage(prefixSpacer + "§7» §e/course help §7- §9Show the help.");
            p.sendMessage(prefixSpacer + "§7» §e/course start §7- §9Start with your journey into the java universe.");
            p.sendMessage(prefixSpacer + "§7» §e/course contents §7- §9Show the table of contents.");
            p.sendMessage(prefixSpacer + "§7» §e/course language §7- §9Change your language.");
            p.sendMessage(prefixSpacer + "§7» §e/course state §7- §9Check your current course state.");
            p.sendMessage(prefixSpacer + "§7» §e/course reset §7- §9Reset your current progress.");
        } else {
            p.sendMessage(prefix + "§7Use the following commands:");
            p.sendMessage(prefixSpacer + "§7» §e/course help §7- §9Show the help.");
            p.sendMessage(prefixSpacer + "§7» §e/course start §7- §9Start with your journey into the java universe.");
            p.sendMessage(prefixSpacer + "§7» §e/course contents §7- §9Show the table of contents.");
            p.sendMessage(prefixSpacer + "§7» §e/course language §7- §9Change your language.");
            p.sendMessage(prefixSpacer + "§7» §e/course state §7- §9Check your current course state.");
            p.sendMessage(prefixSpacer + "§7» §e/course reset §7- §9Reset your current progress.");
        }
    }
    public void sendCourseTable(Player p) {
        for(int i = 0; i < 100; i++) { p.sendMessage(" "); } //clearer
        if (HowTo.getLangString().equalsIgnoreCase("de")) {
            p.sendMessage(prefix + "§7Inhaltsverzeichnis: ");
            p.sendMessage(prefixSpacer + "§7» §e1.) §9Programme");
            p.sendMessage(prefixSpacer + tabSpace + "§7» §e1.1) §9IntelliJ IDEA");
            p.sendMessage(prefixSpacer + tabSpace + "§7» §e1.2) §9Eclipse");
        } else if (HowTo.getLangString().equalsIgnoreCase("en")) {
            p.sendMessage(prefix + "§7Table of Contents: ");
            p.sendMessage(prefixSpacer + "§7» §e1.) §9Programs");
            p.sendMessage(prefixSpacer + tabSpace + "§7» §e1.1) §9IntelliJ IDEA");
            p.sendMessage(prefixSpacer + tabSpace + "§7» §e1.2) §9Eclipse");
        } else {
            p.sendMessage(prefix + "§7Table of Contents: ");
            p.sendMessage(prefixSpacer + "§7» §e1.) §9Programs");
            p.sendMessage(prefixSpacer + tabSpace + "§7» §e1.1) §9IntelliJ IDEA");
            p.sendMessage(prefixSpacer + tabSpace + "§7» §e1.2) §9Eclipse");
        }
    }


}
