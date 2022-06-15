package uk.nf.teamserpentalise.tspaintball;


import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.nf.teamserpentalise.tspaintball.capability.CapabilityTeamStorage;
import uk.nf.teamserpentalise.tspaintball.capability.PlayerTeam;
import uk.nf.teamserpentalise.tspaintball.capability.PlayerTeamCapability;
import uk.nf.teamserpentalise.tspaintball.init.*;

@Mod(TSPaintball.MOD_ID)
public class TSPaintball
{
    public static final String MOD_ID = "tspaintball";
    public static final Logger LOG = LogManager.getLogger();
    public TSPaintball()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(eventinit.class);
        blockinit.BLOCKS.register(bus);
        iteminit.ITEMS.register(bus);
        armorinit.RegAll(bus);
        entityinit.ENTITIES.register(bus);
        bus.addListener(this::ClientSetup);
        bus.addListener(this::CommonSetup);
        bus.register(this);
    }
    public void ClientSetup(FMLClientSetupEvent event)
    {

    }
    public void CommonSetup(FMLCommonSetupEvent event){
        CapabilityManager.INSTANCE.register(PlayerTeam.class, new CapabilityTeamStorage(), PlayerTeamCapability::new);
    }

    public static final ItemGroup WEAPONS = new ItemGroup("weapons") {
        @Override
        public ItemStack makeIcon() {
                return new ItemStack(iteminit.RED_PISTOL.get());
            }
    };
    public static final ItemGroup UTILS = new ItemGroup("utilities") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(blockinit.RED_MEDKIT.get());
        }
    };
}
