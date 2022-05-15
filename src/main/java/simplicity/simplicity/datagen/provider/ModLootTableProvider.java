package simplicity.simplicity.datagen.provider;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import simplicity.simplicity.common.properties.blocks.BlueberryBushBlock;
import simplicity.simplicity.core.init.BlockInit;
import simplicity.simplicity.core.init.ItemInit;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Author: Autovw
 */
public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(Pair.of(ModBlockLoot::new, LootContextParamSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
    }

    private static class ModBlockLoot extends BlockLoot {

        /**
         * Important note: the loot table provider will crash if it is missing blocks registered with {@link BlockInit#BLOCKS}
         */
        @Override
        protected void addTables() {
            this.dropSelf(BlockInit.EBONY_LOG.get());
            this.dropSelf(BlockInit.EBONY_PLANKS.get());
            this.dropSelf(BlockInit.STRIPPED_EBONY_LOG.get());
            this.dropSelf(BlockInit.STRIPPED_EBONY_WOOD.get());
            this.dropSelf(BlockInit.EBONY_WOOD.get());
            this.add(BlockInit.RUBY_ORE.get(), (builder) -> createOreDrop(builder, ItemInit.RUBY.get()));
            this.add(BlockInit.DEEPSLATE_RUBY_ORE.get(), (builder) -> createOreDrop(builder, ItemInit.RUBY.get()));
            this.dropSelf(BlockInit.RUBY_BLOCK.get());
            this.dropSelf(BlockInit.BLUE_NETHER_BRICKS.get());
            this.dropSelf(BlockInit.RED_CORNFLOWER.get());
            this.add(BlockInit.BLUEBERRY_BUSH.get(), (builder) -> {
                return applyExplosionDecay(builder, LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockInit.BLUEBERRY_BUSH.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlueberryBushBlock.AGE, 3)))
                                .add(LootItem.lootTableItem(ItemInit.BLUEBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 3.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockInit.BLUEBERRY_BUSH.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlueberryBushBlock.AGE, 2)))
                                .add(LootItem.lootTableItem(ItemInit.BLUEBERRIES.get())))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)));
            });

            this.dropSelf(BlockInit.EBONY_LEAVES.get());
            // TODO uncomment when sapling exist, remove above
            //this.add(BlockInit.EBONY_LEAVES.get(), (builder) -> createLeavesDrops(builder, ItemInit.EBONY_SAPLING, new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F}));
        }

        @Override
        protected Iterable<Block> getKnownBlocks () {
            return BlockInit.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        }
    }
}

