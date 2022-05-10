package simplicity.simplicity.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import simplicity.simplicity.core.init.BlockInit;
import simplicity.simplicity.core.init.ItemInit;

/**
 * Author: Autovw
 */
public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(DataGenerator generator, String modid) {
        super(generator, modid, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        add(ItemInit.RUBY.get(), "Ruby");
        add(ItemInit.GOLDEN_BERRIES.get(), "Golden Berries");
        add(ItemInit.ENCHANTED_GOLDEN_BERRIES.get(), "Enchanted Golden Berries");

        // Blocks
        add(BlockInit.EBONY_LOG.get(), "Ebony Log");
        add(BlockInit.STRIPPED_EBONY_LOG.get(), "Stripped Ebony Log");
        add(BlockInit.EBONY_WOOD.get(), "Ebony Wood");
        add(BlockInit.STRIPPED_EBONY_WOOD.get(), "Stripped Ebony Wood");
        add(BlockInit.RUBY_ORE.get(), "Ruby Ore");
        add(BlockInit.DEEPSLATE_RUBY_ORE.get(), "Deepslate Ruby Ore");
        add(BlockInit.RUBY_BLOCK.get(), "Ruby Block");
        add(BlockInit.RED_CORNFLOWER.get(), "Red Cornflower");
        add(BlockInit.BLUEBERRY_BUSH.get(), "Blueberries");
        add(BlockInit.BLUE_NETHER_BRICKS.get(), "Blue Nether Bricks");
        add(BlockInit.EBONY_PLANKS.get(), "Ebony Planks");

        // Misc
        add("itemGroup.simplicity", "Simplicity");
    }
}
