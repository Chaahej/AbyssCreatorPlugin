package Actions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Teleport
{
    Abyss abyss;
    LavaPool lavaPool;

    public Teleport()
    {
        abyss = new Abyss();
        lavaPool = new LavaPool();
    }

    public boolean teleportPlayer(Block center, int radius, Player player, boolean lava)
    {
        World world = player.getWorld();

        for (int x = -radius; x <= radius; x++)
        {
            for (int z = -radius; z <= radius; z++)
            {
                if (x == -radius || x == radius || z == -radius || z == radius)
                {
                    Block block = center.getWorld().getBlockAt(center.getX() + x, center.getY(), center.getZ() + z);

                    double xPos = block.getLocation().getX();
                    double yPos = block.getLocation().getY() + 1;
                    double zPos = block.getLocation().getZ();

                    int[] offsetsAir =
                    {
                        1,2
                    };

                    for(int i = 0; i < offsetsAir.length; i++)
                    {
                        int y = offsetsAir[i];

                        Block airBlocks = world.getBlockAt(block.getX(), block.getY() + y, block.getZ());

                        airBlocks.setType(Material.AIR);
                    }

                    Block groundBlock = world.getBlockAt(block.getX(), block.getY(), block.getZ());

                    groundBlock.setType(Material.DIRT);

                    Location location = new Location(player.getWorld(), xPos + 0.5, yPos, zPos + 0.5);
                    player.teleport(location);

                    if(lava)
                    {
                        return lavaPool.createLavaPool(center, radius, player);
                    }

                    else
                    {
                        return abyss.createAbyss(center, radius, player);
                    }
                }
            }
        }

        return  true;
    }
}