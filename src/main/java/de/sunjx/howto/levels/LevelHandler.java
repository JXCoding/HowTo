package de.sunjx.howto.levels;

import de.sunjx.howto.HowTo;
import org.bukkit.entity.Player;

/**
 * @author: JXCoding on 18.06.2020 at 18:56
 * All rights reserved to @author JXCoding or Shortlabs.
 **/
public class LevelHandler {

    private Player player;
    private Level level;

    String prefix = HowTo.getInstance().getData().getPrefix();
    String noPerms = HowTo.getInstance().getData().getNoPermissions();
    String noPlayer = HowTo.getInstance().getData().getNoPlayer();
    String prefixSpacer = HowTo.getInstance().getData().getPrefixSpacer();

    public LevelHandler(Player player) {
        this.player = player;
        this.level = new Level(this.player);
    }

    public void sendLevel() {

        double d = level.getLevel();

        if(d == 1) {
            player.sendMessage(prefix + "1");
            level.nextLevel();
        } else if(d == 1.1) {
            player.sendMessage(prefix + "1-1");
            level.nextLevel();
        } else if(d == 1.2) {
            player.sendMessage(prefix + "1-2");
            level.nextLevel();
        } else {
            player.sendMessage(prefix + "else");
            level.nextLevel();
        }
    }

}
