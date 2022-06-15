package uk.nf.teamserpentalise.tspaintball.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;

public interface PlayerTeam extends INBTSerializable<CompoundNBT>
{
    String GetTeam();
    void SetTeam(String Team);



}