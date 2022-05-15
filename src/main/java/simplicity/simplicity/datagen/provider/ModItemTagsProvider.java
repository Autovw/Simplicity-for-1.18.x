package simplicity.simplicity.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import simplicity.simplicity.core.init.ItemInit;
import simplicity.simplicity.core.init.ModTags;

/**
 * Author: Autovw
 */
public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, modId, existingFileHelper);
    }

    /**
     * Add item tags here
     */
    @Override
    protected void addTags() {
        tag(ItemTags.SMALL_FLOWERS)
                .add(ItemInit.RED_CORNFLOWER.get());

        tag(ItemTags.PLANKS)
                .add(ItemInit.EBONY_PLANKS.get());

        tag(ItemTags.LOGS)
                .add(ItemInit.STRIPPED_EBONY_LOG.get())
                .add(ItemInit.EBONY_LOG.get());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ItemInit.STRIPPED_EBONY_LOG.get())
                .add(ItemInit.EBONY_LOG.get());

        tag(ModTags.EBONY_LOGS)
                .add(ItemInit.EBONY_WOOD.get())
                .add(ItemInit.STRIPPED_EBONY_WOOD.get())
                .add(ItemInit.EBONY_LOG.get())
                .add(ItemInit.STRIPPED_EBONY_LOG.get());

        tag(ModTags.BERRIES)
                .add(Items.SWEET_BERRIES)
                .add(ItemInit.BLUEBERRIES.get());

        tag(ItemTags.LEAVES)
                .add(ItemInit.EBONY_LEAVES.get());
    }
}
