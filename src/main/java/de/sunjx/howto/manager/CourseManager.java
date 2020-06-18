package de.sunjx.howto.manager;

import de.sunjx.howto.HowTo;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author reaL on 06.04.2020 at 01:30
 * All rights reserved to @author reaL or Shortlog.
 * @project HowTo
 **/
public class CourseManager {

    String prefix = HowTo.getInstance().getData().getPrefix();
    String noPerms = HowTo.getInstance().getData().getNoPermissions();
    String noPlayer = HowTo.getInstance().getData().getNoPlayer();
    String prefixSpacer = HowTo.getInstance().getData().getPrefixSpacer();
    private ConfigManager configManager;

    public CourseManager() {
        configManager = new ConfigManager("plugins//HowTwo//course","course.yml");
    }

    public void addToCourse(Player player) {

        if(isPlayerInCourse(player)) {
            if(HowTo.getLangString().equalsIgnoreCase("de")) {
                player.sendMessage(HowTo.getInstance().getData().getPrefix() + "§cDu bist bereits im Kurs eingetragen.");
                return;
            } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                player.sendMessage(HowTo.getInstance().getData().getPrefix() + "§cYou are already in the course");
                return;
            } else {
                player.sendMessage(HowTo.getInstance().getData().getPrefix() + "§cYou are already in the course");
                return;
            }
        } else {


            Date now = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            configManager.set("Player." + player.getName() + ".incourse", true);
            configManager.set("Player." + player.getName() + ".joinedat", format.format(now));
            configManager.set("Player." + player.getName() + ".courselevel", 1);
            configManager.set("Player." + player.getName() + ".scoreboardenabled", true);

            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
            HowTo.getInstance().getScoreboardManager().sendSB(player);
            if(HowTo.getLangString().equalsIgnoreCase("de")) {
                player.sendMessage(prefix + "§7Du bist nun im Kurs eingetragen.");
            } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                player.sendMessage(prefix + "§7You are now in the Course.");
            } else {
                player.sendMessage(prefix + "§7You are now in the Course.");
            }
        }
    }

    public void resetFromCourse(Player player) {
        for(int i = 0; i < 100; i++) { player.sendMessage(" "); } //clearer
        if(isPlayerInCourse(player)) {


            configManager.set("Player." + player.getName(),  null);
            player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);

            if(HowTo.getLangString().equalsIgnoreCase("de")) {
                player.sendMessage(prefix + "§7Du wurdest aus dem Kurs genommen.");
            } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                player.sendMessage(prefix + "§7You are now removed from the Course.");
            } else {
                player.sendMessage(prefix + "§7You are now removed from the Course.");
            }
        } else {
            if(HowTo.getLangString().equalsIgnoreCase("de")) {
                player.sendMessage(prefix + "§cDu bist nicht im Kurs.");
            } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                player.sendMessage(prefix + "§cYou are not in the Course.");
            } else {
                player.sendMessage(prefix + "§cYou are not in the Course.");
            }
        }
    }

    public String getJoinedDate(Player p) {
        return configManager.getString("Player." + p.getName() + ".joinedat");
    }

    public String getCourseLevel(Player p) {
        return configManager.getString("Player." + p.getName() + ".courselevel");
    }

    public boolean isScoreboardEnabled(Player p) {
        return configManager.getConfiguration().getBoolean("Player." + p.getName() + ".scoreboardenabled");
    }

    public boolean isPlayerInCourse(Player p) {
        if(configManager.getConfiguration().getBoolean("Player." + p.getName() + ".incourse") == true) {
            return true;
        } else {
            return false;
        }
    }

}
