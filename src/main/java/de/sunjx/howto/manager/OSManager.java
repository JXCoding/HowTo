package de.sunjx.howto.manager;

import de.sunjx.howto.HowTo;

/**
 * @author reaL on 12.04.2020 at 00:51
 * All rights reserved to @author reaL or Shortlog.
 * @project HowTo
 **/
public class OSManager {

    private static final String OS = System.getProperty("os.name").toLowerCase();
    private ConfigManager cm = HowTo.getInstance().getConfigManager();

    public OSManager() {

    }



    public String getOS() {

        if(isWindows()) {
            cm.set("Settings.OS", "win");
            return "Windows";
        } else if(isMac()) {
            cm.set("Settings.OS", "mac");
            return "Mac";
        } else if(isUnix()) {
            cm.set("Settings.OS", "unix");
            return "Unix";
        } else if(isSolaris()) {
            cm.set("Settings.OS", "solaris");
            return "Solaris";
        } else {
            cm.set("Settings.OS", "missing");
            return "Another OS Found.";
        }
    }

    private boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    private boolean isMac() {
        return (OS.indexOf("win") >= 0);
    }

    private boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }

    private boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }

}
