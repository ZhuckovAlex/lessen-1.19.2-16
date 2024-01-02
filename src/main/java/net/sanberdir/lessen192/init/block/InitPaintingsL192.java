package net.sanberdir.lessen192.init.block;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.lessen192.Lessen192;

public class InitPaintingsL192 {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, Lessen192.MOD_ID);

    public static final RegistryObject<PaintingVariant> JASSIY = PAINTING_VARIANTS.register("jassiy",
            () -> new PaintingVariant(16, 16));
//    Вертикаль
    public static final RegistryObject<PaintingVariant> WARRIOR = PAINTING_VARIANTS.register("warrior",
            () -> new PaintingVariant(16, 32));
//    Горизонт
    public static final RegistryObject<PaintingVariant> SEA = PAINTING_VARIANTS.register("sea",
            () -> new PaintingVariant(32, 16));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}
