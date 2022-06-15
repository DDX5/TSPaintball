package uk.nf.teamserpentalise.tspaintball.item.weapons.pistol;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;

public class BluePistolItem extends Item
{

    public BluePistolItem()
    {
        super(new Properties().tab(TSPaintball.WEAPONS));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
    {
        if(!player.getPersistentData().contains("team")){player.displayClientMessage(new StringTextComponent("You Don't Have A Team"),true);return ActionResult.fail(player.getItemInHand(hand));}
        boolean HasArrow = player.inventory.contains(new ItemStack(Items.ARROW));
        if(!HasArrow)
        {
            return ActionResult.fail(player.getItemInHand(hand));
        }
        int SlotIndex = player.inventory.findSlotMatchingItem(new ItemStack(Items.ARROW));
        player.inventory.getItem(SlotIndex).shrink(1);
        ArrowItem Arrow = (ArrowItem) Items.ARROW;
        AbstractArrowEntity abstractarrow = Arrow.createArrow(world,new ItemStack(Items.ARROW),player);
        abstractarrow.shootFromRotation(player,player.xRot,player.yRot,0.0f,3.0f,1.0f);
        CompoundNBT Tag = abstractarrow.serializeNBT();
        Tag.putString("team","blue");
        abstractarrow.save(Tag);
        world.addFreshEntity(abstractarrow);
        player.getCooldowns().addCooldown(this,10);
        return ActionResult.pass(player.getItemInHand(hand));
    }
}
