package de.sunjx.howto.levels;

import de.sunjx.howto.HowTo;
import de.sunjx.howto.manager.CourseManager;
import de.sunjx.howto.manager.ScoreboardManager;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: JXCoding on 18.06.2020 at 16:34
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class Level {

    private Player player;
    private CourseManager courseManager = HowTo.getInstance().getCourseManager();

    private HashMap<Player, Double> playerLevelHashMap = new HashMap<Player, Double>();

    /* Input Levels here. */
    private double levels[] =
            {
                    1.0,
                    1.1,
                    1.2,
                    1.3
            };
    //levels[0] = 1
    //levels[1] = 1.1
    //levels[2] = 1.2

    public Level(Player player) {
        this.player = player;
        playerLevelHashMap.put(player, getLevel());
    }

    public void nextLevel() {
        double activeLevel = getLevel();



        for(double nLevel : levels) {
            if(Double.valueOf(activeLevel).equals(nLevel)) {
                for(int i = 0; i <= levels.length - 1; i++) {
                    if(levels[i] == activeLevel) {
                        if(i != levels.length - 1) {
                            courseManager.setCourseLevel(player, levels[i+1]);
                            //System.out.println("levels[" + i + "] = " + levels[i+1]);
                            new ScoreboardManager().refresh(player);
                        } else {
                            player.sendMessage(HowTo.getInstance().getData().getPrefix() + "§cHier endet der aktuelle Kurs. Bitte warte für weitere Updates.");
                            return;
                        }
                    }
                }
                //System.out.println("Yay, i am same as the activeLevel");
            }
        }
    }

    public double getLevel() {
        String s = courseManager.getCourseLevel(player);
        double returnVal = Double.valueOf(s);
        return returnVal;
    }

}
