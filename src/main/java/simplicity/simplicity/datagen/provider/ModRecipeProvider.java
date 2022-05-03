package simplicity.simplicity.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.core.init.ItemInit;

import java.util.function.Consumer;

/**
 * Author: Autovw
 */
public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    /**
     * Add new recipes below
     * @param consumer      Recipe consumer
     */
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        rubyBlockRecipes(consumer);
        blueNetherBricksRecipes(consumer);
    }

    /**
     * Recipes for creating a Ruby Block, and converting back to items
     * @param consumer      Recipe consumer
     */
    private void rubyBlockRecipes(Consumer<FinishedRecipe> consumer) {
        // Ruby item to Ruby Block
        ShapedRecipeBuilder.shaped(ItemInit.RUBY_BLOCK.get(), 1)
                .define('#', ItemInit.RUBY.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_ruby", has(ItemInit.RUBY.get()))
                .save(consumer);

        // Ruby Block to Ruby item
        ShapelessRecipeBuilder.shapeless(ItemInit.RUBY.get(), 9)
                .requires(ItemInit.RUBY_BLOCK.get())
                .unlockedBy("has_ruby_block", has(ItemInit.RUBY_BLOCK.get()))
                .save(consumer, new ResourceLocation(Simplicity.MOD_ID, "ruby_from_block"));
    }

    private void blueNetherBricksRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ItemInit.BLUE_NETHER_BRICKS.get(), 1)
                .define('W', Items.WARPED_WART_BLOCK)
                .define('N', Items.NETHER_BRICKS)
                .pattern("NW")
                .pattern("WN")
                .unlockedBy("has_warped_wart_block", has(Items.WARPED_WART_BLOCK))
                .unlockedBy("has_nether_bricks", has(Items.NETHER_BRICKS))
                .save(consumer);
    }
}
