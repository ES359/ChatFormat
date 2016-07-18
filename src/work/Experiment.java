package work;

import Utilities.ChatUtils;
import Utilities.Debug;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
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

        TextComponent text = new TextComponent(color(p.getName()));

        text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Testing this ").create()));
        String s = TextComponent.toLegacyText(text);

        event.setFormat(s + "  " + event.getMessage());

    }

    public void sendTextComponent(Player player, BaseComponent msg)
    {
        player.spigot().sendMessage(msg);
    }
}
