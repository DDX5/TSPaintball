package uk.nf.teamserpentalise.tspaintball.item.weapons.shotgun;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;

public class RedShotgunItem extends Item
{

    public RedShotgunItem()
    {
        super(new Properties().tab(TSPaintball.WEAPONS));
    }

    @OnlyIn(Dist.CLIENT)
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
        player.inventory.getItem(SlotIndex).shrink(2);
        ArrowItem Arrow = (ArrowItem) Items.ARROW;
        AbstractArrowEntity abstractarrow = Arrow.createArrow(world,new ItemStack(Items.ARROW),player);
        abstractarrow.shootFromRotation(player,player.xRot,player.yRot,0.0f,5.0f,1.0f);
        abstractarrow.addTag("red");
        world.addFreshEntity(abstractarrow);
        abstractarrow = Arrow.createArrow(world,new ItemStack(Items.ARROW),player);
        abstractarrow.shootFromRotation(player,player.xRot,player.yRot,0.0f,5.0f,1.0f);
        abstractarrow.addTag("red");
        world.addFreshEntity(abstractarrow);
        player.getCooldowns().addCooldown(this,30);
        return ActionResult.pass(player.getItemInHand(hand));
    }
}
