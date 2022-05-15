package simplicity.simplicity;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import simplicity.simplicity.core.init.BlockInit;
import simplicity.simplicity.core.init.ItemInit;

@Mod(Simplicity.MOD_ID)
public class Simplicity {
    public static final String MOD_ID = "simplicity";

    public static final CreativeModeTab SIMPLICITY = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.EBONY_LOG.get());
        }
    };

    public Simplicity() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(eventBus);
        BlockInit.BLOCKS.register(eventBus);

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.RED_CORNFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLUEBERRY_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.POTTED_RED_CORNFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.EBONY_SAPLING.get(), RenderType.cutout());
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockInit.RED_CORNFLOWER.getId(), BlockInit.POTTED_RED_CORNFLOWER);
    });

}
}

