package mc.custom.world.biome;

import mc.custom.McCustom;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

import static net.minecraft.data.worldgen.biome.OverworldBiomes.globalOverworldGeneration;


public class ModBiomes {

    public static final ResourceKey<Biome> WARM_OCEAN_DEPTHS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, "warm_ocean_depths"));

        public static void registerBiomes() {
            McCustom.LOGGER.info("Registering mod biomes for" + McCustom.MOD_ID);
        }

    //....other things

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(WARM_OCEAN_DEPTHS, warmOceanDepths(context));
    }

    private static Biome warmOceanDepths (BootstrapContext<Biome> context){
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);


        return new Biome.BiomeBuilder().hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xaafeff)
                        .grassColorOverride(0xe6bdfb)
                        .foliageColorOverride(0xe6bdfb)
                        .build())
                .build();
    }

}
