package simplicity.simplicity.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.core.init.BlockInit;

/**
 * Author: Autovw
 */
public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cubeAllModBlock(BlockInit.RUBY_ORE.get(), new ResourceLocation(Simplicity.MOD_ID, "block/ruby_ore"));
        cubeAllModBlock(BlockInit.DEEPSLATE_RUBY_ORE.get(), new ResourceLocation(Simplicity.MOD_ID, "block/deepslate_ruby_ore"));
        cubeAllModBlock(BlockInit.RUBY_BLOCK.get(), new ResourceLocation(Simplicity.MOD_ID, "block/ruby_block"));

        logModBlock(BlockInit.EBONY_LOG.get(), new ResourceLocation(Simplicity.MOD_ID, "block/ebony_log"), new ResourceLocation(Simplicity.MOD_ID, "block/ebony_log_top"));
        logModBlock(BlockInit.STRIPPED_EBONY_LOG.get(), new ResourceLocation(Simplicity.MOD_ID, "block/stripped_ebony_log"), new ResourceLocation(Simplicity.MOD_ID, "block/stripped_ebony_log_top"));

        flowerModBlock(BlockInit.RED_CORNFLOWER.get(), new ResourceLocation(Simplicity.MOD_ID, "block/red_cornflower"));
    }

    /**
     * Generates an item model, block model and blockstate for a block at once
     * @param block     Block you want to generate models and blockstates for
     * @param texture   Block texture
     */
    protected void cubeAllModBlock(Block block, ResourceLocation texture) {
        String path = block.getRegistryName().getPath();
        simpleBlock(block, models().cubeAll(path, texture));
        itemModels().withExistingParent(path, new ResourceLocation(block.getRegistryName().getNamespace(), "block/" + path));
    }

    /**
     * Generates an item model, block model and blockstate for a log block at once
     * @param log           Log you want to generate models and blockstates for
     * @param textureSide   Side texture
     * @param textureTop    Top texture
     */
    protected void logModBlock(Block log, ResourceLocation textureSide, ResourceLocation textureTop) {
        String path = log.getRegistryName().getPath();
        axisBlock((RotatedPillarBlock) log, textureSide, textureTop);
        itemModels().withExistingParent(path, new ResourceLocation(log.getRegistryName().getNamespace(), "block/" + path));
    }

    /**
     * Generates an item model, block model and blockstate for a flower block at once
     * @param flower    Flower block you want to generate models and blockstates for
     * @param texture   Flower texture
     */
    protected void flowerModBlock(Block flower, ResourceLocation texture) {
        String path = flower.getRegistryName().getPath();
        simpleBlock(flower, models().cross(path, texture));
        itemModels().withExistingParent(path, new ResourceLocation("item/generated")).texture("layer0", "block/" + path);
    }
}
