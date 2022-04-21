package simplicity.simplicity.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.datagen.provider.*;

@Mod.EventBusSubscriber(modid = Simplicity.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {

    @SubscribeEvent
    public static void onGatherData(final GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(dataGenerator, Simplicity.MOD_ID, existingFileHelper);

        if (event.includeServer()) {
            dataGenerator.addProvider(blockTagsProvider);
            dataGenerator.addProvider(new ModItemTagsProvider(dataGenerator, blockTagsProvider, Simplicity.MOD_ID, existingFileHelper));
            dataGenerator.addProvider(new ModLootTableProvider(dataGenerator));
        }

        if (event.includeClient()) {
            dataGenerator.addProvider(new ModItemModelProvider(dataGenerator, Simplicity.MOD_ID, existingFileHelper));
            dataGenerator.addProvider(new ModBlockStateProvider(dataGenerator, Simplicity.MOD_ID, existingFileHelper));
        }
    }
}
