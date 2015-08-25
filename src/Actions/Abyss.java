package Actions;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Abyss
{
    public boolean createAbyss(Block center, int radius, Player player)
    {
        for (int x = -radius; x <= radius; x++)
        {
            for (int y = -radius; y <= radius; y++)
            {
                for (int z = -radius; z <= radius; z++)
                {
                    if (Math.sqrt((x * x) + (y * y) + (z * z)) <= radius)
                    {
                        Block block = center.getWorld().getBlockAt(center.getX() + x, center.getY() + y, center.getZ() + z);

                        if (block.getType() != Material.AIR)
                        {
                            block.setType(Material.AIR);
                        }
                    }
                }
            }
        }

        return  true;
    }
}