package grapeapplefruit.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Game implements Listener {

    public static Set<String> infected = new HashSet<>();
    public static Set<String> ing = new HashSet<>();
    public static Set<String > spect = new HashSet<>();
    public static Set<String> survivor = new HashSet<>();

    public static boolean game = false;

    public static int players = 0;
    public static int infectedp = 0;
    public static int survp = 0;


}
