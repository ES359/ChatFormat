package Utilities;

import me.ES359.ChatFormat.ChatFormat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by ES359 on 7/18/16.
 */
public class ChatUtils
{
    private static final String VERSION_ID = "/*ADD VERSION ID*/";

    private String prefix = ChatColor.translateAlternateColorCodes('&',"&bDev&7> ");
    /**
     * Stores Author UUID.
     */
    private String author = "9c5dd792-dcb3-443b-ac6c-605903231eb2";
    /**
     * Predefined permission message.
     */
    private String permission = color(getPrefix()+"&cYou don't have permission for this.");

    public String getPrefix()
    {
        return " " +this.prefix;
    }
    /**
     * Gets the defined permission message set.
     * @return
     */
    public String getPermission()
    {
        return this.permission;
    }


    private String donationURL = color("https://www.paypal.me/ES359");

    /**
     * @return Donation URL
     */
    public String getDonationURL()
    {
        return donationURL;
    }


    /**
     * Checks a players UUID against the one set inside the Author variable.
     * @param uuid
     * @return
     */
    public boolean checkAuthor(UUID uuid)
    {
        return uuid.toString().equals(author);
    }

    /**
     *  Informs author that plugin is being used by server.
     *
     * @param p
     */
    public void displayAuthInfo(Player p)
    {
        if(checkAuthor(p.getUniqueId()))
        {
            p.sendMessage(color("&a&l&oHello, &7"+ p.getName() +"\n &aThis server is using " + getPrefix() + "&r\n&cVersion ID: &7" +VERSION_ID));
        }
    }

    /**
     *  Displays plugin description Information.
     *
     * @param sender
     * @param
     *
     */
    public void desc(CommandSender sender, ChatFormat main) {
        sender.sendMessage(color("&2========== " + getPrefix().replace(">", "") + "&2=========="));
        sender.sendMessage(color("&7[&9" + main.pdfFile.getName() + "&7] &6Created by, &b&l" + main.pdfFile.getAuthors() + "&6."));
        sender.sendMessage(color("&2" + main.pdfFile.getDescription() + "&2."));
        sender.sendMessage(color("&bWebsite: &e&l" + main.pdfFile.getWebsite()));
        sender.sendMessage(color("&bMinecraft Color Codes: &a&nhttp://minecraftcolorcodes.com/"));
        sender.sendMessage(color("&9If you like my work, you can support me by donating &ahere: " + getDonationURL()));
        sender.sendMessage(color("&8-----------------------------"));
    }

    /**
     *  Returns this plugins version.
     */
    public String getPluginVersion(ChatFormat main, Player sender)
    {
        return color("&fHello, &a&n"+sender.getName() +".&r\nYou are currently running version &b&n"+main.pdfFile.getVersion() + "&r of &e&n"+main.pdfFile.getName() +"&r\n \n&6Your server is running version &c&n"+ main.getServer().getBukkitVersion());
    }


    public String color(String message) {

        String msg =  message;
        msg = msg.replace("&", "§");
        msg = msg.replace("%prefix%",getPrefix());

//        msg = msg.replace("%permission%",getPermission());
        return msg;
    }

    public void logToConsole(String log)
    {
        Bukkit.getServer().getConsoleSender().sendMessage(color("&c"+Debug.LOG +"&r"+ log));
    }

    public void logCommand(CommandSender sender, ChatFormat main, String args[])
    {
        if(main.getConfig().getBoolean("log-commands"))
        {
            logToConsole("[Chat]: &7" + sender.getName() + " used the command, &9/vote " + args);
        }
    }

    public void logCommand(Player sender,  String args[])
    {
        if(ChatFormat.DEBUG)
        {
            logToConsole("[Chat]: &7" + sender.getName() + " used the command, &9/vote " + args);
        }
    }

    public String msg (String msg)
    {
        return color(msg);
    }

}
