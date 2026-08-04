package mc.custom.item;

import mc.custom.McCustom;
import mc.custom.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {
    public static final Item DEEPSTEEL = registerItem("deepsteel", Item::new);
    public static final Item DEEPSTEEL_INGOT = registerItem("deepsteel_ingot", Item::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, name)))));
    }

    public static final Item DEEPSTEEL_HELMET = registerItem("deepsteel_helmet",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.DEEPSTEEL_ARMOR_MATERIAL, ArmorType.HELMET)));

    public static final Item DEEPSTEEL_CHESTPLATE = registerItem("deepsteel_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.DEEPSTEEL_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));

    public static final Item DEEPSTEEL_LEGGINGS = registerItem("deepsteel_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.DEEPSTEEL_ARMOR_MATERIAL, ArmorType.LEGGINGS)));

    public static final Item DEEPSTEEL_BOOTS = registerItem("deepsteel_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.DEEPSTEEL_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final TridentItem ANCHOR = (TridentItem) registerItem("anchor",
    properties -> new TridentItem(properties.pickaxe(ModToolMaterials.DEEPSTEEL, 0f, -3.6f).rarity(Rarity.EPIC)) {

    });

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    public static void registerModItems() {
        McCustom.LOGGER.info("Registering Mod Items for" + McCustom.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(ModItems.DEEPSTEEL);
            output.accept(ModItems.DEEPSTEEL_INGOT);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> {
            output.accept((ModBlocks.DEEPSTEEL_BLOCK));
            output.accept((ModBlocks.CUT_DEEPSTEEL_BLOCK));
            output.accept((ModBlocks.CUT_DEEPSTEEL_STAIRS));
            output.accept((ModBlocks.CUT_DEEPSTEEL_SLAB));
            output.accept((ModBlocks.DEEPSTEEL_GRATE));
            output.accept((ModBlocks.DEEPSTEEL_DOOR));
            output.accept((ModBlocks.DEEPSTEEL_TRAPDOOR));
            output.accept((ModBlocks.CUT_DEEPSTEEL_WALL));
            output.accept((ModBlocks.DEEPSTEEL_BARS));
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(output -> {
            output.accept(ModBlocks.DEEPSCRAP);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept((ModItems.DEEPSTEEL_HELMET));
            output.accept((ModItems.DEEPSTEEL_CHESTPLATE));
            output.accept((ModItems.DEEPSTEEL_LEGGINGS));
            output.accept((ModItems.DEEPSTEEL_BOOTS));
            output.accept((ModItems.ANCHOR));

        });
    }
}
