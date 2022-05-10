package simplicity.simplicity.core.init;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.common.properties.blocks.BlueberryBushBlock;
import simplicity.simplicity.common.properties.blocks.FlammableLogBlock;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Simplicity.MOD_ID);

    public static final RegistryObject<Block> EBONY_LOG = BLOCKS.register("ebony_log", () -> new FlammableLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STRIPPED_EBONY_LOG = BLOCKS.register("stripped_ebony_log", () -> new FlammableLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EBONY_WOOD = BLOCKS.register("ebony_wood", () -> new FlammableLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STRIPPED_EBONY_WOOD = BLOCKS.register("stripped_ebony_wood", () -> new FlammableLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EBONY_PLANKS = BLOCKS.register("ebony_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = BLOCKS.register("deepslate_ruby_ore",() -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RED_CORNFLOWER = BLOCKS.register("red_cornflower", () -> new FlowerBlock(MobEffects.DIG_SPEED,6, BlockBehaviour.Properties.copy(Blocks.CORNFLOWER).instabreak().noOcclusion()));
    public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush", () -> new BlueberryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).randomTicks().noCollission().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLUE_NETHER_BRICKS = BLOCKS.register("blue_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS)));

}
