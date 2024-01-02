package net.sanberdir.lessen192.init.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.lessen192.Lessen192;
import net.sanberdir.lessen192.init.ModCreativeModeTab;
import net.sanberdir.lessen192.init.block.custom.BurningBlock;
import net.sanberdir.lessen192.init.block.custom.BurningLeaves;
import net.sanberdir.lessen192.init.block.custom.Chlopok;
import net.sanberdir.lessen192.init.block.custom.FlameBlockRotate;
import net.sanberdir.lessen192.init.fluid.ModFluids;
import net.sanberdir.lessen192.init.item.InitItemsL192;
import net.sanberdir.lessen192.init.trees.CustomTree;

import java.util.function.Supplier;

public class InitBlocksL192 {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Lessen192.MOD_ID);

    public static final RegistryObject<Block> BLOCK_LESSEN = registerBlock("block_lessen",
            () -> new Block(BlockBehaviour.Properties.of(Material.BAMBOO)
                    .strength(1, 1).sound(SoundType.BAMBOO)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CUSTOM_PLANKS = registerBlock("custom_planks",
            () -> new BurningBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f, 15).sound(SoundType.WOOD)), ModCreativeModeTab.ITEMS_LESSEN);
    public static final RegistryObject<Block> CUSTOM_SAPLING = registerBlockWithoutBlockItem("custom_sapling",
            () -> new SaplingBlock(new CustomTree(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CHLOPOK = registerBlockWithoutBlockItem("chlopok",
            () -> new Chlopok(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> CUSTOM_LEAVES = registerBlockWithoutBlockItem("custom_leaves",
            () -> new BurningLeaves(BlockBehaviour.Properties.of(Material.PLANT)
                    .strength(0.1f, 2).sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> CUSTOM_LOG = registerBlock("custom_log",
            () -> new FlameBlockRotate(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.ITEMS_LESSEN);
    public static final RegistryObject<Block> CUSTOM_WOOD = registerBlock("custom_wood",
            () -> new FlameBlockRotate(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.ITEMS_LESSEN);

    public static final RegistryObject<Block> STRIPPED_CUSTOM_LOG = registerBlock("stripped_custom_log",
            () -> new FlameBlockRotate(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.ITEMS_LESSEN);
    public static final RegistryObject<Block> STRIPPED_CUSTOM_WOOD = registerBlock("stripped_custom_wood",
            () -> new FlameBlockRotate(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.ITEMS_LESSEN);


    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops(),
                    UniformInt.of(15, 30)), ModCreativeModeTab.ITEMS_LESSEN);
    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.BASALT)
                    .strength(4f).requiresCorrectToolForDrops(),
                    UniformInt.of(30, 60)), ModCreativeModeTab.ITEMS_LESSEN);
    public static final RegistryObject<Block> ENDSTONE_ZIRCON_ORE = registerBlock("endstone_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(60, 120)), ModCreativeModeTab.ITEMS_LESSEN);
    public static final RegistryObject<Block> NETHERRACK_ZIRCON_ORE = registerBlock("netherrack_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.NETHERRACK)
                    .strength(1f).requiresCorrectToolForDrops(),
                    UniformInt.of(20, 40)), ModCreativeModeTab.ITEMS_LESSEN);
    public static final RegistryObject<LiquidBlock> SOAP_WATER_BLOCK = BLOCKS.register("soap_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_SOAP_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return InitItemsL192.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
