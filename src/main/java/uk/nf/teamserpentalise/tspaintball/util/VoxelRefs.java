package uk.nf.teamserpentalise.tspaintball.util;

import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class VoxelRefs
{
    public static VoxelShape MedkitNS(){
        VoxelShape shape = net.minecraft.util.math.shapes.VoxelShapes.empty();
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.125, 0, 0.3125, 0.875, 0.5, 0.6875), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.125, 0.5, 0.4375, 0.25, 0.75, 0.5625), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.75, 0.5, 0.4375, 0.875, 0.75, 0.5625), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.25, 0.625, 0.4375, 0.75, 0.75, 0.5625), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.4375, 0.1875, 0.25, 0.5625, 0.3125, 0.3125), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.4375, 0.1875, 0.6875, 0.5625, 0.3125, 0.75), IBooleanFunction.OR);
        return shape;
    }
    public static VoxelShape MedkitEW()
    {
        VoxelShape shape = net.minecraft.util.math.shapes.VoxelShapes.empty();
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.3125, 0, 0.125, 0.6875, 0.5, 0.875), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.4375, 0.5, 0.75, 0.5625, 0.75, 0.875), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.4375, 0.5, 0.125, 0.5625, 0.75, 0.25), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.4375, 0.625, 0.25, 0.5625, 0.75, 0.75), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.25, 0.1875, 0.4375, 0.3125, 0.3125, 0.5625), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.6875, 0.1875, 0.4375, 0.75, 0.3125, 0.5625), IBooleanFunction.OR);

        return shape;
    }
    public static VoxelShape Pod()
    {
        VoxelShape shape = net.minecraft.util.math.shapes.VoxelShapes.empty();
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0, 0, 0, 1, 0.0625, 1), IBooleanFunction.OR);
        shape = net.minecraft.util.math.shapes.VoxelShapes.join(shape, net.minecraft.util.math.shapes.VoxelShapes.box(0.3125, 0.0625, 0.3125, 0.6875, 1.0625, 0.6875), IBooleanFunction.OR);

        return shape;
    }

    public static VoxelShape FlagE(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0, 0, 1, 0.25, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.25, 0.4375, 0.5625, 1, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.5625, 0.625, 0.4375, 1.0625, 1, 0.5625), IBooleanFunction.OR);

        return shape;
    }

    public static VoxelShape FlagS(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0, 0, 1, 0.25, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.25, 0.4375, 0.5625, 1, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.625, 0.5625, 0.5625, 1, 1.0625), IBooleanFunction.OR);

        return shape;
    }

    public static VoxelShape FlagW(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0, 0, 1, 0.25, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.25, 0.4375, 0.5625, 1, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(-0.0625, 0.625, 0.4375, 0.4375, 1, 0.5625), IBooleanFunction.OR);

        return shape;
    }

    public static VoxelShape FlagN(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0, 0, 1, 0.25, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.25, 0.4375, 0.5625, 1, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.625, -0.0625, 0.5625, 1, 0.4375), IBooleanFunction.OR);

        return shape;
    }

}
