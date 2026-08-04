package mc.custom.datagen;

import mc.custom.block.ModBlocks;
import mc.custom.item.ModArmorMaterials;
import mc.custom.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSTEEL_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSCRAP);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSTEEL_GRATE);

        blockModelGenerators.createBarsAndItem(ModBlocks.DEEPSTEEL_BARS);

        blockModelGenerators.createDoor(ModBlocks.DEEPSTEEL_DOOR);

        blockModelGenerators.createTrapdoor(ModBlocks.DEEPSTEEL_TRAPDOOR);

        blockModelGenerators.family(ModBlocks.CUT_DEEPSTEEL_BLOCK)
                .stairs(ModBlocks.CUT_DEEPSTEEL_STAIRS)
                .slab(ModBlocks.CUT_DEEPSTEEL_SLAB)
                .wall(ModBlocks.CUT_DEEPSTEEL_WALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.DEEPSTEEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DEEPSTEEL_INGOT, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateTrimmableItem(ModItems.DEEPSTEEL_HELMET, ModArmorMaterials.DEEPSTEEL_KEY,
                ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.DEEPSTEEL_CHESTPLATE, ModArmorMaterials.DEEPSTEEL_KEY,
                ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.DEEPSTEEL_LEGGINGS, ModArmorMaterials.DEEPSTEEL_KEY,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.DEEPSTEEL_BOOTS, ModArmorMaterials.DEEPSTEEL_KEY,
                ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        itemModelGenerators.declareCustomModelItem(ModItems.ANCHOR);
    }
}
