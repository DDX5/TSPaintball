package uk.nf.teamserpentalise.tspaintball.util;

import net.minecraft.nbt.CompoundNBT;

public class PlayerDataHandler
{
    public static int IsSameTeam(CompoundNBT tag, String target)
    {
        if(tag.contains("team"))
        {
            String name = tag.getString("team");
            if(name.matches(target))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return -1;
        }
    }
}
