package uk.nf.teamserpentalise.tspaintball.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class CapabilityTeamStorage implements Capability.IStorage<PlayerTeam>
{


    @Nullable
    @Override
    public INBT writeNBT(Capability<PlayerTeam> capability, PlayerTeam instance, Direction side)
    {
        CompoundNBT Tag = new CompoundNBT();
        Tag.putString("player.team",instance.GetTeam());
        return Tag;
    }

    @Override
    public void readNBT(Capability<PlayerTeam> capability, PlayerTeam instance, Direction side, INBT nbt)
    {
        instance.SetTeam(nbt.getAsString());
    }
}
