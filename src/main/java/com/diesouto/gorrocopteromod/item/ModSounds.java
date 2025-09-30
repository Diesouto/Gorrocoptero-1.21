package com.diesouto.gorrocopteromod.item;

import com.diesouto.gorrocopteromod.GorrocopteroMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GorrocopteroMod.MODID);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(GorrocopteroMod.MODID, name)));
    }

    public static final RegistryObject<SoundEvent> GORROCOPTERO_EQUIP = registerSoundEvent("gorrocoptero_equip");

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
