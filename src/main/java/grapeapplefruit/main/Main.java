package grapeapplefruit.main;

import grapeapplefruit.main.cmds.HelpCommand;
import grapeapplefruit.main.cmds.JoinCommand;
import grapeapplefruit.main.cmds.LeaveCommand;
import grapeapplefruit.main.cmds.StartGame;
import grapeapplefruit.main.evnts.JoinEvent;
import grapeapplefruit.main.evnts.LeaveEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static int pc = Bukkit.getServer().getOnlinePlayers().size();

    @Override
    public void onEnable() {
        // cmds
        getCommand("join").setExecutor(new JoinCommand());
        getCommand("leave").setExecutor(new LeaveCommand());
        getCommand("forcestart").setExecutor(new StartGame());
        getCommand("plhelp").setExecutor(new HelpCommand());
        // events
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);


    }

    @Override
    public void onDisable() {

    }
}
