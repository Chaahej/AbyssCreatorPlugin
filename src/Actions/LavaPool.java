package Actions;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class LavaPool
{
    public boolean createLavaPool(Block center, int radius, Player player)
    {
        for (int x = -radius; x <= radius; x++)
        {
            for (int z = -radius; z <= radius; z++)
            {
                if (Math.sqrt((x * x) + (z * z)) <= radius)
                {
                    Block block = center.getWorld().getBlockAt(center.getX() + x, center.getY(), center.getZ() + z);

                    if (block.getType() != Material.AIR)
                    {
                        block.setType(Material.LAVA);
                    }
                }
            }
        }

        return  true;
    }
}