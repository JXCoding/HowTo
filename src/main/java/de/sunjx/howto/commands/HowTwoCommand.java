package de.sunjx.howto.commands;

import de.sunjx.howto.HowTo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author reaL on 05.04.2020 at 19:54
 * All rights reserved to @author reaL or Shortlog.
 * @project HowTo
 **/
public class HowTwoCommand implements CommandExecutor {

    String prefix = HowTo.getInstance().getData().getPrefix();
    String noPerms = HowTo.getInstance().getData().getNoPermissions();
    String noPlayer = HowTo.getInstance().getData().getNoPlayer();
    String prefixSpacer = HowTo.getInstance().getData().getPrefixSpacer();

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(noPlayer);
            return false;
        }
        Player p = (Player) sender;
        for(int i = 0; i < 100; i++) { p.sendMessage(" "); } //clearer

        if(args.length == 0) {
            //show only author
            if(HowTo.getLangString().equalsIgnoreCase("de")) {
               p.sendMessage(prefix + "§7HowT(w)o Plugin von §b@JX §7und §b@SunsetGFX.");
               p.sendMessage(prefixSpacer + "§7Der einfachste Weg Java mit Minecraft zu lernen.");
           } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
               p.sendMessage(prefix + "§7HowT(w)o Plugin by §b@JX §7and §b@SunsetGFX.");
               p.sendMessage(prefixSpacer + "§7The easiest way to learn Java with Minecraft.");
           } else {
               p.sendMessage(prefix + "§7HowT(w)o Plugin by §b@JX §7and §b@SunsetGFX.");
               p.sendMessage(prefixSpacer + "§7The easiest way to learn Java with Minecraft.");
           }
        } else if(args.length == 1) {
            if(p.hasPermission("howto.more")) {
                if(args[0].equalsIgnoreCase("help")) {
                    HowTo.getInstance().getData().sendHowToHelpMessages(p);
                } else if(args[0].equalsIgnoreCase("string")) {
                    p.sendMessage("string explanation here");
                }
            } else {
                p.sendMessage(noPerms);
            }
        }
        return false;
    }

}
