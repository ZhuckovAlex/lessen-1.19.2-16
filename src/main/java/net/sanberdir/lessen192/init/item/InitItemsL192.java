package net.sanberdir.lessen192.init.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.lessen192.Lessen192;
import net.sanberdir.lessen192.init.ModCreativeModeTab;
import net.sanberdir.lessen192.init.block.InitBlocksL192;
import net.sanberdir.lessen192.init.fluid.ModFluids;
import net.sanberdir.lessen192.init.item.custom.FueLeaves;
import net.sanberdir.lessen192.init.item.custom.FuelBox;

public class InitItemsL192 {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Lessen192.MOD_ID);

    public static final RegistryObject<Item> BOX = ITEMS.register("box",
            () -> new FuelBox(new Item.Properties().tab(ModCreativeModeTab.ITEMS_LESSEN)));
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEMS_LESSEN)));
    public static final RegistryObject<Item> SOAP_WATER_BUCKET = ITEMS.register("soap_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SOAP_WATER,
                    new Item.Properties().tab(ModCreativeModeTab.ITEMS_LESSEN).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> CUSTOM_SAPLING = ITEMS.register("custom_sapling",
            () -> new ItemNameBlockItem(InitBlocksL192.CUSTOM_SAPLING.get(),(new Item.Properties().tab(ModCreativeModeTab.ITEMS_LESSEN))));
    public static final RegistryObject<Item> CHLOPOK = ITEMS.register("chlopok",
            () -> new ItemNameBlockItem(InitBlocksL192.CHLOPOK.get(),(new Item.Properties().tab(ModCreativeModeTab.ITEMS_LESSEN))));
    public static final RegistryObject<Item> CUSTOM_LEAVES = ITEMS.register("custom_leaves",
            () -> new FueLeaves(InitBlocksL192.CUSTOM_LEAVES.get(),(new Item.Properties().tab(ModCreativeModeTab.ITEMS_LESSEN))));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
