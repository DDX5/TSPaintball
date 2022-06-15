package uk.nf.teamserpentalise.tspaintball.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;
import uk.nf.teamserpentalise.tspaintball.capability.PlayerTeamCapability;


@Mod.EventBusSubscriber(modid = TSPaintball.MOD_ID)
public class eventinit
{
    @SubscribeEvent
    public static void Hurt(LivingHurtEvent event)
    {
        TSPaintball.LOG.info("Hurt Event Fired");
        Entity Target = event.getEntity();
        Entity Hit = event.getSource().getDirectEntity();
        TSPaintball.LOG.info("Traget: " + Target.toString() + "\nHit: " + Hit.toString());

    }

    @SubscribeEvent
    public static void AttachCap(AttachCapabilitiesEvent<Entity> event)
    {
        if(event.getObject() instanceof PlayerEntity)
        {
            event.addCapability(new ResourceLocation(TSPaintball.MOD_ID,"player_team"),new PlayerTeamCapability());
        }
    }
}
