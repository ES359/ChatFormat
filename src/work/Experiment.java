package work;

import Utilities.ChatUtils;
import Utilities.Debug;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by ES359 on 7/18/16.
 */
public class Experiment extends ChatUtils implements Listener
{
    @EventHandler
    public void chat(AsyncPlayerChatEvent event)
    {
        Debug.log(Debug.pluginLog() + "Logging if the chat is working ");
        Player p = event.getPlayer();

        TextComponent text = new TextComponent(""+p.getName() + " " + event.getMessage());

        text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(color("&7Display name: &a" +p.getName()+"\n" + "&7UUID: &a" + p.getUniqueId() + "\n" + "&7World name: &a" + p.getWorld().getName())).create()));

        event.setCancelled(true);

//       String s = TextComponent.toLegacyText(text);

        for(Player users : Bukkit.getServer().getOnlinePlayers())
        {
            if(users.hasPermission("dev.format"))
            {
                users.spigot().sendMessage(text);
            }else
            {
                users.sendMessage(color("&7Chat> &f"+ p.getName() + " " + event.getMessage()));
            }
        }

//        p.spigot().sendMessage(text);

//
//  String s = TextComponent.toLegacyText(text);

//        event.setFormat(s + "  " + event.getMessage());

    }

}
