import Actions.Teleport;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class AbyssCreatorPlugin extends JavaPlugin
{
    public static Logger log = Logger.getLogger("Minecraft");

    Teleport teleport;

    public void onLoad()
    {
        log.info("[AbyssCreatorPlugin] is loading.");
    }

    public void onEnable()
    {
        Bukkit.getPluginManager().registerEvents(new AbyssCreatorListener(this), this);
        teleport = new Teleport();

        log.info("[AbyssCreatorPlugin] is enabling.");
    }

    public void onDisable()
    {
        log.info("[AbyssCreatorPlugin] is shutting down...");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[]args)
    {
        if (command.getName().equalsIgnoreCase("abyss"))
        {
            if(args.length < 1 || args.length > 2)
            {
                sender.sendMessage("Please specifiy a radius.");
                return true;
            }

            int rad = Integer.parseInt(args[0]);

            if(rad < 1 || rad > 10)
            {
                sender.sendMessage("Please choose a radius between 1 and 10.");
                return true;
            }

            Player player = (Player) sender;
            Location loc = player.getLocation();

            int playerX = (int) loc.getX();
            int playerY = (int) loc.getY();
            int playerZ = (int) loc.getZ();

            World world = player.getWorld();
            Block block = world.getBlockAt(playerX, playerY - 1, playerZ);

            return teleport.teleportPlayer(block, rad, player, false);
        }

        else if (command.getName().equalsIgnoreCase("lavaPool"))
        {
            if(args.length < 1 || args.length > 2)
            {
                sender.sendMessage("Please specifiy a radius.");
                return true;
            }

            int rad = Integer.parseInt(args[0]);

            if(rad < 1 || rad > 10)
            {
                sender.sendMessage("Please choose a radius between 1 and 10.");
                return true;
            }

            Player player = (Player) sender;
            Location loc = player.getLocation();

            int playerX = (int) loc.getX();
            int playerY = (int) loc.getY();
            int playerZ = (int) loc.getZ();

            World world = player.getWorld();
            Block block = world.getBlockAt(playerX, playerY - 1, playerZ);

            return teleport.teleportPlayer(block, rad, player, true);
        }

        return true;
    }
}