package simplicity.simplicity.core.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import simplicity.simplicity.Simplicity;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Simplicity.MOD_ID);

    public static final RegistryObject<Item> EBONY_LOG = ITEMS.register("ebony_log", () -> new BlockItem(BlockInit.EBONY_LOG.get(),new Item.Properties().tab(Simplicity.SIMPLICITY)));


}
