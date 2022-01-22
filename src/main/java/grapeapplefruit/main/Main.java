package grapeapplefruit.main;

import grapeapplefruit.main.gamecommands.BasicKitCommand;
import grapeapplefruit.main.gamecommands.EndGameCommand;
import grapeapplefruit.main.gamecommands.StartGameCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("start").setExecutor(new StartGameCommand());
        getCommand("end").setExecutor(new EndGameCommand());
        getCommand("basic").setExecutor(new BasicKitCommand());
        getCommand("help").setExecutor(new HelpCommand());
        getServer().getPluginManager().registerEvents(new Game(), this);
        System.out.println(" ====================  ");
        System.out.println("    Infection v3.0      ");
        System.out.println("  By GrapeAppleFruit   ");
        System.out.println(" ====================  ");

    }

    @Override
    public void onDisable() {

    }
}
