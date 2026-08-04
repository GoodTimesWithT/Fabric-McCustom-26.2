package mc.custom.datagen;

import mc.custom.block.ModBlocks;
import mc.custom.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {

    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.DEEPSTEEL_BLOCK);
        dropSelf(ModBlocks.CUT_DEEPSTEEL_BLOCK);
        dropSelf(ModBlocks.CUT_DEEPSTEEL_STAIRS);
        dropSelf(ModBlocks.DEEPSTEEL_GRATE);
        dropSelf(ModBlocks.DEEPSTEEL_TRAPDOOR);
        dropSelf(ModBlocks.CUT_DEEPSTEEL_WALL);
        dropSelf(ModBlocks.DEEPSTEEL_BARS);

        add(ModBlocks.CUT_DEEPSTEEL_SLAB, this::createSlabItemTable);

        add(ModBlocks.DEEPSTEEL_DOOR, this::createDoorTable);

        add(ModBlocks.DEEPSCRAP, createMultipleOreDrops(ModBlocks.DEEPSCRAP, ModItems.DEEPSTEEL, 2, 5));
    }

        public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
            HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

            return this.createSilkTouchDispatchTable(
                    block, this.applyExplosionDecay(
                            block, LootItem.lootTableItem(item)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                    .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                    )
            );
        }
    }
