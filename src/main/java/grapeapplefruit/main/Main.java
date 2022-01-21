package grapeapplefruit.main;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("start").setExecutor(new Game());
        getCommand("end").setExecutor(new Game());
        getCommand("basic").setExecutor(new Game());
        getCommand("help").setExecutor(new HelpCommand());
        getServer().getPluginManager().registerEvents(new Game(), this);
        System.out.println(" ====================  ");
        System.out.println("    Infection v1.0      ");
        System.out.println("  By GrapeAppleFruit   ");
        System.out.println(" ====================  ");

    }

    @Override
    public void onDisable() {

    }
}
