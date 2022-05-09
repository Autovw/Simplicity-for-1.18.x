package simplicity.simplicity.core.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import simplicity.simplicity.Simplicity;

public class ModTags {

    public static final TagKey<Item> EBONY_LOGS = itemTag("ebony_logs");



    private static TagKey<Item> itemTag(String tagName) {
        return ItemTags.create(new ResourceLocation(Simplicity.MOD_ID, tagName));
    }


}
