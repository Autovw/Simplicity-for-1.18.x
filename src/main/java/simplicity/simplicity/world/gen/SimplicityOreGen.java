package simplicity.simplicity.world.gen;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import simplicity.simplicity.world.feature.SimplicityPlacedFeatures;

import java.util.List;

public class SimplicityOreGen {

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(SimplicityPlacedFeatures.RUBY_ORE_PLACED);
    }
}
