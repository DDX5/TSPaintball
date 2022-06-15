package uk.nf.teamserpentalise.tspaintball.block.Pod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import uk.nf.teamserpentalise.tspaintball.util.VoxelRefs;
import uk.nf.teamserpentalise.tspaintball.util.PlayerDataHandler;

import javax.annotation.Nullable;
import java.util.Random;

public class GreenAmmoPod extends Block
{

    public static final IntegerProperty LEVEL = IntegerProperty.create("level",0,4);

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return VoxelRefs.Pod();
    }
    public GreenAmmoPod()
    {
        super(Properties.of(Material.HEAVY_METAL).noOcclusion().randomTicks());
        defaultBlockState().setValue(this.LEVEL,4);
    }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(this.LEVEL);
    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_)
    {
        return this.defaultBlockState().setValue(this.LEVEL,4);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult)
    {
        CompoundNBT Tag = player.getPersistentData();
        if(!Tag.contains("team")){player.displayClientMessage(new StringTextComponent("You Don't Have A Team"),true);return ActionResultType.FAIL;}
        else {
            int R = PlayerDataHandler.IsSameTeam(Tag, "green");
            if (R != 1) {
                player.displayClientMessage(new StringTextComponent("Invalid Team"), true);
                return ActionResultType.FAIL;
            } else {
                int Level = state.getValue(this.LEVEL);
                if (Level == 0) {
                    player.displayClientMessage(new StringTextComponent("Ammo pod on cooldown"), true);
                    return ActionResultType.FAIL;
                } else {
                    player.spawnAtLocation(new ItemStack(Items.ARROW, 64));
                    Level--;
                    BlockState S = state.setValue(this.LEVEL, Level);
                    world.setBlockAndUpdate(pos, S);
                    return ActionResultType.SUCCESS;
                }
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        int Current = state.getValue(this.LEVEL);
        if(Current == 4)
        {
            return;
        }
        Current++;
        BlockState S = state.setValue(this.LEVEL,Current);
        world.setBlockAndUpdate(pos,S);
    }
}
