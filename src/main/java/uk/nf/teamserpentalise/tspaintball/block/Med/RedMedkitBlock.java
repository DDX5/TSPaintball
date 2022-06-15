package uk.nf.teamserpentalise.tspaintball.block.Med;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import uk.nf.teamserpentalise.tspaintball.util.PlayerDataHandler;
import uk.nf.teamserpentalise.tspaintball.util.VoxelRefs;

import javax.annotation.Nullable;
import java.util.Random;

public class RedMedkitBlock extends Block
{
    public static final IntegerProperty LEVEL = IntegerProperty.create("level",0,4);
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_)
    {
        Direction Dir = p_220053_1_.getValue(this.FACING);
        if(Dir == Direction.NORTH || Dir == Direction.SOUTH){
            return VoxelRefs.MedkitNS();
        }
        if(Dir == Direction.EAST || Dir == Direction.WEST){
            return VoxelRefs.MedkitEW();
        }
        return VoxelRefs.MedkitNS();
    }

    public RedMedkitBlock()
    {
        super(AbstractBlock.Properties.of(Material.HEAVY_METAL).noOcclusion().noCollission().randomTicks());
        defaultBlockState().setValue(this.LEVEL,4).setValue(FACING,Direction.NORTH);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(this.LEVEL,this.FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_)
    {
        return this.defaultBlockState().setValue(this.LEVEL,4).setValue(FACING,p_196258_1_.getPlayer().getDirection().getOpposite());
    }

    @Override
    public boolean isRandomlyTicking(BlockState p_149653_1_)
    {
        return true;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult)
    {
        CompoundNBT Tag = player.getPersistentData();
        if(!Tag.contains("team")){player.displayClientMessage(new StringTextComponent("You Don't Have A Team"),true);return ActionResultType.FAIL;}
        else
        {
            int R = PlayerDataHandler.IsSameTeam(Tag,"red");
            if(R != 1)
            {
                player.displayClientMessage(new StringTextComponent("Invalid Team"),true);
                return ActionResultType.FAIL;
            }
            else
            {
                int Current = state.getValue(this.LEVEL);
                if(Current == 0)
                {
                    player.displayClientMessage(new StringTextComponent("Med kit on cooldown"),true);
                    return ActionResultType.FAIL;
                }
                player.heal(50.0f);
                Current--;
                BlockState S = state.setValue(this.LEVEL,Current);
                world.setBlockAndUpdate(pos,S);
                return ActionResultType.SUCCESS;
            }
        }
    }

    @Override
    public void randomTick(BlockState blockState, ServerWorld world, BlockPos pos, Random random)
    {
        int Current = blockState.getValue(this.LEVEL);
        if(Current == 4)
        {
          return;
        }
        Current++;
        BlockState S = blockState.setValue(this.LEVEL,Current);
        world.setBlockAndUpdate(pos,S);
    }

}
