package uk.nf.teamserpentalise.tspaintball.init;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;

public class armorinit
{
    public static final DeferredRegister<Item> ARMOR_SOLDIER = DeferredRegister.create(ForgeRegistries.ITEMS, TSPaintball.MOD_ID);
    public static final DeferredRegister<Item> ARMOR_SNIPER = DeferredRegister.create(ForgeRegistries.ITEMS, TSPaintball.MOD_ID);
    public static final DeferredRegister<Item> ARMOR_HEAVY = DeferredRegister.create(ForgeRegistries.ITEMS, TSPaintball.MOD_ID);
    public static final DeferredRegister<Item> ARMOR_MEDIC = DeferredRegister.create(ForgeRegistries.ITEMS, TSPaintball.MOD_ID);
    public static final DeferredRegister<Item> ARMOR_CAPTAIN = DeferredRegister.create(ForgeRegistries.ITEMS, TSPaintball.MOD_ID);
    public static final DeferredRegister<Item> ARMOR_SPECIALIST = DeferredRegister.create(ForgeRegistries.ITEMS, TSPaintball.MOD_ID);



    public static void RegAll(IEventBus bus)
    {
        ARMOR_CAPTAIN.register(bus);
        ARMOR_MEDIC.register(bus);
        ARMOR_SOLDIER.register(bus);
        ARMOR_SNIPER.register(bus);
        ARMOR_HEAVY.register(bus);
        ARMOR_SPECIALIST.register(bus);
    }
}
