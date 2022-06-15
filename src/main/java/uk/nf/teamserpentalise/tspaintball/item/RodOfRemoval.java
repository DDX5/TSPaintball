package uk.nf.teamserpentalise.tspaintball.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;
import uk.nf.teamserpentalise.tspaintball.init.iteminit;

public class RodOfRemoval extends Item
{

    public RodOfRemoval()
    {
        super(new Properties().tab(TSPaintball.UTILS));
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_)
    {
       CompoundNBT Tag = p_77659_2_.getPersistentData();
       Tag.remove("team");
       p_77659_2_.save(Tag);
       p_77659_2_.inventory.armor.clear();
       p_77659_2_.displayClientMessage(new StringTextComponent("Team Has Now Been Removed By The Rod Of Removal"),true);
       p_77659_2_.getItemInHand(p_77659_3_).shrink(1);
       return ActionResult.pass(p_77659_2_.getItemInHand(p_77659_3_));
    }
}
