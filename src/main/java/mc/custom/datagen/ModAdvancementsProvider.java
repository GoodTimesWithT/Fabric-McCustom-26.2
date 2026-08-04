package mc.custom.datagen;

import mc.custom.McCustom;
import mc.custom.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends AdvancementProvider {
    public ModAdvancementsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new McCustomAdvancements()));
    }
    public static class McCustomAdvancements implements AdvancementSubProvider {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> output) {
            var items = registries.lookupOrThrow(Registries.ITEM);
            var blocks = registries.lookupOrThrow(Registries.BLOCK);

            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            ModItems.DEEPSTEEL,
                            Component.translatable("advancements.mccustom.root.title"),
                            Component.translatable("advancements.mccustom.root.description"),
                            Identifier.withDefaultNamespace("gui/advancments/background/adventure"),
                            AdvancementType.GOAL,
                            false,
                            false,
                            false
                    )
                    .addCriterion("has_deepsteel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.DEEPSTEEL)))
                    .save(output, McCustom.MOD_ID + "mccustom/root");

            AdvancementHolder getDeepsteel = Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            ModItems.DEEPSTEEL_INGOT,
                            Component.translatable("advancements.mccustom.deepsteel.title"),
                            Component.translatable("advancements.mccustom.deepsteel.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("has_deepsteel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.DEEPSTEEL_INGOT)))
                    .save(output, McCustom.MOD_ID + "mccustom/deepsteel");

            AdvancementHolder getDeepsteelArmor = Advancement.Builder.advancement()
                    .parent(getDeepsteel)
                    .display(
                            ModItems.DEEPSTEEL_HELMET,
                            Component.translatable("advancements.mccustom.deepsteel_armor.title"),
                            Component.translatable("advancements.mccustom.deepsteel_armor.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .addCriterion("has_deepsteel_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.DEEPSTEEL_HELMET)))
                    .addCriterion("has_deepsteel_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.DEEPSTEEL_CHESTPLATE)))
                    .addCriterion("has_deepsteel_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.DEEPSTEEL_LEGGINGS)))
                    .addCriterion("has_deepsteel_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.DEEPSTEEL_BOOTS)))
                    .save(output, McCustom.MOD_ID + "mccustom/deepsteel_armor");

        }
    }
}
