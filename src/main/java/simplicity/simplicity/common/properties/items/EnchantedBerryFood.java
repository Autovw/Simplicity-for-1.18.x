package simplicity.simplicity.common.properties.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class EnchantedBerryFood extends Item {
    public EnchantedBerryFood(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack itemStack) { return true;}
}
