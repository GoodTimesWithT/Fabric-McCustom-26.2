package mc.custom;

import mc.custom.datagen.*;
import mc.custom.world.biome.ModBiomes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class McCustomDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.BIOME, ModBiomes::bootstrap);
	}

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModEquipmentAssetProvider::new);
		pack.addProvider(ModAdvancementsProvider::new);
		pack.addProvider(ModDynamicRegistryProvider::new);
	}

}
