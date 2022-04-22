package simplicity.simplicity.datagen.provider;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;
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
            this.dropSelf(BlockInit.STRIPPED_EBONY_LOG.get());
            this.add(BlockInit.RUBY_ORE.get(), (builder) -> createOreDrop(builder, ItemInit.RUBY.get()));
            this.add(BlockInit.DEEPSLATE_RUBY_ORE.get(), (builder) -> createOreDrop(builder, ItemInit.RUBY.get()));
            this.dropSelf(BlockInit.RUBY_BLOCK.get());
            this.dropSelf(BlockInit.RED_CORNFLOWER.get());
            this.dropSelf(BlockInit.BLUEBERRY_BUSH.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return BlockInit.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        }
    }
}
