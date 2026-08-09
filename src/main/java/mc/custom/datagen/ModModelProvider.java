package mc.custom.datagen;

import mc.custom.block.ModBlocks;
import mc.custom.block.seprate_block_states.Deepsteel_Bulb;
import mc.custom.item.ModArmorMaterials;
import mc.custom.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.resources.Identifier;
import net.minecraft.util.random.WeightedList;

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

        Identifier bulbOnIdentifier =  blockModelGenerators.createSuffixedVariant
                (ModBlocks.DEEPSTEEL_BULB, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube);
        Identifier bulbOffIdentifier = TexturedModel.CUBE.create(ModBlocks.DEEPSTEEL_BULB, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(ModBlocks.DEEPSTEEL_BULB)
                        .with(BlockModelGenerators.createBooleanModelDispatch(Deepsteel_Bulb.POWERED,
                                new MultiVariant(WeightedList.<Variant>builder().add(new Variant(bulbOnIdentifier)).build()),
                                new MultiVariant(WeightedList.<Variant>builder().add(new Variant(bulbOffIdentifier)).build()))));

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
