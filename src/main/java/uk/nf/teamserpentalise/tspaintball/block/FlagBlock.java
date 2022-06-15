package uk.nf.teamserpentalise.tspaintball.block;

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
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;
import uk.nf.teamserpentalise.tspaintball.util.VoxelRefs;

public class FlagBlock extends Block
{

    public static final IntegerProperty TEAM = IntegerProperty.create("team",0,3);
    public static final DirectionProperty FACING = DirectionProperty.create("facing",Direction.Plane.HORIZONTAL);

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        Direction Dir = p_220053_1_.getValue(this.FACING);
        if(Dir == Direction.NORTH){
            return VoxelRefs.FlagN();
        }
        if(Dir == Direction.EAST){
            return VoxelRefs.FlagE();
        }
        if(Dir == Direction.SOUTH){
            return VoxelRefs.FlagS();
        }
        if(Dir == Direction.WEST){
            return VoxelRefs.FlagW();
        }
        return VoxelRefs.FlagN();
    }

    public FlagBlock()
    {
        super(Properties.of(Material.HEAVY_METAL).noOcclusion());
        defaultBlockState().setValue(this.TEAM, 0).setValue(FACING, Direction.NORTH);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_)
    {
        p_206840_1_.add(this.FACING,this.TEAM);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_)
    {
        BlockState Base = defaultBlockState();
        Base = Base.setValue(this.FACING,p_196258_1_.getPlayer().getDirection().getOpposite());
        Base = Base.setValue(this.TEAM,0);
        return Base;
    }

    @Override
    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_)
    {
        CompoundNBT Tag = p_225533_4_.getPersistentData();
        if(!Tag.contains("team"))
        {
            return ActionResultType.FAIL;
        }
        else
        {
            String TeamName = Tag.getString("team");
            int I = -1;
            if(TeamName.matches("green")){ I = 2;}
            if(TeamName.matches("white")){ I = 0;}
            if(TeamName.matches("red")){ I = 1;}
            if(TeamName.matches("blue")){ I = 3;}
            TSPaintball.LOG.info("Current Value: " + I);
            BlockState C = p_225533_1_.setValue(this.TEAM,I);
            p_225533_2_.setBlockAndUpdate(p_225533_3_,C);
        }
        return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
    }
}
