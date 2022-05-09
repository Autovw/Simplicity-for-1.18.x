package simplicity.simplicity.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.core.init.ItemInit;

/**
 * Author: Autovw
 */
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        modItemModel(ItemInit.RUBY.get(), new ResourceLocation(Simplicity.MOD_ID, "item/ruby"));
        modItemModel(ItemInit.BLUEBERRIES.get(), new ResourceLocation(Simplicity.MOD_ID, "item/blueberries"));
        modItemModel(ItemInit.GOLDEN_BERRIES.get(), new ResourceLocation(Simplicity.MOD_ID, "item/golden_berries"));
    }

    /**
     * Used for generating a simple item model.
     * @param item              The item you want to generate a model for
     * @param textureLocation   The location of the item texture
     */
    protected void modItemModel(Item item, ResourceLocation textureLocation) {
        singleTexture(item.toString(), new ResourceLocation("item/generated"), "layer0", textureLocation);
    }
}
