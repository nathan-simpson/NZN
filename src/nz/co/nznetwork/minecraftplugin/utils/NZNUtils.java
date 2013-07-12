package nz.co.nznetwork.minecraftplugin.utils;

import nz.co.nznetwork.minecraftplugin.NZNPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class NZNUtils {

    public final ChatColor ERROR_COLOUR;
    public final char ColourSymbol;
    private NZNPlugin plugin;

    public NZNUtils(NZNPlugin masterPlugin) {
        plugin = masterPlugin;

        //read error color from config
        ERROR_COLOUR = ChatColor.DARK_RED;
        ColourSymbol = '\u00A7';
    }

    public String formatMessage(String message) {

        message = message.replaceAll("&0", ColourSymbol + "0");
        message = message.replaceAll("&1", ColourSymbol + "1");
        message = message.replaceAll("&2", ColourSymbol + "2");
        message = message.replaceAll("&3", ColourSymbol + "3");
        message = message.replaceAll("&4", ColourSymbol + "4");
        message = message.replaceAll("&5", ColourSymbol + "5");
        message = message.replaceAll("&6", ColourSymbol + "6");
        message = message.replaceAll("&7", ColourSymbol + "7");
        message = message.replaceAll("&8", ColourSymbol + "8");
        message = message.replaceAll("&9", ColourSymbol + "9");
        message = message.replaceAll("&a", ColourSymbol + "a");
        message = message.replaceAll("&b", ColourSymbol + "b");
        message = message.replaceAll("&c", ColourSymbol + "c");
        message = message.replaceAll("&d", ColourSymbol + "d");
        message = message.replaceAll("&e", ColourSymbol + "e");
        message = message.replaceAll("&f", ColourSymbol + "f");
        message = message.replaceAll("&l", ColourSymbol + "l");
        message = message.replaceAll("&m", ColourSymbol + "m");
        message = message.replaceAll("&n", ColourSymbol + "n");
        message = message.replaceAll("&o", ColourSymbol + "o");
        message = message.replaceAll("&k", ColourSymbol + "k");

        /*
         message = message.replaceAll("&black", ColourSymbol + "0");
         message = message.replaceAll("&darkblue", ColourSymbol + "1");
         message = message.replaceAll("&darkgreen", ColourSymbol + "2");
         message = message.replaceAll("&darkaqua", ColourSymbol + "3");
         message = message.replaceAll("&darkred", ColourSymbol + "4");
         message = message.replaceAll("&darkpurple", ColourSymbol + "5");
         message = message.replaceAll("&gold", ColourSymbol + "6");
         message = message.replaceAll("&gray", ColourSymbol + "7");
         message = message.replaceAll("&darkgray", ColourSymbol + "8");
         message = message.replaceAll("&indigo", ColourSymbol + "9");
         message = message.replaceAll("&green", ColourSymbol + "a");
         message = message.replaceAll("&aqua", ColourSymbol + "b");
         message = message.replaceAll("&red", ColourSymbol + "c");
         message = message.replaceAll("&pink", ColourSymbol + "d");
         message = message.replaceAll("&yellow", ColourSymbol + "e");
         message = message.replaceAll("&white", ColourSymbol + "f");
         message = message.replaceAll("&bold", ColourSymbol + "l");
         message = message.replaceAll("&strike", ColourSymbol + "m");
         message = message.replaceAll("&underline", ColourSymbol + "n");
         message = message.replaceAll("&italic", ColourSymbol + "o");
         message = message.replaceAll("&random", ColourSymbol + "k");
         */
        return message;
    }

    public String secondsToString(long s) {
        boolean invert = false;
        // 1st sort out the edge case:
        if (s == 0) {
            return "0 seconds";
        }
        if (s < 0) {
            invert = true;
            s = s * -1;
        }

        // calculate how many of each unit is required
        int days = (int) (s / (60 * 60 * 24));
        s = s - (days * 24 * 60 * 60);
        int hours = (int) (s / (60 * 60));
        s = s - (hours * 60 * 60);
        int mins = (int) (s / 60);
        s = s - (mins * 60);
        int seconds = (int) s;
        // work out the number of units used
        boolean and = false;
        int numberOfUnits = 0;
        if (days != 0) {
            numberOfUnits++;
        }
        if (hours != 0) {
            numberOfUnits++;
        }
        if (mins != 0) {
            numberOfUnits++;
        }
        if (seconds != 0) {
            numberOfUnits++;
        }
        if (numberOfUnits > 1) {
            and = true;
        }

        // format the string
        String result = "";
        if (seconds != 0) {
            if (seconds == 1) {
                result = String.valueOf(seconds) + " second " + result;
            } else {
                result = String.valueOf(seconds) + " seconds " + result;
            }
            if (and) {
                result = "and " + result;
                and = false;
            }
        }
        if (mins != 0) {
            if (mins == 1) {
                result = String.valueOf(mins) + " mintute " + result;
            } else {
                result = String.valueOf(mins) + " mintutes " + result;
            }
            if (and) {
                result = "and " + result;
                and = false;
            }
        }
        if (hours != 0) {
            if (hours == 1) {
                result = String.valueOf(hours) + " hour " + result;
            } else {
                result = String.valueOf(hours) + " hours " + result;
            }
            if (and) {
                result = "and " + result;
                and = false;
            }
        }
        if (days != 0) {
            if (days == 1) {
                result = String.valueOf(days) + " day " + result;
            } else {
                result = String.valueOf(days) + " days " + result;
            }
        }
        if (invert) {
            result = result + "ago";
        }
        return result;
    }

    public long stringToSeconds(String timeinput) {
        try {
            //first check its not already in seconds
            long l = Long.parseLong(timeinput);
            return l;
        } catch (NumberFormatException e) {
        }

        char timespan = timeinput.charAt(timeinput.length() - 1); //get the last character
        String timestring = timeinput.substring(0, timeinput.length() - 1); //get the rest of the string
        try {
            long time = Long.parseLong(timestring);
            if ((timespan == 's') || (timespan == 'S')) {
                time = time * 1L;
            } else if ((timespan == 'm') || (timespan == 'M')) {
                time = time * 60L;
            } else if ((timespan == 'h') || (timespan == 'H')) {
                time = time * 3600L;
            } else if ((timespan == 'd') || (timespan == 'D')) {
                time = time * 86400L;
            } else {
                return 0L;
            }
            return time;
        } catch (NumberFormatException ex) {
            return 0L;
        }
    }

    public boolean getPermision(CommandSender sender, String permission) {
        if (sender.isOp()) {
            return true;
        }
        if (sender.hasPermission(permission)) {
            return true;
        }
        String[] hirechy = permission.split(".");
        for (int i = 0; i < hirechy.length; i++) {
            String permBuilder = "";
            for (int j = 0; j <= i; j++) {
                permBuilder = permBuilder + hirechy[j] + ".";
            }
            permBuilder = permBuilder + "*";
            if (sender.hasPermission(permBuilder)) {
                return true;
            }
        }
        return false;
    }
}
