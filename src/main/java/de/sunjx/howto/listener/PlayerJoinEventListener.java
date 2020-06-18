package de.sunjx.howto.listener;

import de.sunjx.howto.HowTo;
import de.sunjx.howto.commands.HowTwoCommand;
import de.sunjx.howto.manager.CourseManager;
import de.sunjx.howto.manager.ScoreboardManager;
import de.sunjx.howto.utils.Language;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.isOp() || p.hasPermission("howto.notify")) {
            if(!HowTo.getInstance().getCourseManager().isPlayerInCourse(p)) {
                if(HowTo.getLangString().equalsIgnoreCase("de")) {
                    HowTo.getInstance().setLanguage(Language.GERMAN);
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(HowTo.getInstance().getLanguage().getFilePath());
                    p.sendMessage(HowTo.getInstance().getData().getPrefix() + cfg.getString("JoinMessage")
                            .replace("&", "§")
                            .replace("%player%", p.getName())
                            .replace("%n%",  "\n" + HowTo.getInstance().getData().getPrefixSpacer()));
                } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                    HowTo.getInstance().setLanguage(Language.ENGLISH);
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(HowTo.getInstance().getLanguage().getFilePath());
                    p.sendMessage(HowTo.getInstance().getData().getPrefix() + cfg.getString("JoinMessage")
                            .replace("&", "§")
                            .replace("%player%", p.getName())
                            .replace("%n%",  "\n" + HowTo.getInstance().getData().getPrefixSpacer()));
                } else {
                    HowTo.getInstance().setLanguage(Language.ENGLISH);
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(HowTo.getInstance().getLanguage().getFilePath());
                    p.sendMessage(HowTo.getInstance().getData().getPrefix() + cfg.getString("JoinMessage")
                            .replace("&", "§")
                            .replace("%player%", p.getName())
                            .replace("%n%",  "\n" + HowTo.getInstance().getData().getPrefixSpacer()));
                }
            } else {
                if(HowTo.getLangString().equalsIgnoreCase("de")) {
                    HowTo.getInstance().setLanguage(Language.GERMAN);
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(HowTo.getInstance().getLanguage().getFilePath());
                    p.sendMessage(HowTo.getInstance().getData().getPrefix() + cfg.getString("AlreadyInCourse")
                            .replace("&", "§")
                            .replace("%player%", p.getName())
                            .replace("%n%",  "\n" + HowTo.getInstance().getData().getPrefixSpacer()));
                } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                    HowTo.getInstance().setLanguage(Language.ENGLISH);
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(HowTo.getInstance().getLanguage().getFilePath());
                    p.sendMessage(HowTo.getInstance().getData().getPrefix() + cfg.getString("AlreadyInCourse")
                            .replace("&", "§")
                            .replace("%player%", p.getName())
                            .replace("%n%",  "\n" + HowTo.getInstance().getData().getPrefixSpacer()));
                } else {
                    HowTo.getInstance().setLanguage(Language.ENGLISH);
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(HowTo.getInstance().getLanguage().getFilePath());
                    p.sendMessage(HowTo.getInstance().getData().getPrefix() + cfg.getString("AlreadyInCourse")
                            .replace("&", "§")
                            .replace("%player%", p.getName())
                            .replace("%n%",  "\n" + HowTo.getInstance().getData().getPrefixSpacer()));
                }}

        }

        HowTo.getInstance().getScoreboardManager().sendSB(p);

    }
}
