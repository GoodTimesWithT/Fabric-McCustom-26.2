package mc.custom.datagen;

import mc.custom.block.ModBlocks;
import mc.custom.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.DEEPSTEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSTEEL_BLOCK);

                shapeless(RecipeCategory.MISC, ModItems.DEEPSTEEL_INGOT)
                        .requires(ModItems.DEEPSTEEL, 4)
                        .requires(Items.COPPER_INGOT, 4)
                        .unlockedBy(getHasName(ModItems.DEEPSTEEL_INGOT), has(ModItems.DEEPSTEEL))
                        .group("Deepsteel")
                        .save(output, "deepsteel_ingot_craft");

                cut(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_DEEPSTEEL_BLOCK, ModBlocks.DEEPSTEEL_BLOCK);

                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_DEEPSTEEL_WALL, ModBlocks.CUT_DEEPSTEEL_BLOCK);

                stairBuilder(ModBlocks.CUT_DEEPSTEEL_STAIRS, Ingredient.of(ModBlocks.CUT_DEEPSTEEL_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.CUT_DEEPSTEEL_BLOCK), has(ModBlocks.CUT_DEEPSTEEL_BLOCK))
                        .group("Deepsteel")
                        .save(output, "deepsteel_stair_craft");

                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_DEEPSTEEL_SLAB, ModBlocks.CUT_DEEPSTEEL_BLOCK);

                grate(ModBlocks.DEEPSTEEL_GRATE, ModBlocks.CUT_DEEPSTEEL_BLOCK);

                doorBuilder(ModBlocks.DEEPSTEEL_DOOR, Ingredient.of(ModItems.DEEPSTEEL_INGOT))
                        .unlockedBy(getHasName(ModItems.DEEPSTEEL_INGOT), has(ModItems.DEEPSTEEL_INGOT))
                        .group("Deepsteel")
                        .save(output, "deepsteel_door_craft");

                trapdoorBuilder(ModBlocks.DEEPSTEEL_TRAPDOOR, Ingredient.of(ModItems.DEEPSTEEL_INGOT))
                        .unlockedBy(getHasName(ModItems.DEEPSTEEL_INGOT), has(ModItems.DEEPSTEEL_INGOT))
                        .group("Deepsteel")
                        .save(output, "deepsteel_trapdoor_craft");

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSTEEL_BARS)
                        .pattern("DDD")
                        .pattern("DDD")
                        .define('D', ModItems.DEEPSTEEL_INGOT)
                        .unlockedBy(getHasName(ModItems.DEEPSTEEL_INGOT), has(ModItems.DEEPSTEEL_INGOT))
                        .group("Deepsteel")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.DEEPSTEEL_HELMET)
                        .pattern("dDd")
                        .pattern("DgD")
                        .pattern("dDd")
                        .define('D', ModItems.DEEPSTEEL_INGOT)
                        .define('d', ModItems.DEEPSTEEL)
                        .define('g', Items.GLASS_PANE)
                        .unlockedBy(getHasName(ModItems.DEEPSTEEL_INGOT), has(ModItems.DEEPSTEEL_INGOT))
                        .group("Deepsteel")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.DEEPSTEEL_CHESTPLATE)
                        .pattern("d d")
                        .pattern("DDD")
                        .pattern("dDd")
                        .define('D', ModItems.DEEPSTEEL_INGOT)
                        .define('d', ModItems.DEEPSTEEL)
                        .unlockedBy(getHasName(ModItems.DEEPSTEEL_INGOT), has(ModItems.DEEPSTEEL_INGOT))
                        .group("Deepsteel")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.DEEPSTEEL_LEGGINGS)
                        .pattern("DDD")
                        .pattern("D D")
                        .pattern("d d")
                        .define('D', ModItems.DEEPSTEEL_INGOT)
                        .define('d', ModItems.DEEPSTEEL)
                        .unlockedBy(getHasName(ModItems.DEEPSTEEL_INGOT), has(ModItems.DEEPSTEEL_INGOT))
                        .group("Deepsteel")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.DEEPSTEEL_BOOTS)
                        .pattern("d d")
                        .pattern("D D")
                        .define('D', ModItems.DEEPSTEEL_INGOT)
                        .define('d', ModItems.DEEPSTEEL)
                        .unlockedBy(getHasName(ModItems.DEEPSTEEL_INGOT), has(ModItems.DEEPSTEEL_INGOT))
                        .group("Deepsteel")
                        .save(output);

            }
        };
    }

    @Override
    public String getName() {
        return "McCustom Recipes";
    }
}
