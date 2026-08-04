package mc.custom.world.biome;

import mc.custom.McCustom;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;


public class ModBiomes {

    public static final ResourceKey<Biome> WARM_OCEAN_DEPTHS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, "warm_ocean_depths"));

        public static void registerBiomes() {
            McCustom.LOGGER.info("Registering mod biomes for" + McCustom.MOD_ID);
        }
    }
