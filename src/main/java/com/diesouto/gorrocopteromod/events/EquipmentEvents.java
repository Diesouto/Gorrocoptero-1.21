package com.diesouto.gorrocopteromod.events;

import com.diesouto.gorrocopteromod.item.Gorrocoptero;
import com.diesouto.gorrocopteromod.item.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "gorrocopteromod", value = Dist.CLIENT)
public class EquipmentEvents {
    private static SimpleSoundInstance activeSound;

    @SubscribeEvent
    public static void onEquipChange(LivingEquipmentChangeEvent event) {
        if (!(event.getEntity() instanceof net.minecraft.world.entity.player.Player player)) return;

        if (event.getSlot() == EquipmentSlot.HEAD) {
            // Equipped gorrocoptero helmet
            if (event.getTo().getItem() instanceof Gorrocoptero) {
                if (activeSound == null) {
                    activeSound = SimpleSoundInstance.forAmbientAddition(ModSounds.GORROCOPTERO_EQUIP.get());
                    Minecraft.getInstance().getSoundManager().play(activeSound);
                }
            }
            // Unequipped gorrocoptero helmet
            else if (event.getFrom().getItem() instanceof Gorrocoptero) {
                if (activeSound != null) {
                    Minecraft.getInstance().getSoundManager().stop(activeSound);
                    activeSound = null;
                }
            }
        }
    }
}
