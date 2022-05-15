package simplicity.simplicity.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.common.properties.blocks.BlueberryBushBlock;
import simplicity.simplicity.core.init.BlockInit;
import simplicity.simplicity.core.init.ItemInit;

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
        cubeAllModBlock(BlockInit.BLUE_NETHER_BRICKS.get(), new ResourceLocation(Simplicity.MOD_ID, "block/blue_nether_bricks"));
        cubeAllModBlock(BlockInit.EBONY_PLANKS.get(), new ResourceLocation(Simplicity.MOD_ID, "block/ebony_planks"));
        leavesModBlock(BlockInit.EBONY_LEAVES.get(), new ResourceLocation(Simplicity.MOD_ID, "block/ebony_leaves"));

        logModBlock(BlockInit.EBONY_LOG.get(), new ResourceLocation(Simplicity.MOD_ID, "block/ebony_log"), new ResourceLocation(Simplicity.MOD_ID, "block/ebony_log_top"));
        logModBlock(BlockInit.STRIPPED_EBONY_LOG.get(), new ResourceLocation(Simplicity.MOD_ID, "block/stripped_ebony_log"), new ResourceLocation(Simplicity.MOD_ID, "block/stripped_ebony_log_top"));
        logModBlock(BlockInit.EBONY_WOOD.get(), new ResourceLocation(Simplicity.MOD_ID, "block/ebony_log"), new ResourceLocation(Simplicity.MOD_ID, "block/ebony_log"));
        logModBlock(BlockInit.STRIPPED_EBONY_WOOD.get(), new ResourceLocation(Simplicity.MOD_ID, "block/stripped_ebony_log"), new ResourceLocation(Simplicity.MOD_ID, "block/stripped_ebony_log"));

        flowerModBlock(BlockInit.RED_CORNFLOWER.get(), new ResourceLocation(Simplicity.MOD_ID, "block/red_cornflower"));

        bushModBlock(BlockInit.BLUEBERRY_BUSH.get(), new ResourceLocation(Simplicity.MOD_ID, "block/blueberry_bush_stage0"), new ResourceLocation(Simplicity.MOD_ID, "block/blueberry_bush_stage1"), new ResourceLocation(Simplicity.MOD_ID, "block/blueberry_bush_stage2"), new ResourceLocation(Simplicity.MOD_ID, "block/blueberry_bush_stage3"), ItemInit.BLUEBERRIES.get(), new ResourceLocation(Simplicity.MOD_ID, "item/blueberries"));
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


    protected void bushModBlock(Block bush, ResourceLocation textureStage0, ResourceLocation textureStage1, ResourceLocation textureStage2, ResourceLocation textureStage3, Item itemVariant, ResourceLocation itemTexture) {
        String path = bush.getRegistryName().getPath(); // path of block
        String itemPath = itemVariant.getRegistryName().getPath(); // path of item
        // block models
        ModelFile stage0 = models().cross(path + "_stage0", textureStage0);
        ModelFile stage1 = models().cross(path + "_stage1", textureStage1);
        ModelFile stage2 = models().cross(path + "_stage2", textureStage2);
        ModelFile stage3 = models().cross(path + "_stage3", textureStage3);
        // blockstates
        getVariantBuilder(bush)
                .partialState().with(BlueberryBushBlock.AGE, 0)
                .modelForState().modelFile(stage0).addModel()
                .partialState().with(BlueberryBushBlock.AGE, 1)
                .modelForState().modelFile(stage1).addModel()
                .partialState().with(BlueberryBushBlock.AGE, 2)
                .modelForState().modelFile(stage2).addModel()
                .partialState().with(BlueberryBushBlock.AGE, 3)
                .modelForState().modelFile(stage3).addModel();
        // item model
        itemModels().withExistingParent(itemPath, new ResourceLocation("item/generated")).texture("layer0", itemTexture);
    }

    protected void leavesModBlock(Block leaves, ResourceLocation texture) {
        String path = leaves.getRegistryName().getPath();
        simpleBlock(leaves, models().withExistingParent(path, mcLoc("block/leaves")).texture("all", texture));
        itemModels().withExistingParent(path, new ResourceLocation(leaves.getRegistryName().getNamespace(), "block/" + path));
    }
}
