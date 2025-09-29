package com.diesouto.gorrocopteromod.item;

import com.diesouto.gorrocopteromod.GorrocopteroMod;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GorrocopteroMod.MODID);

    public static final RegistryObject<Item> HELIX = ITEMS.register("helix",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GORROCOPTERO = ITEMS.register("gorrocoptero",
            () -> new Gorrocoptero(ModArmorMaterials.GORROCOPTERO_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
