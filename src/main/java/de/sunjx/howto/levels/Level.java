package de.sunjx.howto.levels;

import de.sunjx.howto.HowTo;
import de.sunjx.howto.manager.CourseManager;
import org.bukkit.entity.Player;

/**
 * @author: JXCoding on 18.06.2020 at 16:34
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class Level {

    private Player player;
    private CourseManager courseManager = HowTo.getInstance().getCourseManager();

    /* Input Levels here. */
    private double levels[] = {1.0, 1.1, 1.2};
    //levels[0] = 1
    //levels[1] = 1.1
    //levels[2] = 1.2
    // "
    // "

    public Level(Player player) {
        this.player = player;
    }

    public void nextLevel() {
        double activeLevel = getLevel();

        //TODO add functional.

    }

    public void setLevel(double level) {

    }

    public double getLevel() {
        String s = courseManager.getCourseLevel(player);
        double returnVal = Double.valueOf(s);
        return returnVal;
    }

}
