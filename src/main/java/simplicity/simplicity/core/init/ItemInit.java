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
    public static final RegistryObject<Item> STRIPPED_EBONY_LOG = ITEMS.register("stripped_ebony_log", () -> new BlockItem(BlockInit.STRIPPED_EBONY_LOG.get(), new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> RUBY_ORE = ITEMS.register("ruby_ore", () -> new BlockItem(BlockInit.RUBY_ORE.get(),new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> DEEPSLATE_RUBY_ORE = ITEMS.register("deepslate_ruby_ore", () -> new BlockItem(BlockInit.DEEPSLATE_RUBY_ORE.get(),new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> RED_CORNFLOWER = ITEMS.register("red_cornflower", () -> new BlockItem(BlockInit.RED_CORNFLOWER.get(),new Item.Properties().tab(Simplicity.SIMPLICITY)));




}
