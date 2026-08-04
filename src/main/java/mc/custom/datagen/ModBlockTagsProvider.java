package mc.custom.datagen;

import mc.custom.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.DEEPSCRAP))
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_SLAB))
                .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_GRATE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_DOOR))
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_DOOR))
                .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_WALL))
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_BARS));

        tag(BlockTags.STAIRS)
                .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_STAIRS));

        tag(BlockTags.SLABS)
                .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_SLAB));

        tag(BlockTags.DOORS)
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_DOOR));

        tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_TRAPDOOR));

        tag(BlockTags.WALLS)
            .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_WALL));

        tag(BlockTags.BARS)
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_BARS));

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_SLAB))
                .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_GRATE))
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_DOOR))
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_TRAPDOOR))
                .add(ModBlocks.getRK(ModBlocks.CUT_DEEPSTEEL_WALL))
                .add(ModBlocks.getRK(ModBlocks.DEEPSTEEL_BARS));

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.getRK(ModBlocks.DEEPSCRAP));
    }
}
