package net.sanberdir.lessen192;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen192.init.block.InitBlocksL192;
import net.sanberdir.lessen192.init.block.InitPaintingsL192;
import net.sanberdir.lessen192.init.fluid.ModFluidTypes;
import net.sanberdir.lessen192.init.fluid.ModFluids;
import net.sanberdir.lessen192.init.item.InitItemsL192;
import net.sanberdir.lessen192.world.features.ModConfiguredFeatures;
import net.sanberdir.lessen192.world.features.ModPlacedFeatures;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Lessen192.MOD_ID)
public class Lessen192
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "lessen192";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public Lessen192()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Регистрация класса предметов
        InitItemsL192.register(modEventBus);
        InitBlocksL192.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        InitPaintingsL192.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                ComposterBlock.COMPOSTABLES.put(InitItemsL192.CUSTOM_SAPLING.get(), 0.2f);
                ComposterBlock.COMPOSTABLES.put(InitItemsL192.CHLOPOK.get(), 0.11f);
                ComposterBlock.COMPOSTABLES.put(InitItemsL192.CUSTOM_LEAVES.get(), 0.4f);
            });
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SOAP_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SOAP_WATER.get(), RenderType.translucent());
        }
    }
}
