package mc.custom.tags;

import mc.custom.McCustom;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_DEEPSTEEL_TOOL = createTag("needs_deepsteel_tool");
        public static final TagKey<Block> INCORRECT_FOR_DEEPSTEEL_TOOL = createTag("inccorect_for_deepsteel_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DEEPSTEEL_REPAIR = createTag("deepsteel_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, name));
        }
    }
}
