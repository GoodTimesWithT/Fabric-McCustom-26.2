package mc.custom.world.biome;

import mc.custom.McCustom;
import mc.custom.world.biome.surface.ModMaterialRules;
import net.minecraft.resources.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.fromNamespaceAndPath(McCustom.MOD_ID, "overworld"),5));

        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, McCustom.MOD_ID, ModMaterialRules.makeRules());
    }
}
