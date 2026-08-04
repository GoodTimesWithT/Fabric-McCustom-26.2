package mc.custom.datagen;

import mc.custom.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider .ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }



    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(ItemTags.HEAD_ARMOR).add(ModItems.getRK(ModItems.DEEPSTEEL_HELMET));
        tag(ItemTags.CHEST_ARMOR).add(ModItems.getRK(ModItems.DEEPSTEEL_CHESTPLATE));
        tag(ItemTags.LEG_ARMOR).add(ModItems.getRK(ModItems.DEEPSTEEL_LEGGINGS));
        tag(ItemTags.FOOT_ARMOR).add(ModItems.getRK(ModItems.DEEPSTEEL_BOOTS));
        tag(ItemTags.TRIDENT_ENCHANTABLE).add(ModItems.getRK(ModItems.ANCHOR));
    }
}
