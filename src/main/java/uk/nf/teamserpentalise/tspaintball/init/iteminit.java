package uk.nf.teamserpentalise.tspaintball.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;
import uk.nf.teamserpentalise.tspaintball.armor.PaintballBoots;
import uk.nf.teamserpentalise.tspaintball.armor.PaintballChestplate;
import uk.nf.teamserpentalise.tspaintball.armor.PaintballHelmet;
import uk.nf.teamserpentalise.tspaintball.armor.PaintballLeggigs;
import uk.nf.teamserpentalise.tspaintball.item.PlayerDataItem;
import uk.nf.teamserpentalise.tspaintball.item.RodOfRemoval;
import uk.nf.teamserpentalise.tspaintball.item.init.BlueTeamGearUp;
import uk.nf.teamserpentalise.tspaintball.item.init.GreenTeamGearUp;
import uk.nf.teamserpentalise.tspaintball.item.init.RedTeamGearUp;
import uk.nf.teamserpentalise.tspaintball.item.init.WhiteTeamGearUp;
import uk.nf.teamserpentalise.tspaintball.item.weapons.pistol.BluePistolItem;
import uk.nf.teamserpentalise.tspaintball.item.weapons.pistol.GreenPistolItem;
import uk.nf.teamserpentalise.tspaintball.item.weapons.pistol.RedPistolItem;
import uk.nf.teamserpentalise.tspaintball.item.weapons.shotgun.BlueShotgunItem;
import uk.nf.teamserpentalise.tspaintball.item.weapons.shotgun.GreenShotgunItem;
import uk.nf.teamserpentalise.tspaintball.item.weapons.shotgun.RedShotgunItem;
import uk.nf.teamserpentalise.tspaintball.util.ArmorMaterial;

public class iteminit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TSPaintball.MOD_ID);

    //Utility Items
    public static final RegistryObject<Item> ROD_OF_REMOVAL = ITEMS.register("remove", RodOfRemoval::new);

    //Weapons
    public static final RegistryObject<Item> RED_PISTOL = ITEMS.register("red_pistol", RedPistolItem::new);
    public static final RegistryObject<Item> GREEN_PISTOL = ITEMS.register("green_pistol", GreenPistolItem::new);
    public static final RegistryObject<Item> BLUE_PISTOL = ITEMS.register("blue_pistol", BluePistolItem::new);

    public static final RegistryObject<Item> RED_SHOTGUN = ITEMS.register("red_shotgun", RedShotgunItem::new);
    public static final RegistryObject<Item> GREEN_SHOTGUN = ITEMS.register("green_shotgun", GreenShotgunItem::new);
    public static final RegistryObject<Item> BLUE_SHOTGUN = ITEMS.register("blue_shotgun", BlueShotgunItem::new);

    //Armor
    public static final RegistryObject<Item> RED_HELMET = ITEMS.register("red_helmet",() -> new PaintballHelmet(ArmorMaterial.RED_ARMOR));
    public static final RegistryObject<Item> RED_CHESTPLATE = ITEMS.register("red_chestplate",() -> new PaintballChestplate(ArmorMaterial.RED_ARMOR));
    public static final RegistryObject<Item> RED_LEGGINGS = ITEMS.register("red_leggings",() -> new PaintballLeggigs(ArmorMaterial.RED_ARMOR));
    public static final RegistryObject<Item> RED_BOOTS = ITEMS.register("red_boots",() -> new PaintballBoots(ArmorMaterial.RED_ARMOR));

    public static final RegistryObject<Item> BLUE_HELMET = ITEMS.register("blue_helmet",() -> new PaintballHelmet(ArmorMaterial.BLUE_ARMOR));
    public static final RegistryObject<Item> BLUE_CHESTPLATE = ITEMS.register("blue_chestplate",() -> new PaintballChestplate(ArmorMaterial.BLUE_ARMOR));
    public static final RegistryObject<Item> BLUE_LEGGINGS = ITEMS.register("blue_leggings",() -> new PaintballLeggigs(ArmorMaterial.BLUE_ARMOR));
    public static final RegistryObject<Item> BLUE_BOOTS = ITEMS.register("blue_boots",() -> new PaintballBoots(ArmorMaterial.BLUE_ARMOR));

    public static final RegistryObject<Item> GREEN_HELMET = ITEMS.register("green_helmet",() -> new PaintballHelmet(ArmorMaterial.GREEN_ARMOR));
    public static final RegistryObject<Item> GREEN_CHESTPLATE = ITEMS.register("green_chestplate",() -> new PaintballChestplate(ArmorMaterial.GREEN_ARMOR));
    public static final RegistryObject<Item> GREEN_LEGGINGS = ITEMS.register("green_leggings",() -> new PaintballLeggigs(ArmorMaterial.GREEN_ARMOR));
    public static final RegistryObject<Item> GREEN_BOOTS = ITEMS.register("green_boots",() -> new PaintballBoots(ArmorMaterial.GREEN_ARMOR));

    public static final RegistryObject<Item> WHITE_HELMET = ITEMS.register("white_helmet",() -> new PaintballHelmet(ArmorMaterial.WHITE));
    public static final RegistryObject<Item> WHITE_CHESTPLATE = ITEMS.register("white_chestplate",() -> new PaintballChestplate(ArmorMaterial.WHITE));
    public static final RegistryObject<Item> WHITE_LEGGINGS = ITEMS.register("white_leggings",() -> new PaintballLeggigs(ArmorMaterial.WHITE));
    public static final RegistryObject<Item> WHITE_BOOTS = ITEMS.register("white_boots",() -> new PaintballBoots(ArmorMaterial.WHITE));

    //BlockItem
    public static final RegistryObject<BlockItem> FLAG = ITEMS.register("flag",() -> new BlockItem(blockinit.FLAG.get(),new Item.Properties().tab(TSPaintball.UTILS)));
    public static final RegistryObject<BlockItem> RED_MEDKIT = ITEMS.register("red_medkit", () -> new BlockItem(blockinit.RED_MEDKIT.get(),new Item.Properties().tab(TSPaintball.UTILS)));
    public static final RegistryObject<BlockItem> GREEN_MEDKIT = ITEMS.register("green_medkit", () -> new BlockItem(blockinit.GREEN_MEDKIT.get(),new Item.Properties().tab(TSPaintball.UTILS)));
    public static final RegistryObject<BlockItem> BLUE_MEDKIT = ITEMS.register("blue_medkit", () -> new BlockItem(blockinit.BLUE_MEDKIT.get(),new Item.Properties().tab(TSPaintball.UTILS)));

    public static final RegistryObject<BlockItem> RED_POD = ITEMS.register("red_pod", () -> new BlockItem(blockinit.RED_POD.get(),new Item.Properties().tab(TSPaintball.UTILS)));
    public static final RegistryObject<BlockItem> GREEN_POD = ITEMS.register("green_pod", () -> new BlockItem(blockinit.GREEN_POD.get(),new Item.Properties().tab(TSPaintball.UTILS)));
    public static final RegistryObject<BlockItem> BLUE_POD = ITEMS.register("blue_pod", () -> new BlockItem(blockinit.BLUE_POD.get(),new Item.Properties().tab(TSPaintball.UTILS)));

    //Equip Item

    public static final RegistryObject<Item> RED_GEAR = ITEMS.register("red_equip", RedTeamGearUp::new);
    public static final RegistryObject<Item> BLUE_GEAR = ITEMS.register("blue_equip", BlueTeamGearUp::new);
    public static final RegistryObject<Item> GREEN_GEAR = ITEMS.register("green_equip", GreenTeamGearUp::new);
    public static final RegistryObject<Item> REF_GEAR = ITEMS.register("ref_equip", WhiteTeamGearUp::new);
}
