package uk.nf.teamserpentalise.tspaintball.item.init;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;
import uk.nf.teamserpentalise.tspaintball.init.blockinit;
import uk.nf.teamserpentalise.tspaintball.init.iteminit;

public class BlueTeamGearUp extends Item
{

    public BlueTeamGearUp()
    {
        super(new Properties().tab(TSPaintball.UTILS));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
    {
        player.addTag("blue");
        player.spawnAtLocation(new ItemStack(iteminit.BLUE_PISTOL.get()));
        player.spawnAtLocation(new ItemStack(Items.ARROW,32));
        player.spawnAtLocation(new ItemStack(iteminit.BLUE_POD.get(),2));
        player.spawnAtLocation(new ItemStack(iteminit.BLUE_SHOTGUN.get()));
        player.spawnAtLocation(new ItemStack(iteminit.BLUE_MEDKIT.get()));
        player.spawnAtLocation(new ItemStack(iteminit.BLUE_BOOTS.get()));
        player.spawnAtLocation(new ItemStack(iteminit.BLUE_LEGGINGS.get()));
        player.spawnAtLocation(new ItemStack(iteminit.BLUE_CHESTPLATE.get()));
        player.spawnAtLocation(new ItemStack(iteminit.BLUE_HELMET.get()));
        player.spawnAtLocation(new ItemStack(blockinit.FLAG.get(),4));
        player.spawnAtLocation(new ItemStack(iteminit.ROD_OF_REMOVAL.get()));
        player.getItemInHand(hand).shrink(1);
        return ActionResult.pass(player.getItemInHand(hand));
    }
}
