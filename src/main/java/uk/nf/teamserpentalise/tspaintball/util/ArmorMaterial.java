package uk.nf.teamserpentalise.tspaintball.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;

public enum ArmorMaterial implements IArmorMaterial
{
    RED_ARMOR(new int[] {0,0,0,0},new int[] {2000,2000,2000,2000},0,Ingredient.EMPTY, SoundEvents.ARMOR_EQUIP_LEATHER,"red",0.0f,0.0f),
    GREEN_ARMOR(new int[] {0,0,0,0},new int[] {2000,2000,2000,2000},0,Ingredient.EMPTY, SoundEvents.ARMOR_EQUIP_LEATHER,"green",0.0f,0.0f),
    BLUE_ARMOR(new int[] {0,0,0,0},new int[] {2000,2000,2000,2000},0,Ingredient.EMPTY, SoundEvents.ARMOR_EQUIP_LEATHER,"blue",0.0f,0.0f),
    WHITE(new int[] {0,0,0,0},new int[] {2000,2000,2000,2000},0,Ingredient.EMPTY,SoundEvents.ARMOR_EQUIP_LEATHER,"white",0.0f,0.0f);

    private final int[] Defense;
    private final int[] Durability;
    private final int Enchant;
    private final Ingredient repair;
    private final SoundEvent sound;
    private final String name;
    private final float tough;
    private final float resistance;

    ArmorMaterial(int[] defense, int[] durability, int enchant, Ingredient repair, SoundEvent sound, String name, float tough, float resistance) {
        Defense = defense;
        Durability = durability;
        Enchant = enchant;
        this.repair = repair;
        this.sound = sound;
        this.name = name;
        this.tough = tough;
        this.resistance = resistance;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
        return 0;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return TSPaintball.MOD_ID + ":" + name;
    }

    public String getTeamName(){return this.name;}

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
