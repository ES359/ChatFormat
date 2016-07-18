package work;

import Utilities.ChatUtils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.ChatHoverable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



/**
 * Created by ES359 on 7/18/16.
 */
public class ChatCommandExc extends ChatUtils implements CommandExecutor {

    private String textMsg = "Default.. message. Use /dev set <msg>";

    public String getMsg()
    {
        return textMsg;
    }

    public void setMsg(String msg)
    {
//        textMsg = "";
        this.textMsg = msg;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[])
    {



        if(!(sender instanceof Player))
        {
            sender.sendMessage(color("%prefix% &cConsole support not added."));
            return true;
        }

        Player p = (Player)sender;

        if(cmd.getName().equalsIgnoreCase("dev"))
        {
            logCommand(p, args);
            if(args.length < 1)
            {
                p.sendMessage(color("%prefix% &cUse more arguments..."));
            }else if(args.length > 0)
            {
                switch (args[0].toLowerCase())
                {
                    case "set":
                        p.sendMessage(color("%prefix% &7You need to add a message after set argument!"));
                        if(args.length > 1)
                        {
                            StringBuilder str = new StringBuilder();

                            for(int j = 1; j <args.length; j++)
                            {
                                str.append(args[j] + " ");
                            }
                            String msg = str.toString().replace("set", "");

                            setMsg(color(msg));
                            p.sendMessage(color("%prefix% &7You set the message to: &f" + msg));
                        }
                        break;

                    case "help":
                    case "?":
                        p.sendMessage(color("&7     ----- %prefix% &7-----"));
                        p.sendMessage("");
                        p.sendMessage(color("&a&l> /dev version"));
                        p.sendMessage(color("&a&l> /dev about"));
                        p.sendMessage(color("&a&l> /dev set <msg>"));
                        p.sendMessage(color("&a&l> /dev test &7- Make sure to click on the message!"));
                        break;

                    case "version":
                       p.sendMessage(ChatColor.RED + "Nothing here yet...");
                        break;

                    case "about":

                    case "test":
                        TextComponent text = new TextComponent("Click me, or mouse over me!");

                        text.setColor(ChatColor.AQUA);

                        text.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(getMsg()).create() ) );

//                String s = TextComponent.toLegacyText(text);

                        p.spigot().sendMessage(text);
                        break;

                    default:
                        p.sendMessage(color("&7     ----- %prefix% &7-----"));
                        p.sendMessage("");
                        p.sendMessage(color("&a&l> /dev version"));
                        p.sendMessage(color("&a&l> /dev about"));
                        p.sendMessage(color("&a&l> /chat set <msg>"));
                        p.sendMessage(color("&a&l> /chat test &7- Make sure to click on the message!"));
                }
            }
        }
        return true;
    }

}
