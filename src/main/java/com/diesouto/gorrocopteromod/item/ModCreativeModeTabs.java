package com.diesouto.gorrocopteromod.item;

import com.diesouto.gorrocopteromod.GorrocopteroMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GorrocopteroMod.MODID);

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("alexanderite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GORROCOPTERO.get()))
                    .title(Component.translatable("creativetab.gorrocopteromod.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.HELIX.get());
                        output.accept(ModItems.GORROCOPTERO.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
