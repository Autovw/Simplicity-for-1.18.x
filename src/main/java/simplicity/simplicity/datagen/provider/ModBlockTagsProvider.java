package simplicity.simplicity.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import simplicity.simplicity.core.init.BlockInit;

/**
 * Author: Autovw
 */
public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    /**
     * Add block tags here
     */
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BlockInit.EBONY_LOG.get())
                .add(BlockInit.STRIPPED_EBONY_LOG.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.RUBY_ORE.get())
                .add(BlockInit.BLUE_NETHER_BRICKS.get())
                .add(BlockInit.DEEPSLATE_RUBY_ORE.get())
                .add(BlockInit.RUBY_BLOCK.get());

        tag(BlockTags.SMALL_FLOWERS)
                .add(BlockInit.RED_CORNFLOWER.get());

        tag(BlockTags.REPLACEABLE_PLANTS)
                .add(BlockInit.BLUEBERRY_BUSH.get());
    }
}
