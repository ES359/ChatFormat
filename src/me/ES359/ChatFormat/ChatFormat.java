package me.ES359.ChatFormat;

import Utilities.Debug;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import work.ChatCommandExc;
import work.Experiment;

/**
 * Created by ES359 on 7/18/16.
 */
public class ChatFormat extends JavaPlugin {

    public PluginDescriptionFile pdfFile = this.getDescription();
    static public boolean DEBUG = true;

    public void onEnable()
    {
        getCommand("dev").setExecutor(new ChatCommandExc());
        loadEvents();
    }

    void loadEvents()
    {
        Debug.log("&4Events loadeding...");
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Experiment(),this);
    }

}
