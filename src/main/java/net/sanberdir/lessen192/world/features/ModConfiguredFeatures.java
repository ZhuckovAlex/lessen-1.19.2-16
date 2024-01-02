package net.sanberdir.lessen192.world.features;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.lessen192.Lessen192;
import net.sanberdir.lessen192.init.block.InitBlocksL192;


import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Lessen192.MOD_ID);
//Конрфигуратор кастомного дерева
    public static final RegistryObject<ConfiguredFeature<?, ?>> CUSTOM_TREE =
            CONFIGURED_FEATURES.register("custom_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, createBirch().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CUSTOM_SPAWN =
            CONFIGURED_FEATURES.register("custom_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.CUSTOM_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.CUSTOM_CHECKED.getHolder().get())));

    private static TreeConfiguration.TreeConfigurationBuilder createBirch() {
        return createStraightBlobTree(InitBlocksL192.CUSTOM_LOG.get(), InitBlocksL192.CUSTOM_LEAVES.get(),
                5, 2, 0, 2).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_),
                new StraightTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_),
                new BlobFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }
    //Конец конфигуратора кастомного дерева


    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitBlocksL192.ZIRCON_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, InitBlocksL192.DEEPSLATE_ZIRCON_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), InitBlocksL192.ENDSTONE_ZIRCON_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, InitBlocksL192.NETHERRACK_ZIRCON_ORE.get().defaultBlockState())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> ZIRCON_ORE = CONFIGURED_FEATURES.register("zircon_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_ZIRCON_ORES.get(),7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> END_ZIRCON_ORE = CONFIGURED_FEATURES.register("end_zircon_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_ZIRCON_ORES.get(), 9)));//Максимальный размер руды
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_ZIRCON_ORE = CONFIGURED_FEATURES.register("nether_zircon_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_ZIRCON_ORES.get(), 9)));



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
