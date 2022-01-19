package grapeapplefruit.main;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("start").setExecutor(new Game());
        getCommand("end").setExecutor(new Game());
        getCommand("basic").setExecutor(new Kits());
        getServer().getPluginManager().registerEvents(new Kits(), this);
        getServer().getPluginManager().registerEvents(new Game(), this);

    }

    @Override
    public void onDisable() {

    }
}
