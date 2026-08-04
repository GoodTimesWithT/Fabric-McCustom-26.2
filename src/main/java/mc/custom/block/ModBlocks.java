package mc.custom.block;

import mc.custom.McCustom;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.function.Function;

public class ModBlocks {
    public static final Block DEEPSTEEL_BLOCK = registerBlock("deepsteel_block",
            properties -> new Block(properties.strength(4.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final Block DEEPSCRAP = registerBlock("deepscrap",
            properties -> new Block(properties.strength(4.5F)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final Block CUT_DEEPSTEEL_BLOCK = registerBlock("cut_deepsteel_block",
            properties -> new Block(properties.strength(4.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final Block CUT_DEEPSTEEL_STAIRS = registerBlock("cut_deepsteel_stairs",
            properties -> new StairBlock(ModBlocks.CUT_DEEPSTEEL_BLOCK.defaultBlockState(),
                    properties.strength(4.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final Block CUT_DEEPSTEEL_SLAB = registerBlock("cut_deepsteel_slab",
            properties -> new SlabBlock(properties.strength(4.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final Block DEEPSTEEL_GRATE = registerBlock("deepsteel_grate",
            properties -> new TransparentBlock(properties.strength(4.0F).noOcclusion()
                            .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final Block DEEPSTEEL_DOOR = registerBlock("deepsteel_door",
            properties -> new DoorBlock(BlockSetType.COPPER, properties.strength(4.0F).noOcclusion()
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final Block DEEPSTEEL_TRAPDOOR = registerBlock("deepsteel_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.COPPER, properties.strength(4.0F).noOcclusion()
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final Block CUT_DEEPSTEEL_WALL = registerBlock("cut_deepsteel_wall",
            properties -> new WallBlock(properties.strength(4.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final Block DEEPSTEEL_BARS = registerBlock("deepsteel_bars",
            properties -> new IronBarsBlock(properties.strength(4.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toregister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, name))));
        registerBlockItem(name, toregister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, name), toregister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, name),
            new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, name)))));
    }

    public static void regiosterModBlocks() {
        McCustom.LOGGER.info("Registering Mod Blocks for" + McCustom.MOD_ID);
    }

    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }
}
