package uk.nf.teamserpentalise.tspaintball.armor;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.lwjgl.system.CallbackI;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;
import uk.nf.teamserpentalise.tspaintball.util.ArmorMaterial;
import uk.nf.teamserpentalise.tspaintball.util.PlayerDataHandler;

public class PaintballBoots extends ArmorItem
{

    public PaintballBoots(IArmorMaterial p_i48534_1_)
    {
        super(p_i48534_1_, EquipmentSlotType.FEET, new Properties().tab(TSPaintball.UTILS));
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_)
    {
        CompoundNBT Tag = p_77659_2_.serializeNBT();
        ResourceLocation Loc = new ResourceLocation(this.material.getName());
        String Team = Loc.getPath();
        if(Tag.contains("team"))
        {

            TSPaintball.LOG.info(Team);
            int X = PlayerDataHandler.IsSameTeam(Tag,Team);
            if(X == 1)
            {
                return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
            }
            if(X == 0)
            {
                return ActionResult.fail(p_77659_2_.getItemInHand(p_77659_3_));
            }

        }
        else
        {
            Tag.putString("team",Team);
            p_77659_2_.save(Tag);
            return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
        }
        return ActionResult.fail(p_77659_2_.getItemInHand(p_77659_3_));
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
        player.getFoodData().setFoodLevel(10);
        player.getFoodData().setSaturation(0.0f);
        stack.setDamageValue(2000);
    }
}
