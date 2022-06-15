package uk.nf.teamserpentalise.tspaintball.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;
import uk.nf.teamserpentalise.tspaintball.block.FlagBlock;
import uk.nf.teamserpentalise.tspaintball.block.Med.BlueMedkitBlock;
import uk.nf.teamserpentalise.tspaintball.block.Med.GreenMedkitBlock;
import uk.nf.teamserpentalise.tspaintball.block.Med.RedMedkitBlock;
import uk.nf.teamserpentalise.tspaintball.block.Pod.BlueAmmoPod;
import uk.nf.teamserpentalise.tspaintball.block.Pod.GreenAmmoPod;
import uk.nf.teamserpentalise.tspaintball.block.Pod.RedAmmoPod;

public class blockinit
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TSPaintball.MOD_ID);

    public static final RegistryObject<Block> RED_MEDKIT = BLOCKS.register("red_medkit", RedMedkitBlock::new);
    public static final RegistryObject<Block> BLUE_MEDKIT = BLOCKS.register("blue_medkit", BlueMedkitBlock::new);
    public static final RegistryObject<Block> GREEN_MEDKIT = BLOCKS.register("green_medkit", GreenMedkitBlock::new);

    public static final RegistryObject<Block> RED_POD = BLOCKS.register("red_pod", RedAmmoPod::new);
    public static final RegistryObject<Block> BLUE_POD = BLOCKS.register("blue_pod", BlueAmmoPod::new);
    public static final RegistryObject<Block> GREEN_POD = BLOCKS.register("green_pod", GreenAmmoPod::new);

    public static final RegistryObject<Block> FLAG = BLOCKS.register("flag", FlagBlock::new);
}
