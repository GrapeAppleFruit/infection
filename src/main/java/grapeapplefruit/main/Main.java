package grapeapplefruit.main;

import grapeapplefruit.main.gameevents.AllPlayersInf;
import grapeapplefruit.main.gameevents.InfHitInf;
import grapeapplefruit.main.gameevents.InfectionHit;
import grapeapplefruit.main.infgui.Gui;
import grapeapplefruit.main.infgui.GuiListener;
import grapeapplefruit.main.infgui.KitGui;
import grapeapplefruit.main.infgui.KitGuiListener;
import grapeapplefruit.main.kitcommands.BasicKitCommand;
import grapeapplefruit.main.gamecommands.EndGameCommand;
import grapeapplefruit.main.gamecommands.StartGameCommand;
import grapeapplefruit.main.kitcommands.StoneKitCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("start").setExecutor(new StartGameCommand());
        getCommand("end").setExecutor(new EndGameCommand());
        getCommand("basic").setExecutor(new BasicKitCommand());
        getCommand("help").setExecutor(new HelpCommand());
        getCommand("stone").setExecutor(new StoneKitCommand());
        getCommand("infgui").setExecutor(new Gui());
        getCommand("kitgui").setExecutor(new KitGui());
        getServer().getPluginManager().registerEvents(new KitGuiListener(), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        getServer().getPluginManager().registerEvents(new AllPlayersInf(), this);
        getServer().getPluginManager().registerEvents(new InfectionHit(), this);
        getServer().getPluginManager().registerEvents(new InfHitInf(), this);
        System.out.println(" ====================  ");
        System.out.println("    Infection v4.0      ");
        System.out.println("  By GrapeAppleFruit   ");
        System.out.println(" ====================  ");

    }

    @Override
    public void onDisable() {

    }
}
