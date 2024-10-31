package de.dieconfig.farmweltSystem;

import de.dieconfig.farmweltSystem.listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class FarmweltSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("///");
        Bukkit.getConsoleSender().sendMessage("FarmweltSystem wurde erfolgreich gestartet!");
        Bukkit.getConsoleSender().sendMessage("///");

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(), this);


    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("///");
        Bukkit.getConsoleSender().sendMessage("FarmweltSystem wurde beendet!");
        Bukkit.getConsoleSender().sendMessage("///");
    }
}
