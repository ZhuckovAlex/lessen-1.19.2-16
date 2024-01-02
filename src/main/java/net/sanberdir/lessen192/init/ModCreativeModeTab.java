package net.sanberdir.lessen192.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;


public class ModCreativeModeTab {
    public static final CreativeModeTab ITEMS_LESSEN = new CreativeModeTab("items_lessen") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.AZALEA);
        }
    };
}
