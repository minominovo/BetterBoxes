package org.mino.bettershulker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.mino.bettershulker.event.callbacks;

public final class BetterShulker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new callbacks(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
