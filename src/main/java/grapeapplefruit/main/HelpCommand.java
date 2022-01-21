package grapeapplefruit.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("help")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                player.sendMessage("  =======================  ");
                player.sendMessage("       Infection help!     ");
                player.sendMessage("  =======================  ");
                player.sendMessage("  /help - Get plugin help  ");
                player.sendMessage("  /start - Start the game  ");
                player.sendMessage("  /end - End the game      ");
                player.sendMessage("  /basic - Get the basic kit");
            } else {
                System.out.println("  =======================  ");
                System.out.println("       Infection help!     ");
                System.out.println("  =======================  ");
                System.out.println("  /help - Get plugin help  ");
                System.out.println("  /start - Start the game  ");
                System.out.println("  /end - End the game      ");
                System.out.println("  /basic - Get the basic kit");
            }
        }
        return false;
    }
}
