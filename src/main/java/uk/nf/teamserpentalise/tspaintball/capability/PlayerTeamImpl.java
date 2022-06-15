package uk.nf.teamserpentalise.tspaintball.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerTeamImpl implements PlayerTeam
{
    private String Team;

    public PlayerTeamImpl(String team)
    {
        Team = team;
    }


    @Override
    public String GetTeam()
    {
        return this.Team;
    }

    @Override
    public void SetTeam(String Team)
    {
        this.Team = Team;
    }

    @Override
    public CompoundNBT serializeNBT()
    {
        final CompoundNBT nbt = new CompoundNBT();
        nbt.putString("player.team", this.GetTeam());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt)
    {
        this.SetTeam(nbt.getString("player.team"));
    }


}
