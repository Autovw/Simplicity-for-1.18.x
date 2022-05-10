package simplicity.simplicity.core.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import simplicity.simplicity.Simplicity;
import simplicity.simplicity.common.properties.items.EnchantedBerryFood;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Simplicity.MOD_ID);

    public static final RegistryObject<Item> EBONY_LOG = ITEMS.register("ebony_log", () -> new BlockItem(BlockInit.EBONY_LOG.get(),new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> STRIPPED_EBONY_LOG = ITEMS.register("stripped_ebony_log", () -> new BlockItem(BlockInit.STRIPPED_EBONY_LOG.get(), new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> STRIPPED_EBONY_WOOD = ITEMS.register("stripped_ebony_wood", () -> new BlockItem(BlockInit.STRIPPED_EBONY_WOOD.get(), new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> EBONY_WOOD = ITEMS.register("ebony_wood", () -> new BlockItem(BlockInit.EBONY_WOOD.get(), new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> EBONY_PLANKS = ITEMS.register("ebony_planks", () -> new BlockItem(BlockInit.EBONY_PLANKS.get(), new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> RUBY_ORE = ITEMS.register("ruby_ore", () -> new BlockItem(BlockInit.RUBY_ORE.get(),new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> DEEPSLATE_RUBY_ORE = ITEMS.register("deepslate_ruby_ore", () -> new BlockItem(BlockInit.DEEPSLATE_RUBY_ORE.get(),new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> RUBY_BLOCK = ITEMS.register("ruby_block", () -> new BlockItem(BlockInit.RUBY_BLOCK.get(), new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> RED_CORNFLOWER = ITEMS.register("red_cornflower", () -> new BlockItem(BlockInit.RED_CORNFLOWER.get(),new Item.Properties().tab(Simplicity.SIMPLICITY)));
    public static final RegistryObject<Item> BLUEBERRIES = ITEMS.register("blueberries", () -> new BlockItem(BlockInit.BLUEBERRY_BUSH.get(),new Item.Properties().tab(Simplicity.SIMPLICITY).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
    public static final RegistryObject<Item> GOLDEN_BERRIES = ITEMS.register("golden_berries", () -> new Item(new Item.Properties().tab(Simplicity.SIMPLICITY).food(new FoodProperties.Builder().nutrition(4).saturationMod(1.0f).effect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 0), 1.0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).build())));
    public static final RegistryObject<Item> ENCHANTED_GOLDEN_BERRIES = ITEMS.register("enchanted_golden_berries", () -> new EnchantedBerryFood(new Item.Properties().tab(Simplicity.SIMPLICITY).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.1f).effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 0), 1.0F).build())));
    public static final RegistryObject<Item> BLUE_NETHER_BRICKS = ITEMS.register("blue_nether_bricks", () -> new BlockItem(BlockInit.BLUE_NETHER_BRICKS.get(), new Item.Properties().tab(Simplicity.SIMPLICITY)));
}
