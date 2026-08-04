package mc.custom;

import mc.custom.block.ModBlocks;
import mc.custom.item.ModItems;
import mc.custom.world.biome.ModBiomes;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class McCustom implements ModInitializer {
	public static final String MOD_ID = "mccustom";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.regiosterModBlocks();
		ModBiomes.registerBiomes();

	}
	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
