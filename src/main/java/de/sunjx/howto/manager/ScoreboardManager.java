package de.sunjx.howto.manager;

import de.sunjx.howto.HowTo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

/**
 * @author reaL on 12.04.2020 at 01:27
 * All rights reserved to @author reaL or Shortlog.
 * @project HowTo
 **/
public class ScoreboardManager {

    public ScoreboardManager() {

    }

    public void sendSB(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective ob = scoreboard.registerNewObjective("howtwo", "dummy");

        ob.setDisplayName(HowTo.getInstance().getData().getPrefix());
        ob.setDisplaySlot(DisplaySlot.SIDEBAR);


        if(HowTo.getInstance().getCourseManager().isPlayerInCourse(player)) {
            if(HowTo.getLangString().equalsIgnoreCase("de")) {
                ob.getScore("§0").setScore(6);
                ob.getScore("§7» Beigetreten am: ").setScore(5);
                ob.getScore("§7»    §e" + getJoinedDate(player)).setScore(4);
                ob.getScore("§7»    §e" + getJoinedTime(player) + " Uhr").setScore(3);
                ob.getScore("§1").setScore(2);
                ob.getScore("§7» Kurs Level: ").setScore(1);
                ob.getScore("§7»    §eLevel " + HowTo.getInstance().getCourseManager().getCourseLevel(player)).setScore(0);
                ob.getScore("§2").setScore(-1);
            } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                ob.getScore("§0").setScore(6);
                ob.getScore("§7» Joined at: ").setScore(5);
                ob.getScore("§7»    §e" + getJoinedDate(player)).setScore(4);
                ob.getScore("§7»    §e" + convertLocalTime(player)).setScore(3);
                ob.getScore("§1").setScore(2);
                ob.getScore("§7» Course Level: ").setScore(1);
                ob.getScore("§7»    §eLevel " + HowTo.getInstance().getCourseManager().getCourseLevel(player)).setScore(0);
                ob.getScore("§2").setScore(-1);
            } else {
                ob.getScore("§0").setScore(6);
                ob.getScore("§7» Joined at: ").setScore(5);
                ob.getScore("§7»    §e" + getJoinedDate(player)).setScore(4);
                ob.getScore("§7»    §e" + convertLocalTime(player)).setScore(3);
                ob.getScore("§1").setScore(2);
                ob.getScore("§7» Course Level: ").setScore(1);
                ob.getScore("§7»    §eLevel " + HowTo.getInstance().getCourseManager().getCourseLevel(player)).setScore(0);
                ob.getScore("§2").setScore(-1);
            }


            if(HowTo.getInstance().getCourseManager().isScoreboardEnabled(player)) {
                player.setScoreboard(scoreboard);
            }
        } else {
            System.out.println("Player [" + player + "] is not in an course! [Scoreboard will not be setted.]");
        }
    }

    public void refresh(Player player) {
        player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
        sendSB(player);
    }

    public String getJoinedDate(Player player) {
        String localVar = HowTo.getInstance().getCourseManager().getJoinedDate(player);
        String[] splitted = localVar.split( " ");
        String newVar = splitted[0];
        return newVar.replace("-", ".");
    }

    public String getJoinedTime(Player player) {
        String localVar = HowTo.getInstance().getCourseManager().getJoinedDate(player);
        String[] splitted = localVar.split( " ");
        String newVar = splitted[1];
        return newVar.substring(0, 5);
    }

    public String convertLocalTime(Player player) {
        String time = getJoinedTime(player);

        SimpleDateFormat old = new SimpleDateFormat("hh:mm");
        try {
            Date date = old.parse(time);
            SimpleDateFormat newDate = new SimpleDateFormat("hh:mm aa");
            return newDate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Error. [notime]";
    }


}
