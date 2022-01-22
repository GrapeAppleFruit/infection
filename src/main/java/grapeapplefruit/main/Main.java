package grapeapplefruit.main;

import grapeapplefruit.main.cmds.BasicKit;
import grapeapplefruit.main.cmds.HelpCommand;
import grapeapplefruit.main.cmds.JoinCommand;
import grapeapplefruit.main.cmds.ServerStatus;
import grapeapplefruit.main.evn.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class Main extends JavaPlugin {

    public static int pc = Bukkit.getServer().getOnlinePlayers().size();

    Set<String> inf = Game.infected;
    int ampl = Game.playerAmount;
    int infam = Game.infAmount;
    boolean gmst = Game.serverStatus;

    @Override
    public void onEnable() {
        getCommand("join").setExecutor(new JoinCommand());
        getCommand("status").setExecutor(new ServerStatus());
        getCommand("basic").setExecutor(new BasicKit());
        getCommand("infhelp").setExecutor(new HelpCommand());
        getServer().getPluginManager().registerEvents(new InfectHitInfect(), this);
        getServer().getPluginManager().registerEvents(new InfectPlayersEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
        getServer().getPluginManager().registerEvents(new TabListEvent(), this);


    }

    @Override
    public void onDisable() {
        inf.clear();
        gmst = false;
        ampl = 0;
        infam = 0;
    }
}
