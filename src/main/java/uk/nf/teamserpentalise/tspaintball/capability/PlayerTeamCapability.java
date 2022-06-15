package uk.nf.teamserpentalise.tspaintball.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerTeamCapability implements PlayerTeam, ICapabilitySerializable<CompoundNBT>
{

    public String team;

    public PlayerTeamCapability() {this.team = "";}

    @Override
    public void SetTeam(String string) {
        this.team = string;
    }

    @Override
    public String GetTeam() {
        return this.team;
    }

    @CapabilityInject(PlayerTeam.class)
    public static final Capability<PlayerTeam> TEAM_CAPABILITY = null;

    private LazyOptional<PlayerTeam> instance = LazyOptional.of(TEAM_CAPABILITY::getDefaultInstance);


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == TEAM_CAPABILITY ? instance.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT()
    {
        CompoundNBT Tag = new CompoundNBT();
        Tag.putString("player.team",TEAM_CAPABILITY.getStorage().writeNBT(TEAM_CAPABILITY,this.instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null).getAsString());
        return Tag;
    }


    @Override
    public void deserializeNBT(CompoundNBT nbt)
    {
        TEAM_CAPABILITY.getStorage().readNBT(TEAM_CAPABILITY, this.instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null, nbt);
    }

}
