package simplicity.simplicity.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import simplicity.simplicity.common.properties.blocks.BlueberryBushBlock;
import simplicity.simplicity.core.init.BlockInit;

import java.util.List;

public class SimplicityConfiguredFeatures {
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_RUBY_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.RUBY_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> RUBY_ORE = FeatureUtils.register("ruby_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_RUBY_ORES, 5));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BLUEBERRY_BUSH =
            FeatureUtils.register("patch_blueberry_bush", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.BLUEBERRY_BUSH.get().defaultBlockState().setValue(BlueberryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> EBONY_TREE =
            FeatureUtils.register("ebony", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(BlockInit.EBONY_LOG.get()),
                    new FancyTrunkPlacer(7, 9, 8),
                    BlockStateProvider.simple(BlockInit.EBONY_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> EBONY_CHECKED = PlacementUtils.register("ebony_checked", EBONY_TREE,
            PlacementUtils.filteredByBlockSurvival(BlockInit.EBONY_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> EBONY_SPAWN =
            FeatureUtils.register("ebony_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(EBONY_CHECKED,
                            0.5F)), EBONY_CHECKED));
}
