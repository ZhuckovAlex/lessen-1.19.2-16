package net.sanberdir.lessen192.world.features;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.lessen192.Lessen192;
import net.sanberdir.lessen192.init.block.InitBlocksL192;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Lessen192.MOD_ID);

    public static final RegistryObject<PlacedFeature> CUSTOM_CHECKED = PLACED_FEATURES.register("custom_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.CUSTOM_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(InitBlocksL192.CUSTOM_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> CUSTOM_PLACED = PLACED_FEATURES.register("custom_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CUSTOM_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));


    public static final RegistryObject<PlacedFeature> ZIRCON_ORE_PLACED = PLACED_FEATURES.register("zircon_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ZIRCON_ORE.getHolder().get(),
                    commonOrePlacement(15, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)))));

    public static final RegistryObject<PlacedFeature> END_ZIRCON_ORE_PLACED = PLACED_FEATURES.register("end_zircon_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.END_ZIRCON_ORE.getHolder().get(), commonOrePlacement(15, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_ZIRCON_ORE_PLACED = PLACED_FEATURES.register("nether_zircon_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_ZIRCON_ORE.getHolder().get(), commonOrePlacement(15, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
