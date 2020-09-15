package de.sunjx.howto.levels;

import de.sunjx.howto.HowTo;
import org.bukkit.Sound;
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

        for(int i = 0; i < 100; i++) { player.sendMessage(" "); } //clearer

        if(d == 1) {
            if (HowTo.getLangString().equalsIgnoreCase("de")) {
                player.sendMessage(prefix + "§7Dein akuteller Fortschritt im Kurs: ");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7Level » §9" + HowTo.getInstance().getCourseManager().getCourseLevel(player));
                player.sendMessage(prefixSpacer + "§7Thema » §9Programme");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7Das wichtige beim Entwickeln von Plugins oder überhaupt Java,");
                player.sendMessage(prefixSpacer + "§7ist das Programm. Also deine Entwicklungs Umgebung.");
                player.sendMessage(prefixSpacer + "§7Es gibt viele Programme in denen man Entwickeln kann.");
                player.sendMessage(prefixSpacer + "§7In dem Tutorial beziehen wir uns aber nur auf IntelliJ IDEA und Eclipse.");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§9Funfact: §7Man kann sogar in einem normalen Editor programmieren.");
                player.sendMessage(prefixSpacer + "§7Wenn du fertig mit dem Kapitel bist, führe §9/course continue §7aus.");
            } else if (HowTo.getLangString().equalsIgnoreCase("en")) {
                player.sendMessage(prefix + "§7Your current progress in the course: ");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7Level » §9" + HowTo.getInstance().getCourseManager().getCourseLevel(player));
                player.sendMessage(prefixSpacer + "§7Lesson » §9Programs");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7The important thing when developing plugins or java");
                player.sendMessage(prefixSpacer + "§7in general is the program. So your develop environment.");
                player.sendMessage(prefixSpacer + "§7There are many programs out there in which you can develop");
                player.sendMessage(prefixSpacer + "§7but in this tutorial we will focus only on IntelliJ IDEA and Eclipse.");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§9Funfact: §7You can even develop in an normal editor.");
                player.sendMessage(prefixSpacer + "§7If you finished this lesson, do §9/course continue §7.");
            } else {
                player.sendMessage(prefix + "§7Your current progress in the course: ");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7Level » §9" + HowTo.getInstance().getCourseManager().getCourseLevel(player));
                player.sendMessage(prefixSpacer + "§7Lesson » §9Programs");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7The important thing when developing plugins or java");
                player.sendMessage(prefixSpacer + "§7in general is the program. So your develop environment.");
                player.sendMessage(prefixSpacer + "§7There are many programs out there in which you can develop");
                player.sendMessage(prefixSpacer + "§7but in this tutorial we will focus only on IntelliJ IDEA and Eclipse.");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§9Funfact: §7You can even develop in an normal editor.");
                player.sendMessage(prefixSpacer + "§7If you finished this lesson, do §9/course continue §7.");
            }

        } else if(d == 1.1) {
            if (HowTo.getLangString().equalsIgnoreCase("de")) {
                player.sendMessage(prefix + "§7Dein akuteller Fortschritt im Kurs: ");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7Level » §9" + HowTo.getInstance().getCourseManager().getCourseLevel(player));
                player.sendMessage(prefixSpacer + "§7Thema » §9IntelliJ IDEA");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7IntelliJ ist ein Programm, was meistens");
                player.sendMessage(prefixSpacer + "§7von Fortgeschritteneren und Profis benutzt wird.");
                player.sendMessage(prefixSpacer + "§7Klar, kann man es auch als Anfänger benutzen aber es ist ziemlich kompliziert.");
                player.sendMessage(prefixSpacer + "§7Ich empfehle dir/euch aber erstmals Eclipse zu benutzen.");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§9Funfact: §7IntelliJ wird mit 43% als beste Java Umgebung ausgezeichnet.");
                player.sendMessage(prefixSpacer + "§7Wenn du fertig mit dem Kapitel bist, führe §9/course continue §7aus.");
            } else if (HowTo.getLangString().equalsIgnoreCase("en")) {
                player.sendMessage(prefix + "§7Your current progress in the course: ");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7Level » §9" + HowTo.getInstance().getCourseManager().getCourseLevel(player));
                player.sendMessage(prefixSpacer + "§7Lesson » §9IntelliJ IDEA.");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7IntelliJ is commonly used by more advanced users");
                player.sendMessage(prefixSpacer + "§7Sure, it can be used as a beginner but it's very complicated at the beginning.");
                player.sendMessage(prefixSpacer + "§7I recommend you to use Eclipse for the beginning.");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§9Funfact: §7IntelliJ is the the most up voted java environment with 43%");
                player.sendMessage(prefixSpacer + "§7If you finished this lesson, do §9/course continue §7.");
            } else {
                player.sendMessage(prefix + "§7Your current progress in the course: ");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7Level » §9" + HowTo.getInstance().getCourseManager().getCourseLevel(player));
                player.sendMessage(prefixSpacer + "§7Lesson » §9IntelliJ IDEA.");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§7IntelliJ is commonly used by more advanced users");
                player.sendMessage(prefixSpacer + "§7Sure, it can be used as a beginner but it's very complicated at the beginning.");
                player.sendMessage(prefixSpacer + "§7I recommend you to use Eclipse for the beginning.");
                player.sendMessage(prefixSpacer);
                player.sendMessage(prefixSpacer + "§9Funfact: §7IntelliJ is the the most up voted java environment with 43%");
                player.sendMessage(prefixSpacer + "§7If you finished this lesson, do §9/course continue §7.");
            }

        } else if(d == 1.2) {
            if (HowTo.getLangString().equalsIgnoreCase("de")) {

            } else if (HowTo.getLangString().equalsIgnoreCase("en")) {

            } else {

            }

        } else if(d == 1.3) {
            if (HowTo.getLangString().equalsIgnoreCase("de")) {

            } else if (HowTo.getLangString().equalsIgnoreCase("en")) {

            } else {

            }

        }

    }

    public void nextLevel() {
        level.nextLevel();
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
        sendLevel();
    }

}
