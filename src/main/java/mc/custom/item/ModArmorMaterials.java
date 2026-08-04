package mc.custom.item;

import mc.custom.McCustom;
import mc.custom.tags.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));
    public static  final  ResourceKey<EquipmentAsset> DEEPSTEEL_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(McCustom.MOD_ID, "deepsteel"));

    public static final ArmorMaterial DEEPSTEEL_ARMOR_MATERIAL = new ArmorMaterial(27,
            ArmorMaterials.makeDefense(3, 4, 7, 4, 7),
            9, SoundEvents.ARMOR_EQUIP_COPPER, 0.15F, 0.05F, ModTags.Items.DEEPSTEEL_REPAIR, DEEPSTEEL_KEY);
}
