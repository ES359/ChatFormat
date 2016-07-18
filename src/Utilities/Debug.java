package Utilities;

import me.ES359.ChatFormat.ChatFormat;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Debug {
static ChatUtils utils = new ChatUtils();
       static public String FAILED_ACTION = "[FAILED ACTION] ";
       static public String ACTION = "[ACTION] ";
       static public String LOG = "[LOG] ";
       static public String SEVERE = "[SEVERE] &c";
        static public String PREFIX = utils.getPrefix();


    //TODO Create an advanced command notifier whenever certain commands are mentioned

    static public String pluginLog()
    {
        return LOG+ ""+ PREFIX;
    }

   static public void debugEnabled()
    {
        if(ChatFormat.DEBUG)
        {
            System.out.println(Debug.LOG + " Debugging is enabled...");
        }else
        {
            System.out.println(Debug.LOG +"Debugging is " + ChatFormat.DEBUG);
        }
    }

    static public void log(String message)
    {
        if(ChatFormat.DEBUG)
        {
            Bukkit.getServer().getConsoleSender().sendMessage(utils.color(message));
        }
    }

    static public void log(Player p, String message)
    {
        if(ChatFormat.DEBUG)
        {
            p.sendMessage(utils.color(message));
        }
    }

    static public void log(CommandSender p, String message)
    {
        if(ChatFormat.DEBUG)
        {
            p.sendMessage(utils.color(message));
        }
    }

    /**
     * Simple debug flag enabler.
     * @param sender
     * @param args
     */
    static public void debugToggle(CommandSender sender, String[] args)
    {
        if(args.length > 1 && args[1].equalsIgnoreCase("debug"))
        {

            /**
             * REPLACE MAINCLASS WITH YOUR MAINCLASS.
             *
             * EXAMPLE: <MAINCLASS>.DEBUG.
             *
             * Make sure to add:
             * static public DEBUG = false; // To your main class.
             *
             *
             */

            ChatFormat.DEBUG = Boolean.parseBoolean(args[2]);
            sender.sendMessage(utils.color("[&4DEBUG&f] &c--> &7You have set Debug status to &4&l: " + ChatFormat.DEBUG));
        }
    }
}