package simplicity.simplicity.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class SimplicityPlacedFeatures {
    public static final Holder<PlacedFeature> RUBY_ORE_PLACED = PlacementUtils.register("ruby_ore_placed",
            SimplicityConfiguredFeatures.RUBY_ORE, SimplicityOrePlacement.commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> PATCH_BLUEBERRY_COMMON = PlacementUtils.register("patch_blueberry_common", SimplicityConfiguredFeatures.PATCH_BLUEBERRY_BUSH, RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_BLUEBERRY_RARE = PlacementUtils.register("patch_blueberry_rare", SimplicityConfiguredFeatures.PATCH_BLUEBERRY_BUSH, RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> EBONY_PLACED = PlacementUtils.register("ebony_placed",
            SimplicityConfiguredFeatures.EBONY_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2)));
}

