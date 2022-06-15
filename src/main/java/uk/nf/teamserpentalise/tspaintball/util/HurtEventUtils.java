package uk.nf.teamserpentalise.tspaintball.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.player.PlayerEvent;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;

public class HurtEventUtils
{
    public static boolean ShouldCancel(PlayerEntity player, ArrowEntity arrow)
    {
        TSPaintball.LOG.info("ShouldCancel Called");
        CompoundNBT ArrowTag = arrow.serializeNBT();
        CompoundNBT PlayerTag = player.getPersistentData();
        TSPaintball.LOG.info("NBT Read Complete");
        if(ArrowTag.contains("team") && PlayerTag.contains("team"))
        {
            TSPaintball.LOG.info("Tags Exist");
            String ArrowTeam = ArrowTag.getString("team");
            String PlayerTeam = PlayerTag.getString("team");
            if(ArrowTeam.matches(PlayerTeam))
            {
                TSPaintball.LOG.info("Friendly Fire");
                return false;
            }
            TSPaintball.LOG.info("Not Friendly Fire");
            return true;
        }
        TSPaintball.LOG.info("Tags Don't Exist");
        return true;
    }
}
