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
import simplicity.simplicity.core.init.ModTags;

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
        goldenBerriesRecipes(consumer);
        ebonyPlanksRecipes(consumer);
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
                .define('N', Items.NETHER_BRICK)
                .pattern("NW")
                .pattern("WN")
                .unlockedBy("has_warped_wart_block", has(Items.WARPED_WART_BLOCK))
                .unlockedBy("has_nether_bricks", has(Items.NETHER_BRICK))
                .save(consumer);
    }

    private void goldenBerriesRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ItemInit.GOLDEN_BERRIES.get(), 1)
                .define('B', Items.SWEET_BERRIES)
                .define('G', Items.GOLD_INGOT)
                .pattern("GGG")
                .pattern("GBG")
                .pattern("GGG")
                .unlockedBy("has_gold_ingot", has((Items.GOLD_INGOT)))
                .unlockedBy("has_sweer_berry", has(Items.SWEET_BERRIES))
                .save(consumer);


    }

    private void ebonyPlanksRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ItemInit.EBONY_PLANKS.get(), 4)
                .requires(ModTags.EBONY_LOGS)
                .unlockedBy("has_ebony_logs", has(ModTags.EBONY_LOGS))
                .save(consumer);

    }
}
