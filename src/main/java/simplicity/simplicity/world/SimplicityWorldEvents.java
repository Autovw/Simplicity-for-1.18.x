package simplicity.simplicity.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.world.gen.SimplicityBerryGen;
import simplicity.simplicity.world.gen.SimplicityOreGen;

@Mod.EventBusSubscriber(modid = Simplicity.MOD_ID)
public class SimplicityWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        SimplicityOreGen.generateOres(event);
        SimplicityBerryGen.generateBerries(event);
    }
}
