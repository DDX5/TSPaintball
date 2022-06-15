package uk.nf.teamserpentalise.tspaintball.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.storage.PlayerData;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;
import uk.nf.teamserpentalise.tspaintball.util.PlayerDataHandler;

import java.util.Set;

public class PlayerDataItem extends Item
{

    public PlayerDataItem()
    {
        super(new Properties().tab(TSPaintball.UTILS));
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_)
    {
        CompoundNBT tag = p_77659_2_.getPersistentData();
        int X = PlayerDataHandler.IsSameTeam(tag,"green");
        p_77659_2_.displayClientMessage(new StringTextComponent("Return: " + X),true);
        return ActionResult.pass(p_77659_2_.getItemInHand(p_77659_3_));
    }
}
