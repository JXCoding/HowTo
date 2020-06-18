package de.sunjx.howto.commands;

import de.sunjx.howto.HowTo;
import de.sunjx.howto.levels.LevelHandler;
import de.sunjx.howto.utils.Language;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author reaL on 05.04.2020 at 19:54
 * All rights reserved to @author reaL or Shortlog.
 * @project HowTo
 **/
public class CourseCommand implements CommandExecutor, TabCompleter {

    String prefix = HowTo.getInstance().getData().getPrefix();
    String noPerms = HowTo.getInstance().getData().getNoPermissions();
    String noPlayer = HowTo.getInstance().getData().getNoPlayer();
    String prefixSpacer = HowTo.getInstance().getData().getPrefixSpacer();

    String OS = HowTo.getInstance().getOsManager().getOS();

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(noPlayer);
            return false;
        }
        Player p = (Player) sender;
        for(int i = 0; i < 100; i++) { p.sendMessage(" "); } //clearer
        if(p.hasPermission("howto.learn")) {
            if(args.length == 0) {
                if(HowTo.getLangString().equalsIgnoreCase("de")) {
                    p.sendMessage(prefix + "§b@" + p.getName() + "§7 wenn du mit dem Kurs beginnen willst, führe §9/course start");
                    p.sendMessage(prefixSpacer + "§7aus oder wenn du hilfe brauchst, benutze §9/course help");
                } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                    p.sendMessage(prefix + "§b@" + p.getName() + "§7 if you want to start with the course do §9/course start");
                    p.sendMessage(prefixSpacer + "§7if you need any help use §9/course help");
                } else {
                    p.sendMessage(prefix + "§b@" + p.getName() + "§7 if you want to start with the course do §9/course start");
                    p.sendMessage(prefixSpacer + "§7if you need any help use §9/course help");
                }

            } else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("help")) {
                    HowTo.getInstance().getData().sendCourseHelpCommands(p);
                } else if(args[0].equalsIgnoreCase("contents")) {
                    HowTo.getInstance().getData().sendCourseTable(p);
                } else if(args[0].equalsIgnoreCase("start")) {
                    if(HowTo.getLangString().equalsIgnoreCase("de")) {
                        HowTo.getInstance().getCourseManager().addToCourse(p);
                    } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                        HowTo.getInstance().getCourseManager().addToCourse(p);
                    } else {
                        HowTo.getInstance().getCourseManager().addToCourse(p);
                    }
                    //reset from course (maybe debug information?)
                } else if(args[0].equalsIgnoreCase("reset")) {
                    HowTo.getInstance().getCourseManager().resetFromCourse(p);
                } else if(args[0].equalsIgnoreCase("language")) {
                    if(HowTo.getLangString().equalsIgnoreCase("de")) {
                        p.sendMessage(prefix + "§7Um deine Sprache zu ändern, benutze §9/course language <sprache>");
                    } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                        p.sendMessage(prefix + "§7To change the language, use §9/course language <language>");
                    } else {
                        p.sendMessage(prefix + "§7To change the language, use §9/course language <language>");
                    }
                } else if(args[0].equalsIgnoreCase("state")) {
                    if (HowTo.getLangString().equalsIgnoreCase("de")) {
                        p.sendMessage(prefix + "§7Dein akuteller Fortschritt im Kurs: ");
                        p.sendMessage(prefixSpacer + "§7Level » §9" + HowTo.getInstance().getCourseManager().getCourseLevel(p));
                        p.sendMessage(prefixSpacer + "§7Aufgabe » Führe §9/course continue §7aus.");
                        p.sendMessage(prefix + "§7================================");
                    } else if (HowTo.getLangString().equalsIgnoreCase("en")) {
                        p.sendMessage(prefix + "§7Your current progress in the course: ");
                        p.sendMessage(prefixSpacer + "§7Level » §9" + HowTo.getInstance().getCourseManager().getCourseLevel(p));
                        p.sendMessage(prefixSpacer + "§7Aufgabe » Execute §9/course continue§7.");
                        p.sendMessage(prefix + "§7================================");

                    }
                } else if(args[0].equalsIgnoreCase("continue")) {
                    LevelHandler levelHandler = new LevelHandler(p);
                    if(HowTo.getLangString().equalsIgnoreCase("de")) {
                        levelHandler.sendLevel();
                    } else if (HowTo.getLangString().equalsIgnoreCase("en")) {

                    }
                } else {
                    p.sendMessage(prefix + "§7Please use a valid argument.");
                    for(String arg : HowTo.getInstance().getData().getSubCommands()) {
                        p.sendMessage(prefixSpacer + "§7» §9/course " + arg);
                    }
                }
            } else if(args.length == 2) {
                if (args[0].equalsIgnoreCase("language")) {
                    String lang = args[1];
                    if(Language.getSupportedLangauges().contains(lang)) {
                        Language.setLanguage(lang);
                        HowTo.getInstance().getScoreboardManager().refresh(p);
                        if(HowTo.getLangString().equalsIgnoreCase("de")) {
                            p.sendMessage(prefix + "§7Deine Sprache wurde auf §9" + Language.getLang() + "§7 geändert.");
                        } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
                            p.sendMessage(prefix + "§7Your language was changed to §9" + Language.getLang() + "§7.");
                        } else {
                            p.sendMessage(prefix + "§7Your language was changed to §9" + Language.getLang() + "§7.");
                        }
                    } else {
                        p.sendMessage(prefix + "§cThis is not an supported language. ");
                        p.sendMessage(prefixSpacer + "§7Supported languages are: §9"+ String.valueOf(Language.getSupportedLangauges()));
                    }
                }
            }
        } else {
            p.sendMessage(noPerms);
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String string, String[] args) {
        if(args.length == 1) {
            return HowTo.getInstance().getData().getSubCommands();
        }
        return null;
    }


}

//                  if(HowTo.getLangString().equalsIgnoreCase("de")) {
//
//                } else if(HowTo.getLangString().equalsIgnoreCase("en")) {
//
//                } else {
//
//                }

//p.sendMessage("Boolean: Ein Boolean ist ein Ja/Nein Wert. Er hat nur die Werte True/ Wahr und False/Nein. Er wird teilweise abgekürzt mit dem Zahlen 1 und 0 aus dem Binärsystem.");
//p.sendMessage("Er wird benutzt um beispielweise abzufragen ob eine Abfrage Wahr oder Falsch ist.");
